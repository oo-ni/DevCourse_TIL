package w1.day03;

import java.io.IOException;
import java.nio.file.*;
import java.util.stream.*;
// Files.lines() / readAllBytes()

public class FileStreamTest {
    public static void main(String[] args) {
        String filePath = "D:/DevCourse_TIL/JavaDemo/src/w1.day03/result.txt";
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
