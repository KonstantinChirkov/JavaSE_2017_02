package home.javacourse.synch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mozart on 01.05.2017.
 */
public class CommonClass
{
    private List<String> list = new ArrayList<>();

    public synchronized void addItem(String str) {
        list.add(str);
    }

    public synchronized int getSize() {
        return list.size();
    }
}
