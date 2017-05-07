package edu.javacourse.thirdhome.checkers;

import edu.javacourse.thirdhome.exception.ConnectException;
import edu.javacourse.thirdhome.exception.SendGetDataException;
import edu.javacourse.thirdhome.exception.CheckException;

/**
 * Created by Mozart on 02.03.2017.
 */
public abstract class BasicChecker {
    protected static double LEVEL = -1.000;
    protected String host;
    protected int port;
    protected String login;
    protected String password;

    public BasicChecker(String host, int port, String login, String password) {
        this.host = host;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    public boolean check() throws CheckException {
        try {
            connect();
            try {
                boolean result = sendAndGetData();
                return result;
            } catch (SendGetDataException ex) {
                throw new CheckException(ex.getMessage(),ex);
            } finally {
                dissconnect();
            }
        } catch (ConnectException ex) {
            throw new CheckException(ex.getMessage(),ex);
        }
    }

    private void connect() throws ConnectException {
        System.out.println("Basic.Connect");
        // Напишем, что мы соединимся - объязуемся
        if (Math.random() < LEVEL) {
            ConnectException ce = new ConnectException("Connection failed - host unknown");
            throw ce;
        }
    }

    private void dissconnect() {
        System.out.println("Basic.Disconnect");
        // Напишем, что мы разъединимся - объязуемся
    }

    protected abstract boolean sendAndGetData() throws SendGetDataException;
}
