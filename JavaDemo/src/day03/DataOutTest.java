package day03;

/* DataOutputStream/DataInputStream
- 1byte기반 스트림
- 필터 스트림
- 기능 : 자바의 다양한 자료형(Data Type)들을 바이트 단위로 분해하여 쓰고,
        이를 다시 자료형별로 복원하여 읽는 기능을 수행한다.
- 주의 : DataInputStream과 DataOutputStream은 짝을 이뤄 사용해야 한다.
- [실습] data.txt 파일에 자바의 다양한 자료형 데이터를 써보자.
- 데이터 목적지 : 파일(data.txt)=>FileOutputStream => DataOutputStream
 */

import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class DataOutTest {
    public static void main(String[] args) throws Exception {
        // 1. 노드 연결
        FileOutputStream fos = new FileOutputStream("D:/DevCourse_TIL/JavaDemo/src/day03/data.txt");
        // 2. 필터 스트림
        DataOutputStream dos = new DataOutputStream(fos);

        // 자바의 다양한 자료형의 데이터를 쓴다
        byte b = 65;
        byte[] ba = {66, 67, 68};
        short s = 30;
        char ch = 'K';
        boolean bool = true;
        String str = "Google";
        dos.writeByte(b);                   // 1byte
        dos.write(ba, 0, ba.length);    // 4byte
        dos.writeShort(s);                  // 6byte
        dos.writeChar(ch);                  // 8byte
        dos.writeBoolean(bool);             // 9byte
        dos.writeUTF(str);                  // 17byte - UTF때문에 대략 8byte
        dos.flush();
        System.out.println(dos.size() + "bytes");
    }
}
