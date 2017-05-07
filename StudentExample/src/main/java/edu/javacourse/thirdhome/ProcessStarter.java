package edu.javacourse.thirdhome;

import edu.javacourse.thirdhome.checkers.GrnChecker;
import edu.javacourse.thirdhome.checkers.StudentChecker;
import edu.javacourse.thirdhome.checkers.ZagsChecker;
import edu.javacourse.thirdhome.database.Stud0rderGetter;
import edu.javacourse.thirdhome.domain.PersonChild;
import edu.javacourse.thirdhome.domain.Student0rder;
import edu.javacourse.thirdhome.exception.CheckException;

import java.util.List;

/**
 * Created by Mozart on 02.03.2017.
 */
public class ProcessStarter {
    public static void main(String[] args) {
        ProcessStarter t = new ProcessStarter();
        t.processList();
    }

    private void processList() {
        Stud0rderGetter sog = new Stud0rderGetter();
        List<Student0rder> orderList = sog.getStud0rderList();
//        Iterator<Student0rder> iter = orderList.iterator();
//        while(iter.hasNext()) {
//            Student0rder so = iter.next();
//            processStud0rder(so);
//        }

//        for(Iterator<Student0rder> iter = orderList.iterator();iter.hasNext();) {
//            Student0rder so = iter.next();
//            processStud0rder(so);
//        }
        for (Student0rder so : orderList) {
            processStud0rder(so);
        }
    }

    void processStud0rder(Student0rder so) {
        if (!checkGrn(so)) {
            return;
        }
        if (!checkZags(so)) {
            return;
        }
        if (!checkStudent(so)) {
            return;
        }
        ApproveManager am = new ApproveManager();
        am.approve0rder(so);
    }

    //        boolean checkGRN(Person p) {
//        System.out.println("Check:" + p.getGivenName());
//        p.setSurName("Test");
//        // Она тут много чего интересного делает
//        return true;
//    }

    private boolean checkGrn(Student0rder so) {
        GrnChecker grn = new GrnChecker("1", 2, "3", "4");
        grn.setPerson(so.getHusband());
        try {
            boolean result = grn.check();
            if (!result) {
                return false;
            }
            grn.setPerson(so.getWife());
            if (!grn.check()) {
                return false;
            }
            for (PersonChild pc : so.getChildren()) {
                grn.setPerson(pc);
                if (!grn.check()) {
                    return false;
                }
            }
        } catch (CheckException ex) {
            ex.printStackTrace();
            return false;
        } catch (Exception ex) {
            return false;
        }

        return true;
    }
//        grn.setIp("1");
//        grn.setPort(2);
//        grn.setLogin("3");
//        grn.setPassword("4");
//
//        if (!grn.checkGRN(so.getHusband()) ||
//                !grn.checkGRN(so.getWife()) || !grn.checkGRN(so.getChild())) {
//            return false;
//        } else {
//            return true;


    private boolean checkZags(Student0rder so) {
        ZagsChecker zc = new ZagsChecker("1", 2, "3", "4", so.getHusband(), so.getWife());
        try {
        if (!zc.check()) {
            return false;
        }
        for (PersonChild pc : so.getChildren()) {
            zc.setParameters(pc);
            if (!zc.check()) {
                return false;
            }
        }
//        Iterator<PersonChild> iter = so.getChildren().iterator();
//        while (iter.hasNext()) {
//            PersonChild pc = iter.next();
//            zc.setParameters(pc);
//            if (!zc.check()) {
//                return false;
//            }
//        }
//        for (Iterator<PersonChild> iter = so.getChildren().iterator(); iter.hasNext(); ) {
//            PersonChild pc = iter.next();
//            zc.setParameters(pc);
//            if (!zc.check()) {
//                return false;
//            }
//        }
        } catch (CheckException ex) {
            ex.printStackTrace();
            return false;
        }
//        if (!zc.checkMaritalStatus(so.getHusband(), so.getWife())) {
//            return false;
//        }
//        if (!zc.checkChild(so.getChild())) {
//            return false;
//        }
        return true;
    }

    private boolean checkStudent(Student0rder so) {
        StudentChecker sc = new StudentChecker("1", 2, "3", "4");

        try {
        sc.setPerson(so.getHusband());
        if (!sc.check()) {
            return false;
        }
        sc.setPerson(so.getWife());
        if (!sc.check()) {
            return false;
        }
        } catch (CheckException ex) {
            ex.printStackTrace();
            return false;
        }
        return true;

//        if (!sc.checkStudent(so.getHusband()) || !sc.checkStudent(so.getWife())) {
//            return false;
//        } else {
//            return true;
//        }
    }
}