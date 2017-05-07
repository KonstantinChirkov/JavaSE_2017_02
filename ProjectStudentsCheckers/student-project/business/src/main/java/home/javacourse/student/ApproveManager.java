package home.javacourse.student;

import home.javacourse.student.answer.CheckerAnswer;
import home.javacourse.student.domain.StudentOrder;
import home.javacourse.student.examples.ObjectStream;

import java.io.*;
import java.util.List;

/**
 * Created by Mozart on 02.03.2017.
 */

public class ApproveManager {
    public void approve0rder(StudentOrder so, List<CheckerAnswer> answers) {
        System.out.println("APPROVED");

        try (FileWriter writer = new FileWriter("C:\\Java\\Work\\ProjectStudentsCheckers\\student-project\\result.txt", true)) {
            writer.append("StudentOrder:" + System.lineSeparator() + System.lineSeparator());
            for (CheckerAnswer ca : answers) {
                writer.write(ca.getMessage().toCharArray());
//                writer.append(ca.getMessage());
                writer.append(System.lineSeparator());
            }
            writer.append(System.lineSeparator());
        } catch (IOException e) {
            e.printStackTrace();
        }

        ObjectStream oc = new ObjectStream();
        oc.objectWriting(so);
    }

    public void deny0rder(StudentOrder so, List<CheckerAnswer> answers) {

    }

    public void fileCleaner() {
        try (FileWriter cleaner = new FileWriter("C:\\Java\\Work\\ProjectStudentsCheckers\\student-project\\result.txt", false)){
            cleaner.append("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
