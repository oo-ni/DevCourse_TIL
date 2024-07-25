package w1.day01;

import java.util.HashMap;
import java.util.Map;

public class GradeTest {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("미영", 98);
        scores.put("철이", 85);
        scores.put("준이", 75);
        scores.put("하니", 65);
        scores.put("영화", 49);

        Map<String, String> grades = calculateGrade(scores);
        Map<String, Integer> lastScores = new HashMap<>();

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String name = entry.getKey();
            int originalScore = entry.getValue();
            int bonusScore = calculateBonus(originalScore);
            int lastScore = originalScore + bonusScore;
            lastScores.put(name, lastScore);
            String grade = grades.get(name);

            System.out.printf("%s scored %d (+ %d bonus): 학점(Grade): %s\n", name, originalScore, bonusScore, grade);

            if (bonusScore > 0) {
                System.out.printf(" (학점: %s %d points 보너스를 부여했습니다!) %n", grade, bonusScore);
            }
        }

        System.out.println("전체 최종 점수: " + lastScores);
    }

    // 학점 계산
    private static Map<String, String> calculateGrade(Map<String, Integer> scores) {
        Map<String, String> grades = new HashMap<>();
        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            String name = entry.getKey();
            int score = entry.getValue();
            int bonus = calculateBonus(score);
            int last = score + bonus;
            String grade;
            if (last >= 90) {
                grade = "A";
            } else if (last >= 80) {
                grade = "B";
            } else if (last >= 70) {
                grade = "C";
            } else if (last >= 60) {
                grade = "D";
            } else {
                grade = "F";
            }
            grades.put(name, grade);
        }
        return grades;
    }

    // 보너스 계산
    private static int calculateBonus(int score) {
        if (score >= 90) {
            return 10;
        } else if (score >= 80) {
            return 5;
        } else if (score >= 70) {
            return 2;
        } else {
            return 0;
        }
    }
}