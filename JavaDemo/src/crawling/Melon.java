package crawling;

import java.util.*;
import java.io.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class Melon {
    String url = "https://www.melon.com/chart/index.htm";

    public List<MelonVO> Melon(String url) {
        List<MelonVO> list = new ArrayList<>();

        try {
            Document doc = Jsoup.connect(url).get();
            Elements root = doc.select("div.d_song_list");
            Elements ranks = root.select("span.rank");
            Elements titles = root.select("div.rank01 span a");
            Elements singers = doc.select("div.rank02 span a");
            Elements albumImages = doc.select("div.wrap a img");

            for (int i = 0; i < ranks.size() - 1; i++) {
                String rank = ranks.get(i + 1).text();
                String title = titles.get(i).text();
                StringBuilder sb = new StringBuilder();
                Elements singerElements = singers.get(i).parent().select("a");
                for (Element singer : singerElements) {
                    if (sb.length() > 0) {
                        sb.append(", ");
                    }
                    sb.append(singer.text());
                }
                String singer = sb.toString();
                String albumImage = albumImages.get(i).attr("src");

                MelonVO vo = new MelonVO(i + 1, Integer.toString(i + 1), title, singer, albumImage);
                list.add(vo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void saveMelonList(List<MelonVO> arr) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/DevCourse_TIL/JavaDemo/src/crawling/melon_240718.txt"))) {
            oos.writeObject(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadMelonList(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            List<MelonVO> list = (List<MelonVO>) ois.readObject();
            for (MelonVO vo : list) {
                System.out.println(vo);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Melon melon = new Melon();
        List<MelonVO> melonList = melon.Melon(melon.url);
        melon.saveMelonList(melonList);
        melon.loadMelonList("D:/DevCourse_TIL/JavaDemo/src/crawling/melon_240718.txt");
    }

    public static String toJson(List<MelonVO> arr) {
        String jsonStr = null;
        ObjectMapper mapper = new ObjectMapper();
        // 객체를 JSON으로 직렬화 -> writeValueAsString()
        // JSON을 객체로 역직렬화 -> readValue(json, class)
        try{
            jsonStr = mapper.writeValueAsString(arr);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return jsonStr;
    }
}