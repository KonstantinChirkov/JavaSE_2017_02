package home.javacourse.student.examples;

import home.javacourse.student.domain.StudentOrder;

import java.io.*;

/**
 * Created by Mozart on 25.03.2017.
 */
public class ObjectStream {
    public void objectWriting(StudentOrder so) {
        try {
            FileOutputStream fos = new FileOutputStream("student.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(so);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        objectReading();
    }

    public void objectReading() {
        try {
            FileInputStream fis = new FileInputStream("student.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            StudentOrder so1 = (StudentOrder) ois.readObject();
            ois.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
