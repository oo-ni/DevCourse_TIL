package w2.day05.test05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        Student s = new Student("그렙", 20);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JavaDemo/src/w2/day05/test05/student.data"));
        oos.writeObject(s);
        oos.close();
    }
}
