package w2.day03.test05;

public class Test01 {
    public static void main(String[] args) {
        BoxObject box = new BoxObject();

        box.setData(100);

        box.setData("hello");   //데이터 저장
//        System.out.println(box.getData());
//
        System.out.println((Integer) box.getData()/10);     // 몇천줄 아래에서 연산을 했는데... 어디서 에러가 난거야
    }
    // 상황에 맞춰서 데이터를 어떻게 관리할 것인가에 대한 전략.
}

class BoxInt {
    private int data;       // int로 저장하면 String으로 저장하고 싶은 사람은 결국 못쓰고, 그렇다고 BoxString처럼 모든 클래스를 만들수도 없다.

    public void setData(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }
}

class BoxObject {
    private Object data;

    public void setData(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }
}
