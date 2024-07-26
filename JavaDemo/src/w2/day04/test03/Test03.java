package w2.day04.test03;

import java.util.Arrays;
import java.util.Comparator;

public class Test03 {
    public static void main(String[] args) {
        // 정렬 기준이 오름차순, 내림차순 등으로 계속 바뀌도록 작성.
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

        Arrays.sort(students, new Comparator<Student>() {   // 무명 클래스. implements Comparator 클래스. 1회용 클래스
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println("-------------------------------------");
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (Student student : students) {
            System.out.println(student);
        }
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
