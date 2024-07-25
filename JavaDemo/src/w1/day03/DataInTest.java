package w1.day03;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class DataInTest {
    public static void main(String[] args) throws IOException {
        DataInputStream in = new DataInputStream(new FileInputStream("D:/DevCourse_TIL/JavaDemo/src/w1.day03/data.txt"));
        // 읽을 때 쓴 순서대로 자료형에 맞춰 읽는다.
        byte b = in.readByte();
        System.out.println(b);
        byte[] buf = new byte[3];
        in.read(buf);
        for (int x : buf) {
            System.out.println(x);
        }
        short s = in.readShort();
        System.out.println(s);
        char ch = in.readChar();
        boolean bool = in.readBoolean();
        String str = in.readUTF();
        System.out.println(ch);
        System.out.println(bool);
        System.out.println(str);
        in.close();
    }
}
