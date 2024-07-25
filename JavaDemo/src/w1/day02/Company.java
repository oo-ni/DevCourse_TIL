package w1.day02;

import java.util.Scanner;

public class Company {
    private String name;
    private String location;
    private Scanner sc = new Scanner(System.in);

    public Company() {
        this.name = name;
        this.location = location;
    }

    public void showInput() {
        System.out.print("회사명: ");
        setCompanyName(sc.nextLine());
        System.out.print("위치: ");
        setLocation(sc.nextLine());
    }
    public void printInfo() {
        System.out.println("----회사 정보----");
        System.out.printf("회사명 : %s%n", name);
        System.out.printf("위치 : %s%n", location);
    }

    public String getCompanyName() {
        return name;
    }

    public void setCompanyName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}