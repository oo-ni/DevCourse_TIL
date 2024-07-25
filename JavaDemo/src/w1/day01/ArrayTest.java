package w1.day01;

public class ArrayTest {
    public static void main(String[] args) {
        // 1. 배열 선언
        int arr[];

        // 2. 메모리 할당
        arr = new int[5];

        // 3. 초기화
        System.out.println(arr.length);

        for (int i = 1; i <= arr.length; i++) {
            arr[i - 1] += i * 10;
        }

        // 4. 출력
        for (int val : arr) {
            System.out.println(val);
        }

        String[] str = {"Java", "DB", "Spring", "React"};

        // Member 객체 3개를 생성하세요. 번호, 이름, 연락처를 주세요.
        // 1차원 배열에 저장해서 전체 회원 정보를 출력하세요.
        Member m1 = new Member(1, "Alice", "010-1234-5678");
        Member m2 = new Member(2, "Bob", "010-2345-6789");
        Member m3 = new Member(3, "Charlie", "010-3456-7890");

        // Member 객체를 1차원 배열에 저장
        Member[] members = {m1, m2, m3};

        // 전체 회원 정보 출력
        for (Member member : members) {
            System.out.println(member);
        }
    }
}
