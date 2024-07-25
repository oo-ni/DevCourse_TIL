package w1.day03;

import java.io.*;
import java.util.*;

/* DataOutputStream/DataInputStream

- 1byte기반 스트림
- 필터 스트림
- 기능 : 자바의 다양한 자료형(Data Type)들을 바이트 단위로 분해하여 쓰고,
        이를 다시 자료형별로 복원하여 읽는 기능을 수행한다.
- 주의: DataInputStream과 DataOutputStream은 짝을 이뤄 사용해야 한다.
- [실습] data.txt 파일에 자바의 다양한 자료형 데이터를 써보자.
- 데이터 목적지 : 파일(data.txt) => FileOutputStream => DataOutputStream

 */
public class ObjectOutputTest {
    public static void main(String[] args) throws Exception {
        // 1.
        List<String> arr = new ArrayList<>();   // java.io.Serializable
        arr.add("Owen");
        arr.add("Jerry");
        System.out.println(arr.size() + "명 등록됨...");

        // 2.
        Date today = new Date();

        // 파일 obj.txt에 arr, today 객체를 써보자
        FileOutputStream fos = new FileOutputStream("D:/DevCourse_TIL/JavaDemo/src/w1.day03/obj.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(arr);
        oos.writeObject(today);

        Emp e1 = new Emp("Jed", "Sales", 5000);
        Emp e2 = new Emp("Yasuo", "Research", 6000);

        oos.writeObject(e1);
        oos.writeObject(e2);

        oos.flush();
        System.out.println("객체를 obj.txt 파일에 저장했어요.");
        fos.close();
        oos.close();
    }
}
