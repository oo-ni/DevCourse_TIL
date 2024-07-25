package w2.day03.test03;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
//        JFrame jf = new JFrame();
//
//        jf.setSize(200, 300);
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // 창에 x표시 누르면 프로그램 종료
//        jf.setVisible(true);
        new GeonooFrame();
    }
}

// 라이브러리를 extends 하는 과정
class GeonooFrame extends JFrame {
    public GeonooFrame() {
        super.add(new JButton("눌러보세용"));
        super.setSize(500, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setVisible(true);
    }
}