package home.javacourse.student.checkers;

import home.javacourse.student.answer.CheckerAnswer;
import home.javacourse.student.checkers.answer.BasicCheckerAnswer;
import home.javacourse.student.domain.Person;
import home.javacourse.student.exception.SendGetDataException;

/**
 * Created by Mozart on 02.03.2017.
 */
public class StudentChecker extends BasicChecker
{
    private Person person;

    public StudentChecker(String host, int port, String login, String password) {
        super(host, port, login, password);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    protected CheckerAnswer sendAndGetData() throws SendGetDataException{
        System.out.println("StudentChecker.sendAndGetData: " + person.getGivenName());
        return new BasicCheckerAnswer(true, "StudentChecker: " + person.getGivenName());
    }
}
