package home.javacourse.thread;

/**
 * Created by Mozart on 26.04.2017.
 */
public class MyThread extends Thread
{
    private String threadName;
    private volatile boolean running = true;

    public MyThread(String nameThread) {
        this.threadName = nameThread;
    }

    @Override
    public void run() {
        int i = 0;
        while(running) {
            i++;
            System.out.println(threadName + ": turn " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stopThread() {
        running = false;
    }

    public String getThreadName() {
        return threadName;
    }

    public void setThreadName(String threadName) {
        this.threadName = threadName;
    }
}
