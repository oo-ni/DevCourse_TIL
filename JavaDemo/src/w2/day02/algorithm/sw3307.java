package w2.day02.algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class sw3307 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[] nums = new int[N];

            for (int j = 0; j < N; j++) {
                nums[j] = sc.nextInt();
            }

            int[] dp = new int[N];
            int ans = 0;

            // LIS 길이는 최소 1
            Arrays.fill(dp, 1);

            for (int j = 1; j < N; j++) {
                for (int k = 0; k < j; k++) {
                    if (nums[j] > nums[k] && dp[j] < dp[k] + 1) {
                        dp[j] = dp[k] + 1;
                    }
                }
            }

            for (int j= 0; j < N; j++) {
                if (dp[j] > ans) {
                    ans = dp[j];
                }
            }

            System.out.printf("#%d %d\n", i, ans);
        }

        sc.close();
    }
}
