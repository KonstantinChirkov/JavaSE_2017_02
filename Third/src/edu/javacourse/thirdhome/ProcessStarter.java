package edu.javacourse.thirdhome;

import edu.javacourse.thirdhome.checkers.BasicChecker;
import edu.javacourse.thirdhome.checkers.GrnChecker;
import edu.javacourse.thirdhome.checkers.StudentChecker;
import edu.javacourse.thirdhome.checkers.ZagsChecker;
import edu.javacourse.thirdhome.domain.Person;
import edu.javacourse.thirdhome.domain.PersonAdult;
import edu.javacourse.thirdhome.domain.PersonChild;
import edu.javacourse.thirdhome.domain.Student0rder;

/**
 * Created by Mozart on 02.03.2017.
 */
public class ProcessStarter {
    public void main(String[] args) {
        ProcessStarter t = new ProcessStarter();
        t.processStudent0rder();
    }

    void processStudent0rder() {
        Student0rder so = getStudent0rder();


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

    //     boolean checkGRN(Person p) {
//        System.out.println("Check:" + p.getGivenName());
////        p.setSurName("Test");
//        // Она тут много чего интересного делает
//        return true;
//    }
    private boolean checkGrn(Student0rder so) {
        GrnChecker grn = new GrnChecker("1", 2, "3", "4");

        grn.setPerson(so.getHusband());
        if (!grn.check()) {
            return false;
        }
        grn.setPerson(so.getWife());
        if (!grn.check()) {
            return false;
        }
        grn.setPerson(so.getChild());
        if (!grn.check()) {
            return false;
        }
        return true;
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
    }


    private boolean checkZags(Student0rder so) {
        ZagsChecker zc = new ZagsChecker("1", 2, "3", "4", so.getHusband(),so.getWife());
        if(!zc.check()){
            return false;
        }
        zc.setParameters(so.getChild());
        if(!zc.check()){
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

        sc.setPerson(so.getHusband());
        if(!sc.check()){
            return false;
        }
        sc.setPerson(so.getWife());
        if(!sc.check()){
            return false;
        }
        return true;
//        if (!sc.checkStudent(so.getHusband()) || !sc.checkStudent(so.getWife())) {
//            return false;
//        } else {
//            return true;
//        }
    }


    Student0rder getStudent0rder() {
        PersonAdult h = new PersonAdult();
        h.setGivenName("Мастер");
        PersonAdult w = new PersonAdult();
        w.setGivenName("Маргарита");
        PersonChild c = new PersonChild();
        c.setGivenName("Миша");

        Student0rder so = new Student0rder(h, w, c);

        return so;
    }
}
