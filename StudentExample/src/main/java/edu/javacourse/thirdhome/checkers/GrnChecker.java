package edu.javacourse.thirdhome.checkers;

import edu.javacourse.thirdhome.domain.Person;
import edu.javacourse.thirdhome.exception.SendGetDataException;

/**
 * Created by Mozart on 02.03.2017.
 */
public class GrnChecker extends BasicChecker {
    private Person person;

    public GrnChecker(String host, int port, String login, String password) {
        super(host, port, login, password);
    }
    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    protected boolean sendAndGetData() throws  SendGetDataException{
        if (Math.random() < LEVEL) {
            SendGetDataException sd = new SendGetDataException("Person unknown");
            throw sd;
        }
        System.out.println("GrnChecker.sendAndGetData: " + person.getGivenName());
        return true;
    }


//    private String ip;
//    private int port;
//    private String login;
//    private String password;
//
//    public Boolean checkGRN(Person p) {
//        System.out.println("Check:" + p.getGivenName());
//        connect();
//        // Она тут много чего интересного делает
//        return true;
//    }
//
//    void connect() {
//        // Соединияемся с удаленной программой
//        System.out.println(ip + "," + port);
//        System.out.println(login + "/" + password);
//        ;
//    }
//
//    public String getIp() {
//        return ip;
//    }
//
//    public void setIp(String ip) {
//        this.ip = ip;
//    }
//
//    public int getPort() {
//        return port;
//    }
//
//    public void setPort(int port) {
//        this.port = port;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
}
