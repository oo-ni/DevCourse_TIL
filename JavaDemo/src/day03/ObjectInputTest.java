package day03;

import java.io.*;
import java.util.*;

public class ObjectInputTest {
    public static void main(String[] args) throws Exception {
        // 파일 obj.txt를 읽어서 객체를 복원해보세요.
        FileInputStream fis = new FileInputStream("D:/DevCourse_TIL/JavaDemo/src/day03/obj.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);

        List<String> arr = (ArrayList<String>) ois.readObject();
        System.out.println(arr);

        Date today = (Date) ois.readObject();
        System.out.println(today);

        Emp e1 = (Emp) ois.readObject();
        Emp e2 = (Emp) ois.readObject();

        // 출력
        System.out.println(arr.size() + "명 복원됨...");
        for (String name : arr) {
            System.out.println(name);
        }

        e1.showInfo();
        e2.showInfo();

        ois.close();
        fis.close();
    }
}
