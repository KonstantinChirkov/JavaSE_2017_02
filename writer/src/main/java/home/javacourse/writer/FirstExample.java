package home.javacourse.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FirstExample {
    public static void main(String[] args) {
        int count = 3;
        try {
            FileWriter writer = new FileWriter("result.txt");
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

    void Second(int count) {

    }
}
