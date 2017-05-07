package home.javacourse.student.database;

import home.javacourse.student.domain.PersonAdult;
import home.javacourse.student.domain.PersonChild;
import home.javacourse.student.domain.StudentOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mozart on 14.03.2017.
 */
public class FakeDataSource implements StudOrderDataSource{
    private static int countStud0rder = 1;
    private static int CHILD_COUNT = 2;

    @Override
    public List<StudentOrder> getStudOrders() {
        List<StudentOrder> result = new ArrayList<StudentOrder>();
        for (int i = 0; i < countStud0rder; i++) {
            result.add(getStudOrder("Husband (" + i + ")", "Wife (" + i + ")", "Child ", " (" + i + ")"));
        }
        return result;

    }

    StudentOrder getStudOrder(String hName, String wName, String cName, String No) {
        PersonAdult h = new PersonAdult();
        h.setGivenName(hName);
        PersonAdult w = new PersonAdult();
        w.setGivenName(wName);
        List<PersonChild> children = new ArrayList<PersonChild>();
        for (int j = 0; j < CHILD_COUNT; j++) {
            PersonChild c = new PersonChild();
            c.setGivenName(cName + j + No);
            children.add(c);
        }

        StudentOrder so = new StudentOrder(h, w, children);

        return so;
    }
}
