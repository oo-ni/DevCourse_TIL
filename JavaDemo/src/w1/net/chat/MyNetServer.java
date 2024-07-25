package w1.net.chat;

import java.io.*;
import java.net.*;

public class MyNetServer {
    public static void main(String[] args) throws IOException {
        final int port =6555;
        ServerSocket server = new ServerSocket(port);
        System.out.println("클라이언트 연결을 기다림...");

        while (true) {
            Socket socket = server.accept();
            InetAddress inet = socket.getInetAddress();
            System.out.println(inet.getHostAddress() + "님이 접속했어요");
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String clientMsg = dis.readUTF();
            System.out.println("클라이언트로부터 >> " + clientMsg);

            dis.close();
            socket.close();
        }
    }
}
