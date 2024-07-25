package w1.net.chat;

import java.net.*;
import java.io.*;
import java.time.*;

/*[구현할 내용]

- Client가 Server에 접속하면
- [1] 서버로부터 먼저 "안녕하세요? 클라이언트님~~" 이란 메시지를 받는다.
- [2] 그러면 클라이언트는 키보드 입력을 통해 메시지를 보낸다.
- [3] 그러면 서버는 클라이언트로 부터 받은 메시지를 분석해서
- (1) "안녕하세요?" 또는 "하이" 란 메시지가 오면 => "반가워요~~ 클님!!!" 이라 답변하고,
- (2) "오늘 날짜는" 이란 메시지가 오면 => 오늘 날짜를 알려주고,
- (3) 그외 다른 메시지가 오면 => "~~~님, 어여 가!!"란 메시지를 보내자.

*/

public class EchoServer {
    public static void main(String[] args) throws IOException {
        final int port = 6555;
        PrintWriter out;    //클에게 답변할 스트림
        BufferedReader in;
        ServerSocket server = new ServerSocket(port);
        System.out.println("클라이언트 연결 기다림...");

        while(true) {
            Socket socket = server.accept();
            InetAddress addr = socket.getInetAddress();

            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);
            out.println("안녕하세요? 클라이언트님~~");

            String cmsg = "";
            while ((cmsg = in.readLine()) != null) {
                if (cmsg.equals("안녕하세요?") || cmsg.equals("하이")) {
                    out.println("반가워요~~ 클님!!!");
                }
                else if (cmsg.equals("오늘 날짜는")) {
                    out.println(LocalDate.now());
                }
                else {
                    out.println(addr.toString() + "님, 어여 가!!");
                }
            }
            in.close();
            out.close();
            socket.close();
        }
    }
}