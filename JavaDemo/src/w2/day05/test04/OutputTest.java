package w2.day05.test04;

import java.io.*;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("JavaDemo/src/w2/day05/test04/ttttt2")));

        bw.write("이 메세지가 편하게 파일로 전달됩니다. 전송 효율도 보장되지요.");
        bw.flush();     // 데이터 흘려보내기
        bw.close();
    }
}
