package w1.day01;

import java.util.Arrays;
import java.util.Scanner;

public class PointSort {
    public static void main(String[] args) {
        System.out.println("(x, y) 좌표 개수 입력");
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();
        int[][] points = new int[num][2];

        for (int i = 0; i < num; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }

        Arrays.sort(points, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        for (int i = 0; i < num; i++) {
            System.out.println(points[i][0] + " " + points[i][1]);
        }

    }
}
