package w1.day01;

import java.util.Scanner;

public class OperatorEx {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 2자리 양수를 거꾸로 뒤집어 출력하기
        String n1 = sc.next();
        String rn1 = new StringBuilder(n1).reverse().toString();
        System.out.println(rn1);

        // 4자리 양수를 거꾸로 뒤집어 출력하기
        String n2 = sc.next();
        String rn2 = new StringBuilder(n2).reverse().toString();
        System.out.println(rn2);

        /*
        아래는 화씨 를 섭씨 로 변환하는 코드이다.
        변환공식이 (Fahrenheit) (Celcius). 'C =5/9 ×(F - 32)', 라고 할 때 에 알맞은 코드를 넣으시오.
        단 변환 결과값은 소수점 셋째자리에서 반올림해야한다.
        */
        double F = sc.nextDouble();
        double C = 5.0 / 9.0 * (F - 32);
        System.out.printf("%.2f\n", C);
    }
}
