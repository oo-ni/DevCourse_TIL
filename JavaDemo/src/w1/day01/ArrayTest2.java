package w1.day01;

public class ArrayTest2 {
    public static void main(String[] args) {
        // 2차원 배열
        int a[][];
        a = new int[2][3];
        a[0][0] = 10;
        a[0][1] = 20;
        a[0][2] = 30;

        a[1][0] = 40;
        a[1][1] = 50;
        a[1][2] = 60;

        // for 루프 이용해서 a에 저장된 값 출력
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + "\t");
            }
            System.out.println();
        }

        // 향상된 for 루프 이용해서 출력
        for (int b[]: a) {
            for (int c: b) {
                System.out.print(c + "\t");
            }
            System.out.println();
        }
    }
}
