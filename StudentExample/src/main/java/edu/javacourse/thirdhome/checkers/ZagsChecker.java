package edu.javacourse.thirdhome.checkers;

import edu.javacourse.thirdhome.domain.Person;
import edu.javacourse.thirdhome.exception.ConnectException;
import edu.javacourse.thirdhome.exception.SendGetDataException;

/**
 * Created by Mozart on 02.03.2017.
 */
public class ZagsChecker extends BasicChecker
{
//    public boolean checkMaritalStatus(Person husband, Person wife) {
//        // Здесь проверим брак
//        return true;
//    }
//
//    public boolean checkChild(Person person) {
//        return true;
//    }

    private Person husband;
    private Person wife;
    private Person child = null;

    public ZagsChecker(String host, int port, String login, String password, Person husband, Person Wife) {
        super(host, port, login, password);
        this.husband = husband;
        this.wife = wife;
    }

    public void setParameters (Person child){
        this.child = child;
    }

    @Override
    protected boolean sendAndGetData() throws SendGetDataException {
        if (Math.random() < LEVEL) {
            SendGetDataException sd = new SendGetDataException("Status undetected");
            throw sd;
        }
        if(child == null) {
            return checkMaritalStatus();


        } else {
            return checkChild();
        }
    }

    private boolean checkMaritalStatus() {
        System.out.println("ZagsChecker.MaritalStatus");
        return true;
    }

    private boolean checkChild() {
        System.out.println("ZagsChecker.checkChild: " + child.getGivenName());
        return true;
    }
}
