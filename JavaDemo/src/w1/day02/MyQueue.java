package w1.day02;

public class MyQueue {
    private Object[] queue; // 배열 -> 큐
    private int capacity;   // 큐의 크기
    private int front;      // 맨 아파 요소 포인터 -> deque 할 때는 앞(front)에서부터 나와야 함
    private int rear;       // 맨 뒤 요소 포인터 -> enque 할 때는 뒤(rear)에서부터 들어가야 함
    private int cnt;        // 현재 데이터 수

    public MyQueue(int capacity) {
        this.capacity = capacity;
        queue = new Object[capacity];
        front = 0;
        rear = 0;
        cnt = 0;
    }

    public Object enque(Object val) {
        if (cnt >= this.capacity) {
            throw new RuntimeException("overFlowException");
        }
        queue[rear++] = val;
        cnt++;
        if (rear >= this.capacity) {
            rear = 0;
        }
        return val;
    }

    public Object deque(){
        if (cnt <= 0) {
            throw new RuntimeException("emptyException");
        }
        Object val = queue[front++];
        cnt--;
        if (front >= this.capacity) {
            front = 0;
        }
        return val;
    }

    public Object peek() {
        if (cnt <= 0) {
            throw new RuntimeException("emptyException");
        }
        return queue[front];
    }

    // 큐에 저장된 데이터를 모두 출력 FIFO -> front 활용
    public void printQueue() {
        if (cnt <= 0) {
            throw new RuntimeException("emptyException");
        }
        for (int i = 0; i < cnt; i++) {
            int index = (front + i) % this.capacity;
            System.out.println(queue[index] + " ");
        }
    }

    // 큐에서 검색하는 메서드
    public int indexOf(Object val) {
        for (int i = 0; i < cnt; i++) {
            int index = (front + i) % this.capacity;
            if (queue[index].equals(val)) {
                return index;
            }
        }
        return -1;
    }

}
