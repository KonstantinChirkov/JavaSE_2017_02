package home.javacourse.synch;

/**
 * Created by Mozart on 01.05.2017.
 */
public class ListThread implements Runnable
{
    private CommonClass cc;

    public ListThread(CommonClass cc) {
        this.cc = cc;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            cc.addItem(Math.round(Math.random()*100) + "");
        }
    }
}
