package w1.day03;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;

public class FileStreamTest2 {
    public static void main(String[] args) throws Exception {
        List<String> lines = List.of("첫째줄", "둘째줄", "세번째줄");
        String fname = "D:/DevCourse_TIL/JavaDemo/src/w1.day03/result2.txt";
        Path path = Paths.get(fname);
        Charset charset = Charset.forName("UTF-8");

        try (BufferedWriter bw = Files.newBufferedWriter(path, charset)) {
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
