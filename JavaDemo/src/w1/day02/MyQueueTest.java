package w1.day02;

public class MyQueueTest {
    public static void main(String[] args) {
        // MyQueue 생성해서
        // 데이터 3개 저장 enque()
        // size() / deque()
        // printQueue()
        // indexOf()

        MyQueue queue = new MyQueue(5);

        queue.enque("Cat");
        queue.enque("Dog");
        queue.enque("Pig");
        queue.enque("Lion");

        System.out.println(queue.deque());
        queue.enque("Duck");
        queue.printQueue();

        int idx = queue.indexOf("Cat");
        System.out.println(idx);
        idx = queue.indexOf("Duck");
        System.out.println(idx);
    }
}
