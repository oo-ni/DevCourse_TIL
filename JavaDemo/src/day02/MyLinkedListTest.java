package day02;

import java.util.Comparator;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList();

        list.addFirst("A");
        list.addLast("B");
        list.printCurrentNode();

        list.addFirst("C");
        list.addLast("D");
        list.printAllNode();
        list.removeLast();
        list.printCurrentNode();
        list.printAllNode();
        list.removeFirst();
        list.printCurrentNode();
        list.printAllNode();

        // 1. Applicant 객체 3개 생성한 후 linkedlist에 저장하세요
        MyLinkedList<Applicant> applicantList = new MyLinkedList<>();
        Applicant a1 = new Applicant();
        a1.showInput();
        Applicant a2 = new Applicant();
        a2.showInput();
        Applicant a3 = new Applicant();
        a3.showInput();

        applicantList.addLast(a1);
        applicantList.addLast(a2);
        applicantList.addLast(a3);

        applicantList.printAllNode();

        // 2. 중간 지점에 있는 Applicant객체를 하나 삭제하세요
        applicantList.removeMiddle();
        applicantList.printAllNode();

        // 3. 나이가 22세인 구직자가 있는지 검색해서 해당 구직자 정보를 출력하세요
        Applicant searchTarget = new Applicant();
        searchTarget.setAge(22);
        Applicant foundApplicant = applicantList.search(searchTarget, new Comparator<Applicant>() {
            @Override
            public int compare(Applicant o1, Applicant o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        });

        if (foundApplicant != null) {
            foundApplicant.printInfo();
        } else {
            System.out.println("나이가 22세인 구직자를 찾을 수 없습니다.");
        }

    }
}
