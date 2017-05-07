package home.javacourse.grn;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mozart on 30.04.2017.
 */
public class RequestHandler implements Runnable
{
    private Socket socket;

    public RequestHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            processRequest();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest() throws IOException {
        StringBuilder sb = new StringBuilder();
        Reader rd = new InputStreamReader(socket.getInputStream());
        char[] request = new char[6];
        int count = rd.read(request);
        while (count != -1) {
            // TODO <<Почему тут "-1", а не "0">>
            sb.append(new String(request, 0, count));
            if (sb.toString().endsWith("</person>")) {
                break;
            }
            count = rd.read(request);
        }
        System.out.println(sb.toString());

        boolean result;
        String message = "Person is kept in GRN";
        try {
            GrnPerson person = buildPerson(sb.toString());
            result = checkPerson(person);
        } catch (Exception e) {
            e.printStackTrace();
            result = false;
            message = "GRN-system ERROR";
        }

        OutputStream os = socket.getOutputStream();
        String ans = "<answer>" +
                "<result>" + result + "</result>" +
                "<message>" + message + "</message>" +
                "</answer>";
        os.write(ans.getBytes());

        socket.close();
    }

    private boolean checkPerson(GrnPerson person) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

    private GrnPerson buildPerson(String s) throws Exception {
        GrnPerson person = new GrnPerson();

        byte[] buffer = s.getBytes();
        ByteInputStream bis = new ByteInputStream(buffer, buffer.length);

        DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = db.parse(bis);

        NodeList childNodes = doc.getDocumentElement().getChildNodes();
        for (int k = 0; k < childNodes.getLength(); k++) {
            Node name = childNodes.item(k);
            if ("surName".equals(name.getNodeName())) {
                person.setSurName(name.getTextContent());
            }
            if ("givenName".equals(name.getNodeName())) {
                person.setGivenName(name.getTextContent());
            }
            if ("patronymic".equals(name.getNodeName())) {
                person.setPatronymic(name.getTextContent());
            }
            if ("dateOfBirth".equals(name.getNodeName())) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                try {
                    Date dob = sdf.parse(name.getTextContent());
                    person.setDateOfBirth(dob);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }
        return person;
    }
}
