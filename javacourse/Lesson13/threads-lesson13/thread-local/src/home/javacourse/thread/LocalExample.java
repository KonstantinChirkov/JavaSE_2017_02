package home.javacourse.thread;

/**
 * Created by Mozart on 30.04.2017.
 */
public class LocalExample implements Runnable
{
    private ThreadLocal<Counter> localCounter = new ThreadLocal<Counter>() {
        @Override
        protected Counter initialValue() {
            return new Counter();
        }
    };

    @Override
    public void run() {
        for(int i=0; i<5; i++) {
            localCounter.get().increase();
        }
        System.out.println(localCounter.get().getCounter());
    }

    public Long getCounter() {
        return localCounter.get().getCounter();
    }
}
