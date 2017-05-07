package home.javacourse.thread;

/**
 * Created by Mozart on 30.04.2017.
 */
public class StarterLocal
{
    public static void main(String[] args) {
        LocalExample le = new LocalExample();
        for (int i = 0; i < 3; i++) {
            new Thread(le).start();
        }
    }
}
