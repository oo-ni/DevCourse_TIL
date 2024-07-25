package w1.day01;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class SwitchTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("요일을 입력하세요");
        String day = sc.nextLine();

        int dayNum = switch (day) {
            case "일" -> 1;
            case "월" -> 2;
            case "화" -> 3;
            case "수" -> 4;
            case "목" -> 5;
            case "금" -> 6;
            case "토" -> {
                System.out.println("즐거운 토요일 입니다~~");
                yield 7;
            }
            default -> -1;
        };

        System.out.println("입력한 요일값 : " + dayNum);

        Calendar cal = Calendar.getInstance();
        int today = cal.get(Calendar.DAY_OF_WEEK);

        System.out.println("today : " + today);

        // 오늘로부터 입력한 가장 가까운 요일까지 며칠 남았는지 계산해서 출력하세요.
        int dayCount = (dayNum - today + 7) % 7;
        System.out.println(dayCount + "일 남았습니다.");

        // 해당 요일이 몇년 몇월 몇일인지 출력하세요.
        cal.add(Calendar.DAY_OF_YEAR, dayCount);
        System.out.println(new SimpleDateFormat("yyyy년 MM월 dd일").format(cal.getTime()));
    }
}
