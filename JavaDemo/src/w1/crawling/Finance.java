package w1.crawling;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

import java.io.*;

public class Finance {
    public static void main(String[] args) throws Exception {
        String url = "https://finance.naver.com/item/main.naver?code=454910";

        Connection con = Jsoup.connect(url);
        Document doc = con.get();

        // 회사 이름
        Elements list1 = doc.select(".wrap_company>h2>a");
        String company = list1.get(0).text();
        System.out.println("회사 이름: " + company);

        // 회사 코드
        Elements list2 = doc.select("span.code");
        String companyCode = list2.get(0).text();
        System.out.println("회사 코드: " + companyCode);

        // 현재가, 전일 대비 차이, 증감 비율
        Elements list3 = doc.select("div.today .blind");
        System.out.println(list3);
        String price = list3.get(0).text();
        String diff = list3.get(1).text();
        String percent = list3.get(2).text();
        System.out.println("현재가: " + price);
        System.out.println("전일 대비: " + diff);
        System.out.println("증감 비율: " + percent + "%");

        // 파일명 : 회사명.txt
        // 현재가, 전일 대비 차이, 증감비율을 각각 저장하세요.

        save(company + ".txt", price, diff, percent);
    }

    private static void save(String fileName, String price, String changeAmount, String changeRate) {
        String filePath = "D:/DevCourse_TIL/JavaDemo/src/w1.crawling/" + fileName;

        try (FileWriter fw = new FileWriter(filePath)) {
            fw.write("현재가: " + price + "\n");
            fw.write("전일 대비: " + changeAmount + "\n");
            fw.write("증감 비율: " + changeRate + "%\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
