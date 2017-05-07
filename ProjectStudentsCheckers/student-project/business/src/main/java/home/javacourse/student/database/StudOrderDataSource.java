package home.javacourse.student.database;

import home.javacourse.student.domain.StudentOrder;

import java.util.List;

/**
 * Created by Mozart on 09.04.2017.
 */
public interface StudOrderDataSource {
    List<StudentOrder> getStudOrders();
}
