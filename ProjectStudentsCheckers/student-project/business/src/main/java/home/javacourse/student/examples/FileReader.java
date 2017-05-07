package home.javacourse.student.examples;

import java.io.*;

/**
 * Created by Mozart on 25.03.2017.
 */
public class FileReader {
    public static void main (String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\Java\\Work\\student-project\\result.txt");
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
            isr.close();
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
