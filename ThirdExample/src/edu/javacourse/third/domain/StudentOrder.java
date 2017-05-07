package edu.javacourse.third.domain;

/**
 * Created by antonsaburov on 27.02.17.
 */
public class StudentOrder
{
    private PersonAdult husband;
    private PersonAdult wife;
    private PersonChild child;

    public StudentOrder(PersonAdult husband, PersonAdult wife, PersonChild child) {
        this.husband = husband;
        this.wife = wife;
        this.child = child;
    }

    public Person getHusband() {
        return husband;
    }

    public Person getWife() {
        return wife;
    }

    public Person getChild() {
        return child;
    }
}
