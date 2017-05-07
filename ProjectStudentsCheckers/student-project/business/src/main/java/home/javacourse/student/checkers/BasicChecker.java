package home.javacourse.student.checkers;

import home.javacourse.student.answer.CheckerAnswer;
import home.javacourse.student.exception.ConnectException;
import home.javacourse.student.exception.SendGetDataException;
import home.javacourse.student.exception.CheckException;

import java.io.*;
import java.net.Socket;

/**
 * Created by Mozart on 02.03.2017.
 */
public abstract class BasicChecker
{
    protected String host;
    protected int port;
    protected String login;
    protected String password;

    protected Socket socket;

    public BasicChecker(String host, int port, String login, String password) {
        this.host = host;
        this.port = port;
        this.login = login;
        this.password = password;
    }

    public CheckerAnswer check() throws CheckException {
        try {
            connect();
            try {
                CheckerAnswer result = sendAndGetData();
                return result;
            } catch (SendGetDataException ex) {
                throw new CheckException(ex.getMessage(),ex);
            } finally {
                disconnect();
            }
        } catch (ConnectException ex) {
            throw new CheckException(ex.getMessage(), ex);
        }
    }

    private void connect() throws ConnectException {
        try {
            socket = new Socket(host, port);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConnectException(e.getMessage(), e);
        }

    }

    private void disconnect() throws ConnectException {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new ConnectException(e.getMessage(), e);
        }
    }

    protected abstract CheckerAnswer sendAndGetData() throws SendGetDataException;
}
