package w1.day02;

import java.util.Scanner;

public class Applicant {
    private String name;
    private int age;
    private int contact;
    private String language;
    private String[] profile;
    private Scanner sc = new Scanner(System.in);

    public Applicant() {
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.language = language;
        this.profile = new String[5];
    }

    public void showInput() {
        System.out.print("이름 : ");
        setName(sc.nextLine());
        System.out.print("나이 : ");
        setAge(sc.nextInt());
        sc.nextLine();
        System.out.print("연락처 : ");
        setContact(sc.nextInt());
        sc.nextLine();
        System.out.print("언어 : ");
        setLanguage(sc.nextLine());

        System.out.println("경력을 입력하세요 [2개]");
        profile[0] = sc.nextLine();
        profile[1] = sc.nextLine();
    }

    public void printInfo() {
        System.out.println("----구직자 정보----");
        System.out.printf("이름 : %s%n", name);
        System.out.printf("나이 : %d%n", age);
        System.out.printf("연락처 : %d%n", contact);
        System.out.printf("언어 : %s%n", language);

        for (int i = 0; i < 2; i++) {
            System.out.printf("%d : %s%n", (i + 1), profile[i]);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }
}