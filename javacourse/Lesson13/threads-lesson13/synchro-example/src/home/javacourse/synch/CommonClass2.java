package home.javacourse.synch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mozart on 01.05.2017.
 */
public class CommonClass2
{
    private List<String> list1 = new ArrayList<>();
    private List<String> list2 = new ArrayList<>();

    public synchronized void addItem(int i, String str) {
        if(i==1) {
            synchronized(list1) {
                list1.add(str);
            }
        }
        if(i==2) {
            synchronized(list2) {
                list2.add(str);
            }
        }
    }

    public synchronized int getSize(int i) {
        if(i==1) {
            synchronized(list1) {
                list1.size();
            }
        }
        if(i==2) {
            synchronized(list2) {
                list2.size();
            }
        }
        return i==1 ? list1.size() : list2.size();
    }
}
