package w2.day05.test05;

import java.io.Serializable;

// Serializable :
public class Student implements Serializable {
    private String name;
    private int age;
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

//    @Override
//    public String toString() {
//
//
//    }
}
