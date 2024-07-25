package w2.day03.test05;

import javax.swing.*;
import java.util.ArrayList;

public class Test02 {
    public static void main(String[] args) {
        BoxGeneric<Integer> box = new BoxGeneric<>();

//        box.setData("hello");   // 요소를 활용할 때에 타입을 지정하는게 제네릭의 개념! 이제 컴파일러가 체크할 수 있어짐.
        box.setData(100);
        System.out.println(box.getData()/10);
    }
}

// 미정. 정해지지 않음의 개념을 제시했음. -> 제네릭
class BoxGeneric<T> {
    private T data;

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}

