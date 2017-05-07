package edu.javacourse.third.checkers;

import edu.javacourse.third.domain.Person;

/**
 * Created by antonsaburov on 02.03.17.
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
        System.out.println("StudentChecker.sendAndGetData:" + person.getGivenName());
        return true;
    }
}
