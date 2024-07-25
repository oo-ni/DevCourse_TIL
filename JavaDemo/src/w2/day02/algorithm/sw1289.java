package w2.day02.algorithm;

import java.util.Scanner;

public class sw1289 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= T; i++) {
            String memory = sc.nextLine();
            int ans = bitChange(memory);
            System.out.printf("#%d %d\n", i, ans);
        }
    }

    public static int bitChange(String memory) {
        char init = '0';
        int change = 0;

        for (int i = 0; i < memory.length(); i++) {
            if (memory.charAt(i) != init) {
                change++;
                init = memory.charAt(i);
            }
        }

        return change;
    }
}
