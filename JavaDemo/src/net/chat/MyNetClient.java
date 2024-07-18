package net.chat;

import java.io.*;
import java.net.*;
import javax.swing.*;

/* 클라이언트
    - Socket 객체만 필요 (서버의 IP주소, 서버가 열어놓은 PORT번호)
 */

public class MyNetClient {
    public static void main(String[] args) throws IOException {
        String ip = "192.168.35.77";
        final int port = 6555;
        Socket socket = new Socket(ip, port);
        System.out.println("서버와 연결됨...");
        String sendMsg = JOptionPane.showInputDialog("서버에게 보낼 메시지 입력하세요");
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF(sendMsg);
        dos.flush();

        dos.close();
        os.close();
        socket.close();
    }
}
