package edu.javacourse.third.checkers;

import edu.javacourse.third.domain.Person;

/**
 * Created by antonsaburov on 02.03.17.
 */
public class ZagsChecker extends BasicChecker
{
    private Person husband;
    private Person wife;
    private Person child;

    public ZagsChecker(String host, int port, String login, String password) {
        super(host, port, login, password);
    }

    public void setParameters(Person husband, Person wife, Person child) {
        this.husband = husband;
        this.wife = wife;
        this.child = child;
    }

    @Override
    protected boolean sendAndGetData() {
        if(child == null) {
            return checkWedding();
        } else {
            return checkChild();
        }
    }

    private boolean checkWedding() {
        System.out.println("ZagsChecker.checkWedding");
        return true;
    }

    private boolean checkChild() {
        System.out.println("ZagsChecker.checkChild");
        return true;
    }
}
