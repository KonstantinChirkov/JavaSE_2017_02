package edu.javacourse.thirdhome.checkers;

import edu.javacourse.thirdhome.domain.Person;
import edu.javacourse.thirdhome.exception.SendGetDataException;

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

    protected boolean sendAndGetData() throws SendGetDataException{
        if (Math.random() < LEVEL) {
            SendGetDataException sd = new SendGetDataException("Person unknown");
            throw sd;
        }
        System.out.println("StudentChecker.sendAndGetData: " + person.getGivenName());
        return true;
    }
}
