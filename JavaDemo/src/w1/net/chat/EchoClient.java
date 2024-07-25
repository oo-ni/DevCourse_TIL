package w1.net.chat;

import java.io.*;
import java.net.*;

/*[구현할 내용]

- Client가 Server에 접속하면
- [1] 서버로부터 먼저 "안녕하세요? 클라이언트님~~" 이란 메시지를 받는다.
- [2] 그러면 클라이언트는 키보드 입력을 통해 메시지를 보낸다.
- [3] 그러면 서버는 클라이언트로 부터 받은 메시지를 분석해서
- (1) "안녕하세요?" 또는 "하이" 란 메시지가 오면 => "반가워요~~ 클님!!!" 이라 답변하고,
- (2) "오늘 날짜는" 이란 메시지가 오면 => 오늘 날짜를 알려주고,
- (3) 그외 다른 메시지가 오면 => "~~~님, 어여 가!!"란 메시지를 보내자.

*/

public class EchoClient {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 7777);
        System.out.println("### 서버와 연결됨 ###");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);

        String smsg = br.readLine();
        System.out.println("From Server >> " + smsg);

        String cmsg = "";
        while ((cmsg = key.readLine()) != null) {
            pw.println(cmsg);
            smsg = br.readLine();
            System.out.println("From Server >> " + smsg);
        }
        key.close();
        pw.close();
        br.close();
        socket.close();
    }
}
