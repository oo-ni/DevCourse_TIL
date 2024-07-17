package day01;

import java.util.Scanner;

public class Conversion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("10진수 숫자를 입력하세요 :");
        int decimal = sc.nextInt();

        String binary = Integer.toBinaryString(decimal);

        System.out.println(decimal + " -> 2진수로 변환 -> " + binary);
    }
}
