package edu.javacourse.thirdhome.domain;

/**
 * Created by Mozart on 04.03.2017.
 */
public class Student0rder {
    private PersonAdult husband;
    private PersonAdult wife;
    private PersonChild child;

    public Student0rder(PersonAdult husband, PersonAdult wife, PersonChild child) {
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
