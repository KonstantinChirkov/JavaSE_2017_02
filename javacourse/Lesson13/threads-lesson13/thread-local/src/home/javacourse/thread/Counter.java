package home.javacourse.thread;

/**
 * Created by Mozart on 30.04.2017.
 */
public class Counter
{
    private Long counter = new Long(0);

    public void increase() {
        counter += Math.round(Math.random()*100);
    }

    public Long getCounter() {
        return counter;
    }
}
