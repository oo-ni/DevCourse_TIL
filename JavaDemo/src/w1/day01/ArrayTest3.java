package w1.day01;

import java.util.Random;
import java.util.Scanner;

public class ArrayTest3 {
    public static void Solution() {
        System.out.println("사람 수를 입력하세요");
        Scanner sc = new Scanner(System.in);

        Random random = new Random();
        int n = sc.nextInt();
        int[] heights = new int[n];

        System.out.println("---- 랜덤한 키 값 생성 ----");
        for (int i = 0; i < n; i++) {
            heights[i] = 100 + random.nextInt(91);
            System.out.printf("height[%d] : %d\n", i, heights[i]);
        }

        int maxHeight = heights[0];
        int minHeight = heights[0];

        for (int i = 1; i < n; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
            }
            if (heights[i] < minHeight) {
                minHeight = heights[i];
            }
        }

        // 결과 출력
        System.out.println("제일 큰 키 : " + maxHeight);
        System.out.println("제일 작은 키 : " + minHeight);

    }

    public static void main(String[] args) {
        Solution();
    }
}
