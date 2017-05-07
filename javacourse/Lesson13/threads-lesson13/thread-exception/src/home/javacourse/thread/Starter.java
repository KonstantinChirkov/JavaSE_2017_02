package home.javacourse.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by Mozart on 30.04.2017.
 */
public class Starter
{
    public static void main(String[] args) throws InterruptedException {
//        testOld();
        System.out.println();
        System.out.println();
        testNew();
        Thread.sleep(1000);
        System.out.println("Finish Global");
    }

    private static void testOld() {
        SimpleRunnable01 sr01 = new SimpleRunnable01();
        Thread t = new Thread(sr01);
        t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t.getState() + ": " + e.getMessage());
            }
        });
        t.start();
    }

    private static void testNew() {
        ExecutorService es = Executors.newSingleThreadExecutor();
//      ToDo что означает интерфейс Future<?>, и скобки, и вопросик в скобках
        Future<?> submit = es.submit(new SimpleRunnable01());
        try {
            submit.get();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        es.shutdown();
    }
}
