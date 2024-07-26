package w2.day04.test06;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test06 {
    public static void main(String[] args) {
        Student[] students = new Student[9];

        students[0] = new Student("윤건우", 26, 95);
        students[1] = new Student("정상길", 27, 85);
        students[2] = new Student("김찬호", 28, 100);
        students[3] = new Student("손인욱", 25, 90);
        students[4] = new Student("손흥민", 22, 85);
        students[5] = new Student("박재범", 30, 70);
        students[6] = new Student("봉준호", 40, 75);
        students[7] = new Student("류희수", 25, 85);
        students[8] = new Student("양아영", 20, 90);

        List<Student> list1 = Arrays.stream(students).sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
                .filter(s -> s.getScore() > 80)
                .toList();

        for (Student student : list1) {
            System.out.println(student);
        }

        List<Student> list2 = Arrays.stream(students).sorted((o1, o2) -> o1.getAge()).toList();

    }
}


class Student {
    private String name;
    private int age;
    private int score;
    public Student(String name, int age, int score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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