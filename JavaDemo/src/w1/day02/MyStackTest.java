package w1.day02;

public class MyStackTest {
    public static void main(String[] args) {
        // String 유형을 저장할 MySrack을 생성하고, "Java", "Database", "Spring", "JPA" 저장
        // peek() / pop() / push(
        MyStack<String> stack = new MyStack<>();
        stack.push("Java");
        stack.push("Database");
        stack.push("Spring");
        stack.push("JPA");
        System.out.println(stack.peek());
        String item1 = stack.pop();
        System.out.println(item1);
        String item2 = stack.pop();
        System.out.println(item2);
        System.out.println(stack.peek());
        // Applicant 객체 3개 생성해서 MyStack에 저장한 뒤, 반복문 이용해서 구직자 정보 출력

        MyStack<Applicant> stack2 = new MyStack<>();
        for (int i = 0; i < 3; i++) {
            Applicant applicant = new Applicant();
            applicant.showInput();
            stack2.push(applicant);
        }

        // 스택에서 요소를 꺼내서 출력
        while (!stack2.isEmpty()) {
            Applicant applicant = stack2.pop();
            applicant.printInfo();
        }
    }
}
