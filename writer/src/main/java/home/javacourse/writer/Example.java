package home.javacourse.writer;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Mozart on 22.03.2017.
 */
public class Example {
    public static void main(String[] args) {
        int count = 3;
        try {
            FileWriter writer = new FileWriter("result.txt", true);
            for (int i = 0; i < count; i++) {
                writer.append("Hello world! - " + i);
                writer.append(System.lineSeparator());
            }
            writer.append(System.lineSeparator());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
