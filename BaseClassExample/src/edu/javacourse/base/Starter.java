package edu.javacourse.base;

import java.util.Date;

/**
 * Created by Mozart on 06.03.2017.
 */
public class Starter
{
    public final static String Name = "12345";
    private final String name;

    public Starter() {
        this.name = "123413435325";
    }

    public static void main(String[] args) {
        String s = "New String";
        int i = s.compareTo("Old String");
        s = s.concat("dsafsdfsg");
        boolean old = s.contains("Old");

        Date d1 = new Date(99_000_000_000L);
        System.out.println(d1);

        Date d2 = new Date (99_000_000_000L);
        if(d1.equals(d2)){
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

        SimpleClass c1
    }

}
