package home.javacourse.student.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Mozart on 04.03.2017.
 */
public class StudentOrder implements Serializable {
    private PersonAdult husband;
    private PersonAdult wife;
    private List<PersonChild> children;

    public StudentOrder(PersonAdult husband, PersonAdult wife, List<PersonChild> children) {
        this.husband = husband;
        this.wife = wife;
        this.children = children;
    }

    public PersonAdult getHusband() {
        return husband;
    }

    public PersonAdult getWife() {
        return wife;
    }

    public List<PersonChild> getChildren() {
        return children;
    }
}
