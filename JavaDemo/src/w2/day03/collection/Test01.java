package w2.day03.collection;

import w2.day03.exception.Student;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {
        int[] array = new int[10];  // 배열은 불변. but 빠르고 메모리 낭비가 없음.

//        ArrayList<Integer> list1 = new ArrayList<>();
//        LinkedList<Integer> list2 = new LinkedList<>();

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
        // List는 가변
        // List 인터페이스는 구현 내용은 없지만 리스트라는 자료구조가 갖춰야 하는 기능들을 나열해 놓았음.
        // ex) add, remove, get, ...
        List<Integer> list1 = new ArrayList<>();    // 실제 데이터를 배열로 관리함 (배열의 장단점을 계승) -> 데이터 변경 없이 읽기만 많이 하는 경우 (읽기 빠름. 변경, 삭제 어려움.)
        List<Integer> list2 = new LinkedList<>();   // 내부 데이터끼리 서로 주소를 기억하는 연결구조. -> 중간에 데이터 끼우고 빼고 수정 작업 많은 경우.
//        list2.add(2, 100);

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
        // 들어간 순서대로 나오기만 하면 되는 자료구조
        Queue<Integer> queue1 = new LinkedList<>(); // 인터페이스는 Queue로 선언. 실제 구현체는 LinkedList를 사용. LinkedList에 있는 기능을 다 안쓰고 제한적으로 사용하게 됨.
//        queue.add(2, 100);      // 큐는 인덱스 지정해서 추가하는 기능 필요 없는 상황에서 쓰는거임(LIFO라 필요없자나). 즉, 실제 객체에 있는 기능이라도 안쓰고 제한적으로 사용함. (목적 확실히)
        Queue<Integer> queue2 = new ArrayDeque<>(); // 코딩테스트 과정에서 중간 데이터 삽입 삭제 없고, 맨 앞 맨 뒤로만 추가 삭제할 때는 Linked보다 얘가 조금 효율적일 때가 많으니 참고.

        // 한쪽이 막혀있는 자료구조라 들어간 순서 역순으로 나옴.
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        Deque<Integer> deque = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        // 만약 코테에서 되돌아가는 기능이 필요하면... new Stack 안하고 그냥 배열 만들어서 스택처럼 인덱스 ++, -- 하는게 나을 때가 많음.
        // 지금 내가 for문 하나로 어떤 판단을 내릴 수가 없음. 갔다가 다시 되돌아와서 판단해야해. -> 이럴때 재귀를 사용하는 것.

        /* ------------------------------------------------------------------------------------------------------------------------------------------------------------------ */
        Map<String, Student> map1 = new HashMap<>();        // 키-값 형식으로 되어있는 Map에서 키값을 Hashing해서 주소값으로 저장해서 데이터를 구분함. (순서 없고, 정렬 없고)
        Map<String, Student> map2 = new LinkedHashMap<>();  // 들어가는 순서 유지해줌.
        Map<String, Student> map3 = new TreeMap<>();        // 키의 정렬 기준으로 순서를 맞춰줌.
    }
}
