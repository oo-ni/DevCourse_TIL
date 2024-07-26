package w2.day04.test01;

import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        Student[] students = new Student[9];

        students[0] = new Student("윤건우", 25, 95);
        students[1] = new Student("정상길", 27, 85);
        students[2] = new Student("김찬호", 28, 100);
        students[3] = new Student("손인욱", 25, 90);
        students[4] = new Student("손흥민", 22, 85);
        students[5] = new Student("박재범", 30, 70);
        students[6] = new Student("봉준호", 40, 75);
        students[7] = new Student("이성원", 22, 85);
        students[8] = new Student("양아영", 20, 90);

        int[][] arr = new int[3][];
        arr[0] = new int[2];
        arr[1] = new int[]{1, 2, 3, 4};

        Arrays.sort(students);

        System.out.println(students[0].compareTo(students[2]));

        for (Student student : students) {
            System.out.println(student);
        }
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int score;
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }
    @Override
    public int compareTo(Student o) {
        System.out.println("비교중!!");
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                "}";
    }
}