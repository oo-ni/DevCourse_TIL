package day03;
/* InputStreamTest.java 파일을 읽어서 콘솔에 출력하세요
데이터 소스 : FileInputStream
- 1byte 기반
- Node 스트림 => 파일과 노드 연결함
데이터 목적지 : System.out
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class FileInOut {
    public static void main(String[] args) throws IOException {
        String filePath = "D:/DevCourse_TIL/JavaDemo/src/day03/InputStreamTest.java";
        FileInputStream fis = new FileInputStream(filePath);
        PrintStream ps = System.out;

        byte[] buf = new byte[10];
        int n = 0, count = 0;

        while ((n = fis.read(buf)) != -1) {
            ps.write(buf, 0, n);
            ps.flush();
            count++;
        }

        ps.println(count + "bytes");

        fis.close();
        ps.close();
    }
}
