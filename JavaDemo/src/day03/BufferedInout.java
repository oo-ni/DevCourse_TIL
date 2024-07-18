package day03;

import java.io.*;

public class BufferedInout {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter fout = new BufferedWriter(new FileWriter("D:/DevCourse_TIL/JavaDemo/src/day03/result.txt"));
        PrintWriter pw = new PrintWriter(System.out, true);

        String line;
        int count = 1;
        System.out.println("메시지를 입력하세요 => ");

        while ((line = br.readLine()) != null) {
//            bw.write(count++ + " : " + line + "\n");
//            fout.write(count++ + " : " + line + "\n");
            pw.println(count++ + " : " + line);
        }
        br.close();
        bw.close();
        fout.close();
    }
}
