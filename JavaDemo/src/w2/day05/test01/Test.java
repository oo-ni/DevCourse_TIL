package w2.day05.test01;

import java.util.Random;
import java.util.TreeMap;

public class Test {
    public static void main(String[] args) {
        Random r = new Random();
        Thread t1 = new MyThread("이범수", r.nextInt(10000));
        System.out.println("범수 객체 생성 완료");
        Thread t2 = new MyThread("정준상", r.nextInt(10000));
        System.out.println("준상 객체 생성 완료");
        Thread t3 = new MyThread("김민우", r.nextInt(10000));
        System.out.println("민우 객체 생성 완료");

        // 순차적으로 수행
//        t1.run();
//        t2.run();
//        t3.run();

        // 동시에 수행
        /*
        김민우 말하고 있어요~!!!!52
        정준상 말하고 있어요~!!!!54
        이범수 말하고 있어요~!!!!37
        정준상 말하고 있어요~!!!!55
        김민우 말하고 있어요~!!!!53
        정준상 말하고 있어요~!!!!56
        이범수 말하고 있어요~!!!!38
         */

        t1.start();
        t2.start();
        t3.start();
    }
}
