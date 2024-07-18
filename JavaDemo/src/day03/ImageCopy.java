package day03;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;

public class ImageCopy {
    public static void main(String[] args) throws Exception {
        String imgFilePath = "https://e7.pngegg.com/pngimages/713/711/png-clipart-neko-atsume-cat-maneki-neko-luck-hello-kitty-neko-atsume-cat-like-mammal-sticker.png";
        // 원격에 있는 이미지를 카피하여 "src/day03/copy.jpg" 경로에 저장하세요.
        URL url = new URL(imgFilePath);
        InputStream is = url.openStream();  // 노드 연결한 입력 스트림
        // 데이터 목적지 : File => FileOutputStream
        FileOutputStream fos = new FileOutputStream("D:/DevCourse_TIL/JavaDemo/src/day03/copy.png");

        byte[] buffer = new byte[10];
        int n = 0, count = 0;

        while ((n = is.read(buffer)) != -1) {
            fos.write(buffer, 0, n);
            fos.flush();
            count++;
        }

        System.out.println(count + "bytes");

        is.close();
        fos.close();
    }
}
