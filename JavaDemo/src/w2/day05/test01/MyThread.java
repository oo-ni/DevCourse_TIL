package w2.day05.test01;

public class MyThread extends Thread {
    private String name;
    private int time;

    public MyThread(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < time; i++) {
            System.out.println(name + " 말하고 있어요~!!!!" + i);
        }
        System.out.println(name + "이(가) 모든 작업을 완료하였습니다.");
    }

}
