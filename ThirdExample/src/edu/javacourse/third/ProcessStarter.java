package edu.javacourse.third;

import edu.javacourse.third.checkers.BasicChecker;
import edu.javacourse.third.checkers.GrnChecker;
import edu.javacourse.third.checkers.StudentChecker;
import edu.javacourse.third.checkers.ZagsChecker;
import edu.javacourse.third.domain.Person;
import edu.javacourse.third.domain.PersonAdult;
import edu.javacourse.third.domain.PersonChild;
import edu.javacourse.third.domain.StudentOrder;

/**
 * Created by antonsaburov on 22.02.17.
 */
public class ProcessStarter
{
    public static void main(String[] args) {
        ProcessStarter t = new ProcessStarter();
        t.processStudentOrder();
    }

    public String toString() {
        return "ProcessStarter{}";
    }

    void processStudentOrder() {
        StudentOrder so = getStudentOrder();

        boolean result = checkGrn(so);
        if(!result) {
            return;
        }
        result = checkZags(so);
        if(!result) {
            return;
        }
        result = checkStudent(so);
        if(!result) {
            return;
        }

        ApproveManager am = new ApproveManager();
        am.approveOrder(so);
    }


    private boolean checkGrn(StudentOrder so) {
        GrnChecker grn = new GrnChecker("1", 2, "3", "4");
        grn.setPerson(so.getHusband());
        if(!grn.check()) {
            return false;
        }
        grn.setPerson(so.getWife());
        if(!grn.check()) {
            return false;
        }
        grn.setPerson(so.getChild());
        if(!grn.check()) {
            return false;
        }
        return true;

//        if(grn.checkGRN(so.getHusband())
//                && grn.checkGRN(so.getWife()) && grn.checkGRN(so.getChild())) {
//            return true;
//        }
    }

    private boolean checkZags(StudentOrder so) {
        ZagsChecker zc = new ZagsChecker("1", 2, "3", "4");
        zc.setParameters(so.getHusband(), so.getWife(), null);
        if(!zc.check()) {
            return false;
        }
        zc.setParameters(so.getHusband(), so.getWife(), so.getChild());
        if(!zc.check()) {
            return false;
        }
        return true;

        //        if(!zc.checkMaritalStatus(so.getHusband(), so.getWife())) {
//            return false;
//        }
//        if(!zc.checkChild(so.getChild())) {
//            return false;
//        }
    }

    private boolean checkStudent(StudentOrder so) {
        StudentChecker sc = new StudentChecker("1", 2, "3", "4");
        sc.setPerson(so.getHusband());
        if(!sc.check()) {
            return false;
        }
        sc.setPerson(so.getWife());
        if(!sc.check()) {
            return false;
        }
        return true;

        // Страшненько, но это работает
//        return sc.checkStudent(so.getHusband()) && sc.checkStudent(so.getWife());
//        if(sc.checkStudent(so.getHusband()) && sc.checkStudent(so.getWife())) {
//            return true;
//        }
    }

    StudentOrder getStudentOrder() {
        PersonAdult h = new PersonAdult();
        h.setGivenName(new String("Мастер"));
        PersonAdult w = new PersonAdult();
        w.setGivenName("Маргарита");
        PersonChild c = new PersonChild();
        c.setGivenName("Михаил");

        StudentOrder so = new StudentOrder(h, w, c);

        return so;
    }
}
