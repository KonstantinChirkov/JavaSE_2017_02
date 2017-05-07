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
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Mozart on 26.03.2017.
 */
public class XmlDomDataSource implements StudOrderDataSource
{
    @Override
    public List<StudentOrder> getStudOrders() {
        return xmlExtractor();
    }

    public List<StudentOrder> xmlExtractor() {
        List<StudentOrder> soList = new ArrayList<>();
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse("student_orders.xml");

            Node root = document.getDocumentElement();
            NodeList orderList = root.getChildNodes();
            for (int i = 0; i < orderList.getLength(); i++) {
                Node item = orderList.item(i);
                if (item instanceof Element) {
                    NodeList persons = item.getChildNodes();
                    /* TODO -- почему мне надо здесь инициализировать значение ссылок на объект?
                       TODO -- думал достаточно в этом месте было написать "PersonAdult husband;"
                       TODO -- а затем в строке 55 инициализировать значение
                     */
                    PersonAdult husband = null;
                    PersonAdult wife = null;
                    List<PersonChild> children = null;
                    for (int j = 0; j < persons.getLength(); j++) {
                        Node person = persons.item(j);
                        if (person instanceof Element) {
                            if ("husband".equals(person.getNodeName())) {
                                husband = getPersonAdult(person);
                            }
                            if ("wife".equals(person.getNodeName())) {
                                wife = getPersonAdult(person);
                            }
                            if ("children".equals(person.getNodeName())) {
                                children = getChildren(person);
                            }
                        }
                    }
                    StudentOrder so = new StudentOrder(husband, wife, children);
                    soList.add(so);
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        int i = 0;
//        for (StudentOrder so : soList) {
//            i++;
//            System.out.println(so.getHusband().getSurName() + " (" + i + ")");
//            System.out.println(so.getHusband().getGivenName() + " (" + i + ")");
//            System.out.println(so.getWife().getSurName() + " (" + i + ")");
//            System.out.println(so.getWife().getGivenName() + " (" + i + ")");
//            int j = 0;
//            for (PersonChild pc : so.getChildren()) {
//                j++;
//                System.out.println(pc.getSurName() + " " + j + " (" + i + ")");
//                System.out.println(pc.getGivenName() + " " + j + " (" + i + ")");
//            }
//            System.out.println();
//        }
        return soList;
    }

    private PersonAdult getPersonAdult(Node person) {
        PersonAdult personAdult = new PersonAdult();
        NodeList names = person.getChildNodes();
        for (int k = 0; k < names.getLength(); k++) {
            Node name = names.item(k);
            if (name instanceof Element) {
                if ("surName".equals(name.getNodeName())) {
                    personAdult.setSurName(name.getTextContent());
                }
                if ("givenName".equals(name.getNodeName())) {
                    personAdult.setGivenName(name.getTextContent());
                }
                if ("patronymic".equals(name.getNodeName())) {
                    personAdult.setPatronymic(name.getTextContent());
                }
                if ("dateOfBirth".equals(name.getNodeName())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date dob = sdf.parse(name.getTextContent());
                        personAdult.setDateOfBirth(dob);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if ("passportSeria".equals(name.getNodeName())) {
                    personAdult.setPassportSeria(name.getTextContent());
                }
                if ("passportNumber".equals(name.getNodeName())) {
                    personAdult.setPassportNumber(name.getTextContent());
                }
                if ("setPassportDateIssue".equals(name.getNodeName())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date dob = sdf.parse(name.getTextContent());
                        personAdult.setPassportDateExpire(dob);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                if ("passportDateExpire".equals(name.getNodeName())) {
                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                    try {
                        Date dob = sdf.parse(name.getTextContent());
                        personAdult.setPassportDateExpire(dob);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return personAdult;
    }

    private List<PersonChild> getChildren(Node person) {
        List<PersonChild> children = new ArrayList<>();
        NodeList childList = person.getChildNodes();
        for (int k = 0; k < childList.getLength(); k++) {
            Node child = childList.item(k);
            if (child instanceof Element) {
                NodeList names = child.getChildNodes();
                PersonChild c = new PersonChild();
                for (int l = 0; l < names.getLength(); l++) {
                    Node name = names.item(l);
                    if (name instanceof Element) {
                        if ("surName".equals(name.getNodeName())) {
                            c.setSurName(name.getTextContent());
                        }
                        if ("givenName".equals(name.getNodeName())) {
                            c.setGivenName(name.getTextContent());
                        }
                        if ("patronymic".equals(name.getNodeName())) {
                            c.setPatronymic(name.getTextContent());
                        }
                        if ("dateOfBirth".equals(name.getNodeName())) {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                            try {
                                Date dob = sdf.parse(name.getTextContent());
                                c.setDateOfBirth(dob);
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }
                        }
                        if ("birthCertificate".equals(name.getNodeName())) {
                            c.setBirthCertificate(name.getTextContent());
                        }
                    }
                }
                children.add(c);
            }
        }
        return children;
    }
}
