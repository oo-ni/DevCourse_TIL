package algorithm;

import java.util.Scanner;

public class sw5215 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int L = sc.nextInt();

            int[] score = new int[N];
            int[] cal = new int[N];

            for (int j = 0; j < N; j++) {
                score[j] = sc.nextInt();
                cal[j] = sc.nextInt();
            }

            int[] dp = new int[L + 1];

            for (int j = 0; j < N; j++) {
                for (int k = L; k >= cal[j]; k--) {
                    dp[k] = Math.max(dp[k], dp[k - cal[j]] + score[j]);
                }
            }

            System.out.printf("#%d %d\n", i, dp[L]);
        }
        sc.close();
    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//        for (int i = 1; i <= T; i++) {
//            int N = sc.nextInt();
//            int L = sc.nextInt();
//
//            int[] score = new int[N];
//            int[] cal = new int[N];
//
//            for (int j = 0; j < N; j++) {
//                score[j] = sc.nextInt();
//                cal[j] = sc.nextInt();
//            }
//
//            int maxScore = 0;
//
//            for (int j = 0; j < (1 << N); j++) {
//                int cntScore = 0;
//                int cntCal = 0;
//
//                for (int k = 0; k < N; k++) {
//                    if ((j & (1 << k)) != 0) {
//                        cntScore += score[k];
//                        cntCal += cal[k];
//                    }
//                }
//
//                if (cntCal <= L) {
//                    maxScore = Math.max(maxScore, cntScore);
//                }
//            }
//
//            System.out.printf("#%d %d\n", i, maxScore);
//        }
//
//        sc.close();
//    }
}
