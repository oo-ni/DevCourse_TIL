package w1.day01;

public class GopTable {
    public static void main(String[] args) {
        System.out.println("    |  1  2  3  4  5  6  7  8  9");
        System.out.println("----+------------------------------");

        for (int i = 1; i <= 9; i++) {
            System.out.printf("%3d |", i);
            for (int j = 1; j <= 9; j++) {
                System.out.printf("%3d", i * j);
            }
            System.out.println();
        }
    }
}

