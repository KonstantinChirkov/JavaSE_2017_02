package home.javacourse.student;

import home.javacourse.student.answer.CheckerAnswer;
import home.javacourse.student.checkers.GrnChecker;
import home.javacourse.student.checkers.StudentChecker;
import home.javacourse.student.checkers.ZagsChecker;
import home.javacourse.student.database.*;
import home.javacourse.student.domain.PersonChild;
import home.javacourse.student.domain.StudentOrder;
import home.javacourse.student.exception.CheckException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Mozart on 02.03.2017.
 */
public class ProcessStarter {
    public static void main(String[] args) {
        ProcessStarter t = new ProcessStarter();
        t.processList();
    }

    private void processList() {
        StudOrderDataSource ds = FactoryDataSource.getDataSource();
        List<StudentOrder> orderList = ds.getStudOrders();
//        Iterator<StudentOrder> iter = orderList.iterator();
//        while(iter.hasNext()) {
//            StudentOrder so = iter.next();
//            processStud0rder(so);
//        }

//        for(Iterator<StudentOrder> iter = orderList.iterator();iter.hasNext();) {
//            StudentOrder so = iter.next();
//            processStud0rder(so);
//        }

        ApproveManager am = new ApproveManager();
        am.fileCleaner();

        for (StudentOrder so : orderList) {
            processStud0rder(so);
        }
    }

    void processStud0rder(StudentOrder so) {
        List<CheckerAnswer> answers = new ArrayList<>();

        try {
            answers.addAll(checkGrn(so));
//            answers.addAll(checkZags(so));
//            answers.addAll(checkStudent(so));
        } catch (CheckException ex) {
            //TODO Сделать код обработки ошибок - что-то записать в базу
            return;
        }
        ApproveManager am = new ApproveManager();

        for (CheckerAnswer ca : answers) {
            if(!ca.getResult()) {
                am.deny0rder(so, answers);
                return;
            }
        }
        am.approve0rder(so, answers);
}


    private List<CheckerAnswer> checkGrn(StudentOrder so) throws CheckException {
        List<CheckerAnswer> answers = new ArrayList<>();
        List<Future<CheckerAnswer>> result = new ArrayList<>();

        ExecutorService es = Executors.newFixedThreadPool(4);
        GrnChecker grnH = new GrnChecker(so.getHusband());
        result.add(es.submit(grnH));

        GrnChecker grnW = new GrnChecker(so.getHusband());
        result.add(es.submit(grnW));

        for (PersonChild pc : so.getChildren()) {
            GrnChecker grnC = new GrnChecker(pc);
            result.add(es.submit(grnC));
        }

        for (Future<CheckerAnswer> f : result) {
            try {
                CheckerAnswer answer = f.get();
                answers.add(answer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        es.shutdown();
        return answers;
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


    private List<CheckerAnswer> checkZags(StudentOrder so) throws CheckException {
        List<CheckerAnswer> answers = new ArrayList<>();
        ZagsChecker zc = new ZagsChecker("192.168.0.1", 7777, "3", "4", so.getHusband(), so.getWife());

        answers.add(zc.check());

        for (PersonChild pc : so.getChildren()) {
            zc.setParameters(pc);
            answers.add(zc.check());
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
//
//        if (!zc.checkMaritalStatus(so.getHusband(), so.getWife())) {
//            return false;
//        }
//        if (!zc.checkChild(so.getChild())) {
//            return false;
//        }
        return answers;
    }

    private List<CheckerAnswer> checkStudent(StudentOrder so) throws CheckException {
        List<CheckerAnswer> answers = new ArrayList<>();
        StudentChecker sc = new StudentChecker("1", 2, "3", "4");

        sc.setPerson(so.getHusband());
        answers.add(sc.check());
        sc.setPerson(so.getWife());
        answers.add(sc.check());

        return answers;
//        if (!sc.checkStudent(so.getHusband()) || !sc.checkStudent(so.getWife())) {
//            return false;
//        } else {
//            return true;
//        }
    }
}