package w2.day05.test03;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("JavaDemo/src/w2/day05/test03/ttttt");

//        for (int i = 0; i < 10; i++) {
//            fos.write(i);
//        }

        String msg = "안녕하세요";
        byte[] bytes = msg.getBytes();  // 문자열을 byte 배열로 변환

        for (byte b : bytes) {
            fos.write(b);
        }

        fos.close();
    }
}
