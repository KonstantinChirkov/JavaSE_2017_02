package edu.javacourse.thirdhome.checkers;

/**
 * Created by Mozart on 02.03.2017.
 */
public abstract class BasicChecker {
    protected String host;
    protected int port;
    protected String login;
    protected String password;

    public BasicChecker(String host, int port, String login, String password) {
        this.host= host;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    public boolean check() {
         connect();
        boolean result = sendAndGetData();
        dissconnect();
        return result;
    }

    private void connect() {
        System.out.println("Basic.Connect");
        // Напишем, что мы соединимся - объязуемся
    }

    private void dissconnect() {
        System.out.println("Basic.Disconnect");
        // Напишем, что мы разъединимся - объязуемся
    }

    protected abstract boolean sendAndGetData();
}
