package home.javacourse.student.database;

import home.javacourse.student.domain.StudentOrder;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;

/**
 * Created by Mozart on 09.04.2017.
 */
public class FactoryDataSource {
    private static String className = "home.javacourse.student.database.FakeDataSource";

    public static StudOrderDataSource getDataSource() {
        try {
            Class aClass = Class.forName(className);
            Object o = aClass.newInstance();
            StudOrderDataSource ds = (StudOrderDataSource) o;
            return ds;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new FakeDataSource();
    }
}
