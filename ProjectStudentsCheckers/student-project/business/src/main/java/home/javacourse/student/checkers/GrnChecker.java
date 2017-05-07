package home.javacourse.student.checkers;

import home.javacourse.student.answer.CheckerAnswer;
import home.javacourse.student.checkers.answer.BasicCheckerAnswer;
import home.javacourse.student.domain.Person;
import home.javacourse.student.exception.CheckException;
import home.javacourse.student.exception.SendGetDataException;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by Mozart on 02.03.2017.
 */
public class GrnChecker extends BasicChecker implements Callable<CheckerAnswer>
{
    private static Map<String, String> settings = new HashMap<>();


    static {
//        Properties pr = new Properties();
//        try {
//            pr.load(new FileInputStream("grn_checker.properties"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        PropertyResourceBundle prb = (PropertyResourceBundle)
                PropertyResourceBundle.getBundle("grn_checker", new Locale("en"));
        settings.put("host", prb.getString("grn.host"));
        settings.put("port", prb.getString("grn.port"));
        settings.put("login", prb.getString("grn.login"));
        settings.put("password", prb.getString("grn.password"));

        System.out.println(prb.getString("grn.test"));
    }

    private Person person;

    public GrnChecker(Person person) {
        super(settings.get("host"), Integer.parseInt(settings.get("port")), settings.get("login"), settings.get("password"));
        this.person = person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public CheckerAnswer call() throws Exception {
        System.out.println(new Date());
        CheckerAnswer check = check();
        System.out.println(new Date());
        return check();
    }

    @Override
    protected CheckerAnswer sendAndGetData() throws SendGetDataException {
        try {
            OutputStream os = socket.getOutputStream();
            StringBuilder sb = new StringBuilder(buildXmlForPerson());
            os.write(sb.toString().getBytes());
//            TODO нужен ли здесь этот flush
            os.flush();

            StringBuilder ans = new StringBuilder();
            Reader rd = new InputStreamReader(socket.getInputStream());
            char[] request = new char[6];
            int count = rd.read(request);
            while (count != -1) {
                // TODO <<Почему тут "-1", а не "0">>
                ans.append(new String(request, 0, count));
                if (ans.toString().endsWith("</answer>")) {
                    break;
                }
                count = rd.read(request);
            }
            System.out.println(ans);
            CheckerAnswer answer = buildAnswer(ans.toString());
            return answer;
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
            throw new SendGetDataException(e.getMessage(), e);
        }
    }

    private String buildXmlForPerson() throws IOException, XMLStreamException {
//        ByteOutputStream bos = new ByteOutputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        XMLOutputFactory factory = XMLOutputFactory.newFactory();
        XMLStreamWriter xml = factory.createXMLStreamWriter(baos);

        xml.writeStartDocument();
        xml.writeStartElement("person");

        xml.writeStartElement("surName");
        xml.writeCharacters(person.getSurName());
        xml.writeEndElement();
        xml.writeStartElement("givenName");
        xml.writeCharacters(person.getGivenName());
        xml.writeEndElement();
        xml.writeStartElement("patronymic");
        xml.writeCharacters(person.getPatronymic());
        xml.writeEndElement();
        xml.writeStartElement("dateOfBirth");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        person.setDateOfBirth(new Date());
        xml.writeCharacters(sdf.format(person.getDateOfBirth()));
        xml.writeEndElement();

        xml.writeEndElement();
        xml.writeEndDocument();
        String answer = new String(baos.toByteArray(), 0, baos.size(), "utf-8");
        baos.close();
        return answer;
    }

    private CheckerAnswer buildAnswer(String s) {
        final String RES_S = "<result>";
        final String RES_E = "</result>";
        final String MES_S = "<message>";
        final String MES_E = "</message>";

        int r1 = s.indexOf(RES_S);
        int r2 = s.indexOf(RES_E);
        int m1 = s.indexOf(MES_S);
        int m2 = s.indexOf(MES_E);

        boolean result = Boolean.parseBoolean(s.substring(r1 + RES_S.length(), r2));
        String message = s.substring(m1 + MES_S.length(), m2);

        CheckerAnswer answer = new BasicCheckerAnswer(result, message);
        return answer;
    }
}