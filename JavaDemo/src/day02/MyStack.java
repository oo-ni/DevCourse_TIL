package day02;

public class MyStack<T> {
    private Node<T> top = null;

    static class Node<T> {
        private T data;
        private Node<T> next = null;

        public Node(T data) {
            this.data = data;
        }
    }

    // 데이터를 저장하는 메서드
    public void push(T item) {
        Node<T> newNode = new Node<>(item);
        newNode.next = top;
        top = newNode;
    }

    public T pop() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        T data = top.data;
        top = top.next;
        return data;
    }

    public T peek() {
        if (top == null) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
