package edu.javacourse.thirdhome.checkers;

import edu.javacourse.thirdhome.domain.Person;

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

    protected boolean sendAndGetData() {
        System.out.println("StudentChecker.sendAndGetData: " + person.getGivenName());
        return true;
    }
}
