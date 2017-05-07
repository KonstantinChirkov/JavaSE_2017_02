package edu.javacourse.third.checkers;

import edu.javacourse.third.domain.Person;

/**
 * Created by antonsaburov on 27.02.17.
 */
public class GrnChecker extends BasicChecker
{
    private Person person;

    public GrnChecker(String host, int port, String login, String password) {
        super(host, port, login, password);
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    protected boolean sendAndGetData() {
        System.out.println("GrnChecker.sendAndGetData:" + person.getGivenName());
        return true;
    }
}
