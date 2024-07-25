package w2.day03.exception;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();

        Student[] students = new Student[50];


        try {
            students[0] = new Student("이준호", 4.5);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Geonoolist extends ArrayList {

}