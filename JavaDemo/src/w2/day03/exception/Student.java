package w2.day03.exception;

public class Student {
    private String name;
    private double grade;

    public Student(String name, double grade) throws Exception {
        // throws : 발생 가능한 예외들을 미리 알려줌. (하나하나 알릴 수도 있고, 그냥 Exception이라는 부모 타입을 넣어서 한번에 표현할 수도 있음)
        if (grade < 0) {
            throw new GeonooException();    // throw : 이런 경우에 던지겠다.
        } else if (grade < 3) {
            throw new InterruptedException("학점이 너무 낮은데요..ㅠㅠ");
        }

        this.name = name;
        this.grade = grade;
    }
}
