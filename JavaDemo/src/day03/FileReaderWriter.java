package day03;

import java.io.*;

public class FileReaderWriter {
    public static void main(String[] args) throws Exception {
        char[] data = new char[1000];
        FileReader fr = new FileReader("D:/DevCourse_TIL/JavaDemo/src/day03/ImageCopy.java");
        FileWriter fw = new FileWriter("D:/DevCourse_TIL/JavaDemo/src/day03/ImageCopy.txt");

        int n;

        while ((n = fr.read(data)) != -1) {
            fw.write(data, 0, n);
            fw.flush();
        }

        fr.close();
        fw.close();
    }

}
