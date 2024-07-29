package w2.day05.test02;

public class Bank {
    private int balance;

    synchronized public void plus(){
        balance += 10000;
        System.out.println("만원 입금 현재 잔액 : " + balance);
    }

    synchronized public void minus() {
        balance -= 10000;
        System.out.println("만원 출금 현재 잔액 : " + balance);
    }

    // synchronized를 하지 않았을 때, 서로 CPU 공간에 대한 선점을 하려고 마구마구 넣고빼고 함.
    /*
    만원 출금 현재 잔액 : -20000
    만원 입금 현재 잔액 : -10000
    만원 출금 현재 잔액 : -20000
    만원 입금 현재 잔액 : -10000
    만원 출금 현재 잔액 : -20000
    만원 입금 현재 잔액 : -10000
     */

}
