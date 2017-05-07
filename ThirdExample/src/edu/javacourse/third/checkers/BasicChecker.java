package edu.javacourse.third.checkers;

/**
 * Created by antonsaburov on 02.03.17.
 */
public abstract class BasicChecker
{
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

    public boolean check() {
        connect();
        boolean result = sendAndGetData();
        disconnect();
        return result;
    }

    private void connect() {
        System.out.println("Basic.connect");
        // Напишем, что мы соединимся - обязуемся
    }

    private void disconnect() {
        System.out.println("Basic.disconnect");
        // Напишем, что мы соединимся - обязуемся
    }

    protected abstract boolean sendAndGetData();
}
