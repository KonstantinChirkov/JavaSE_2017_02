package home.javacourse.synch;

/**
 * Created by Mozart on 01.05.2017.
 */
public class ListThread2 implements Runnable
{
    private CommonClass2 cc;

    public ListThread2(CommonClass2 cc) {
        this.cc = cc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            cc.addItem(i % 2 + 1, Math.round(Math.random()*100) + "");
        }
    }
}
