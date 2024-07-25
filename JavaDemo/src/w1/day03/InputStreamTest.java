package w1.day03;
/* 키보드 입력
노드 스트림 : System.in => InputStream
1 byte 기반 스트림
public int read()
 */

import java.io.IOException;

public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        int n = 0;
        int count = 0;
        byte[] buf = new byte[6];
        int total = 0;
        while ((n = System.in.read(buf)) != -1) {
            // 입력받은 데이터 => buf 배열에 담겨있다.
            // n => 입력받은 바이트 수
//            System.out.println((char)n);
            System.out.write(buf, 0, n);
            System.out.flush();
            count++;        // 반복문 횟수
            total += n;     // 읽은 바이트 수
        }
        System.out.println(total + "bytes 읽음");
        System.in.close();
        System.out.close();
    }
}
