package home.javacourse.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mozart on 26.04.2017.
 */
public class Starter
{
    public static void main(String[] args) {
        List<MyThread> list = new ArrayList<>();
        for (int i = 0; i < 5; ) {
            i++;
            MyThread mt = new MyThread("Thread No" + i);
//            mt.setThreadName("Thread No" + i);
//            mt.setDaemon(true);
            mt.start();
            list.add(mt);
        }
        System.out.println("Started");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (MyThread mt : list) {
            mt.stopThread();
        }
        System.out.println("Main method is done");
        annoExample();
    }

    private static void annoExample() {
        Thread t = new Thread () {
            @Override
            public void run() {
                System.out.println("Annonymous");
            }
        };
        t.start();
    }
}
