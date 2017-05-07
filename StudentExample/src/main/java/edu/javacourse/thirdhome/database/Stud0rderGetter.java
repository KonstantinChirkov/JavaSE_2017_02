package edu.javacourse.thirdhome.database;

import edu.javacourse.thirdhome.domain.PersonAdult;
import edu.javacourse.thirdhome.domain.PersonChild;
import edu.javacourse.thirdhome.domain.Student0rder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mozart on 14.03.2017.
 */
public class Stud0rderGetter {
    private static int countStud0rder = 3;
    private static int CHILD_COUNT = 3;

    public List<Student0rder> getStud0rderList() {
        List<Student0rder> result = new ArrayList<Student0rder>();
        for (int i = 0; i < countStud0rder; i++) {
            result.add(getStud0rder("Husband " + i, "Wife " + i, "Child "));
        }
        return result;

    }

    Student0rder getStud0rder(String hName, String wName, String cName) {
        PersonAdult h = new PersonAdult();
        h.setGivenName(hName);
        PersonAdult w = new PersonAdult();
        w.setGivenName(wName);
        List<PersonChild> children = new ArrayList<PersonChild>();
        for (int i = 0; i < CHILD_COUNT; i++) {
            PersonChild c = new PersonChild();
            c.setGivenName(cName + i);
            children.add(c);
        }

        Student0rder so = new Student0rder(h, w, children);

        return so;
    }
}
