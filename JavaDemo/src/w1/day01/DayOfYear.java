package w1.day01;

import java.util.Scanner;

/* 윤년의 판단 기준
- 년도를 4로 나누어 떨어지면서 100으로는 나누어 떨어지면 안된다.
- 다만 400으로 나누어 떨어지면 윤년.
 */
public class DayOfYear {
    Scanner sc = new Scanner(System.in);

    int[][] daysInMonth = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },     // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }      // 윤년
    };

    public void input_date(){
        while (true) {
            System.out.println("년 : ");
            int year = sc.nextInt();
            System.out.println("월 : ");
            int month = sc.nextInt();
            System.out.println("일 : ");
            int day = sc.nextInt();
            sumDays(year, month, day);

            System.out.println("한번 더 하시겠습니까? [1. 예, 2. 아니오]:");
            int choice = sc.nextInt();
            if (choice == 2) {
                System.out.println("Bye Bye~");
                break;
            }
        }
    }

    // 윤년 여부 계산
    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 != 0 || year % 400 == 0) {
                return true;
            }
        }
        return false;
    }

    // 경과 일수 계산
    public void sumDays(int year, int month, int day) {
        boolean leapYear = isLeapYear(year);
        int leap = leapYear ? 1 : 0;

        int dayCounts = 0;
        for (int i = 0; i < month - 1; i++) {
            System.out.println((i + 1) + "월: " + daysInMonth[leap][i] + "일");
            dayCounts += daysInMonth[leap][i];
        }
        System.out.println(month + "월: " + day + "일");
        dayCounts += day;

        System.out.println("total: " + dayCounts);
        System.out.println(year + "년 " + dayCounts + "일째 입니다.");
    }

    public static void main(String[] args) {
        DayOfYear dayOfYear = new DayOfYear();
        dayOfYear.input_date();
    }
}