package w1.day01;

import java.util.Scanner;

public class OperatorEx2 {
    public static void main(String[] args) {
        /*
        -------------------------------------------
        비만도 측정(BMI지수)
        BMI를 이용한 비만도 계산은 자신의 몸무게를 키의 제곱으로
        나누는 것으로 공식은 kg/㎡. BMI가 18.5 이하면 저체중 ／
        18.5 ~ 24.9 사이면 정상 ／ 25.0 ~ 29.9 사이면 과체중 ／
        30.0 이상부터는 비만으로 판정.
        신체질량지수
        (BMI) = 체중(kg)/[신장(m)]2
        -------------------------------------------
        주의: 키 입력: 키를 cm 단위로 입력받습니다.
        단위 변환: 입력받은 cm 단위의 키를 m 단위로 변환합니다 (heightCm / 100).
        BMI 계산: 변환된 키를 사용하여 BMI를 계산합니다.
        */

        Scanner sc = new Scanner(System.in);

        double weight = sc.nextDouble();
        double heightCm = sc.nextDouble();

        double bmi = calculate(heightCm, weight);

        String category = category(bmi);

        System.out.printf("%.2f\n", bmi);
        System.out.println(category);
    }

    public static double calculate(double heightCm, double weight) {
        double heightM = heightCm / 100;
        return weight / (heightM * heightM);
    }

    public static String category(double bmi) {
        if (bmi <= 18.5) {
            return "저체중";
        } else if (bmi <= 24.9) {
            return "정상";
        } else if (bmi <= 29.9) {
            return "과체중";
        } else {
            return "비만";
        }
    }
}
