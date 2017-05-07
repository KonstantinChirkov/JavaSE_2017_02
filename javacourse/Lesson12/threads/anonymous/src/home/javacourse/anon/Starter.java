package home.javacourse.anon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Mozart on 29.04.2017.
 */
public class Starter
{
    public static void main(String[] args) {
        List<MyClass> list = new ArrayList<>();
        list.add(new MyClass("1"));
        list.add(new MyClass("5"));
        list.add(new MyClass("3"));
        list.add(new MyClass("4"));
        list.add(new MyClass("8"));
        list.add(new MyClass("12"));

        Collections.sort(list, new Comparator<MyClass>()
                {
                    @Override
                    public int compare(MyClass o1, MyClass o2) {
                        return o1.getName().compareTo(o2.getName());
                    }
                });

        for(MyClass mc : list) {
            System.out.println(mc.getName());
        }

        System.out.println("------------------");

        Collections.sort(list, new Comparator<MyClass>()
        {
            @Override
            public int compare(MyClass o1, MyClass o2) {
                return -o1.getName().compareTo(o2.getName());
            }
        });

        for(MyClass mc : list) {
            System.out.println(mc.getName());
        }
    }
}
