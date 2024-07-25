package w2.day03.test02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int n1 = sc.nextInt();  // InputMismatchException
            int n2 = sc.nextInt();

            int result = n1/n2;     // ArithmeticException

            System.out.println("나누기 실행 결과 : " + result);
        } catch (InputMismatchException e) {
            System.out.println("아 쫌 숫자 입력 하랬잖아요 ㅠㅠ");
        } catch (ArithmeticException e) {
            System.out.println("0으로 나누려면 정수로는 안되는데 ㅠㅠ");
        } finally {
            System.out.println("마참내...?");
        }
        System.out.println("프로그램 종료");

    }
}

/* 객체지향 프로그래밍 (OOP)
- 캡슐화(정보은닉) -> 덩어리, 껍데기
- 상속
- 다형성
 */