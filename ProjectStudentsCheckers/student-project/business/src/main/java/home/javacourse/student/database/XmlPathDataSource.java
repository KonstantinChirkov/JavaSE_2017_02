package home.javacourse.student.database;

import home.javacourse.student.domain.PersonAdult;
import home.javacourse.student.domain.PersonChild;
import home.javacourse.student.domain.StudentOrder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mozart on 07.04.2017.
 */
public class XmlPathDataSource  implements StudOrderDataSource
{
    @Override
    public List<StudentOrder> getStudOrders() {
        return xmlExtractor();
    }

    public List<StudentOrder> xmlExtractor()  {
        List<StudentOrder> soList = new ArrayList<>();
        try {
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = db.parse("student_orders.xml");

            List<Integer> ids = extractOrdersId(document);

            for (Integer id : ids) {
                PersonAdult husband = getPerson(document, id, "husband");
                PersonAdult wife = getPerson(document, id, "wife");
                List<PersonChild> children = getChildren(document, id);
                StudentOrder so = new StudentOrder(husband, wife, children);
                soList.add(so);
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XPathExpressionException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return soList;
    }

    private List<Integer> extractOrdersId(Document document) throws XPathExpressionException {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();

        List<Integer> result = new ArrayList<>();
        XPathExpression expr = xpath.compile("student-orders/student-order");
        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
//            System.out.println(n.getNodeName());
            int id = Integer.parseInt(((Element) n).getAttribute("so-id"));
            result.add(id);
        }
        return result;
    }

    public List<PersonChild> getChildren(Document document, int no) throws XPathExpressionException {
        List<PersonChild> children = new ArrayList<>();
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();
        String s = String.format("student-orders/student-order[%d]/children/child", no);
//        System.out.println(s);

        XPathExpression expr = xpath.compile(s);
        NodeList nodes = (NodeList) expr.evaluate(document, XPathConstants.NODESET);

        int noC = 0;
        for (int i = 0; i < nodes.getLength(); i++) {
            Node item = nodes.item(i);
            if (item instanceof Element) {
                noC++;
                PersonChild child = getChild(document, no, noC);
                children.add(child);
            }
        }
        return children;
    }

    public PersonAdult getPerson(Document document, int no, String person) throws XPathExpressionException, ParseException {
        PersonAdult husband = new PersonAdult();
        husband.setSurName(getField(document, no, person, "surName"));
        husband.setGivenName(getField(document, no, person, "givenName"));
        husband.setPatronymic(getField(document, no, person, "patronymic"));
        husband.setDateOfBirth(getDateField(document, no, person, "dateOfBirth"));
        husband.setPassportSeria(getField(document, no, person, "passportSeria"));
        husband.setPassportNumber(getField(document, no, person, "passportNumber"));
        husband.setPassportDateIssue(getDateField(document, no, person, "passportDateIssue"));
        husband.setPassportDateExpire(getDateField(document, no, person, "passportDateExpire"));
//        System.out.println(husband.getSurName());
        return husband;
    }

    private PersonChild getChild(Document document, int no, int noC) throws XPathExpressionException {
        PersonChild child = new PersonChild();
        String path = String.format("children/child[%d]", noC);
//        System.out.println(path);

        child.setSurName(getField(document, no, path, "surName"));
        child.setGivenName(getField(document, no, path, "givenName"));
        child.setPatronymic(getField(document, no, path, "patronymic"));
        child.setBirthCertificate(getField(document, no, path, "birthCertificate"));
        return child;
    }

    public String getField(Document document, int no, String person, String fieldName) throws XPathExpressionException {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();
        String s = String.format("student-orders/student-order[%d]/%s/%s", no, person, fieldName);
//        System.out.println(s);

        XPathExpression expr = xpath.compile(s);
        Node field = (Node) expr.evaluate(document, XPathConstants.NODE);
        String fieldConsist = field.getTextContent();

//        System.out.println(fieldConsist);
        return field.getTextContent();
    }

    public Date getDateField(Document document, int no, String person, String fieldName) throws XPathExpressionException, ParseException {
        XPathFactory pathFactory = XPathFactory.newInstance();
        XPath xpath = pathFactory.newXPath();
        String s = String.format("student-orders/student-order[%d]/%s/%s", no, person, fieldName);
//        System.out.println(s);
        XPathExpression expr = xpath.compile(s);
        Node field = (Node) expr.evaluate(document, XPathConstants.NODE);
//        System.out.println(field.getTextContent());

        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        Date dob = sdf.parse(field.getTextContent());

//        System.out.println(dob);
        return dob;
    }
}
