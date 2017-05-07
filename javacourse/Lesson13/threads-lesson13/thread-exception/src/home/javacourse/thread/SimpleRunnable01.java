package home.javacourse.thread;

/**
 * Created by Mozart on 30.04.2017.
 */
public class SimpleRunnable01 implements Runnable
{
    @Override
    public void run() {
        System.out.println("Simple Runnable 01 - Start");
        if(true) {
            throw new RuntimeException("Exception 01");
        }
        System.out.println("Simple Runnable 01 - Finish");
    }
}
