package w2.day04.bruteforce;

import java.util.Arrays;

public class Test03_조합_for {
    static int N = 5, R = 3;
    static String[] cards = {"A", "B", "C", "D", "E"};      // 순열의 재료가 되는 대상 (뽑히는 애들)
    static String[] result = new String[R];

    static void comb(int cnt, int start) {
        if (cnt == R) {     // R개가 뽑혀서 result 배열에 채워져있음!
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = start; i < N; i++) {
            result[cnt] = cards[i];
            comb(cnt + 1, i + 1);       // i를 start로 실수해버리는 경우가 많음.
        }

    }

    public static void main(String[] args) {
        comb(0, 0);
    }
}
