package day02;

import java.util.Comparator;

public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> currentN;

    static class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }   // inner class

    public void addFirst(T newData) {
        Node<T> tmp = head;
        Node<T> newNode = new Node(newData, tmp);
        head = currentN = newNode;
    }

    public void addLast(T newData) {
        if (head == null) {
            addFirst(newData);
        } else {
            Node<T> end = new Node(newData, null);
            // 마지막 노드를 찾을 때까지 탐색 (선택한 노드.next == null)? --> 꼬리노드
            Node<T> ptr = head;
            while (ptr.next != null) {
                // 포인터 이동
                ptr = ptr.next;
            }
            // ptr.next가 null인 경우(꼬리)
            ptr.next = currentN = end;
        }
    }

    // 첫번째 노드 삭제
    public void removeFirst() {
        if (head == null) {
            return;
        }
        head = head.next;
        if (head == null) {
            currentN = null;
        } else {
            currentN = head;
        }
    }

    // 꼬리 노드 삭제
    public void removeLast() {
        if (head != null) {
            return;
        }
        if (head.next == null) {
            removeLast();
        } else {
            // 여러 개 있는 경우
            Node<T> ptr = head;
            // 꼬리 노드 이전 노드까지만 탐색
            while(ptr.next.next != null) {  // 마지막 노드 2개 남을 때까지 포인터 이동
                ptr = ptr.next;     // 탐색
            }
            ptr.next = null;
            currentN = ptr;
        }
    }

    // 중간 노드 삭제
    public void removeMiddle() {
        if (head == null || head.next == null) {
            return; // 리스트가 비어있거나 노드가 하나만 있는 경우 처리 불필요
        }

        Node<T> slow = head;
        Node<T> fast = head;
        Node<T> prev = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }

        if (prev != null && slow != null) {
            prev.next = slow.next;
        }
    }

    // 선택한 노드 출력
    public void printCurrentNode() {
        System.out.println("----------------");
        if (currentN == null) {
            System.out.println("선택한 노드가 없습니다.");
        } else {
            System.out.print("선택한 노드 -> " + currentN.data);
        }
        System.out.println();
    }

    // 전체 노드 출력
    public void printAllNode() {
        System.out.println("****************");
        Node<T> ptr = head;
        while (ptr != null && ptr.next != null) {
            System.out.print(ptr.data + "->");  // 데이터값 출력
            ptr = ptr.next;
        }
        if (ptr != null) {
            System.out.println(ptr.data);   // 마지막 노드 데이터값 출력
        }
        System.out.println();
    }

    // 전체 노드를 삭제하는 메서드
    public void clear() {
        while(head != null) {
            removeFirst();
        }
        currentN = null;
    }

    // 선택한 노드를 한칸 뒤로 이동시키는 메서드
    public boolean next() {
        if (currentN == null || currentN.next == null) {
            return false;
        }
        currentN = currentN.next;
        return true;
    }

    // 특정 노드를 검색하는 메서드
    public T search(T obj, Comparator<T> comparator) {
        Node<T> ptr=head;
        while (ptr!=null) {
            if (comparator.compare(obj, ptr.data)==0) {
                // 검색에 성공했다면
                currentN = ptr;
                return ptr.data;    // 검색한 데이터 반환
            }
            ptr = ptr.next;   // 이동
        }
        return null;    // 찾지 못한 경우
    }


}
