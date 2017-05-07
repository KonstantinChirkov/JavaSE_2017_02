package home.javacourse.student.checkers;

import home.javacourse.student.answer.CheckerAnswer;
import home.javacourse.student.checkers.answer.BasicCheckerAnswer;
import home.javacourse.student.domain.Person;
import home.javacourse.student.exception.ConnectException;
import home.javacourse.student.exception.SendGetDataException;

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
    protected CheckerAnswer sendAndGetData() throws SendGetDataException {
        if(child == null) {
            return checkMaritalStatus();


        } else {
            return checkChild();
        }
    }

    private CheckerAnswer checkMaritalStatus() {
        System.out.println("ZagsChecker.MaritalStatus");
        return new BasicCheckerAnswer(true, "ZagsChecker.checkMaritalStatus");
    }

    private CheckerAnswer checkChild() {
        System.out.println("ZagsChecker.checkChild: " + child.getGivenName());
        return new BasicCheckerAnswer(true, "ZagsChecker.checkChild: "  + child.getGivenName());
    }
}
