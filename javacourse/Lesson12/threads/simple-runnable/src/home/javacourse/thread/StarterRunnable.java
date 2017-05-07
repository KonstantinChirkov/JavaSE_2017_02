package home.javacourse.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mozart on 29.04.2017.
 */
public class StarterRunnable
{
    public static void main(String[] args) throws InterruptedException {
        List<MyRunnable> list = new ArrayList<>();
        for (int i = 0; i < 5; ) {
            i++;
            MyRunnable mt = new MyRunnable("Thread No" + i);
            Thread t = new Thread(mt);
            t.start();
            list.add(mt);
        }
        System.out.println("Started");
            Thread.sleep(5000);
        for (MyRunnable mt : list) {
            mt.stopThread();
        }
    }
}
