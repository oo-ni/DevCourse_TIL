package w1.day02;

/* 객체 추출
- 구직자 (속성 3개 이상, 메서드 2개 이상)
- 구인 회사 (속성 3개 이상, 메서드 2개 이상)
- 헤드 헌터
 */

import java.util.ArrayList;
import java.util.Scanner;

public class JobKorea {
    static ArrayList<Applicant> applicants = new ArrayList<>();
    static ArrayList<Company> companies = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    public static void showMenu() {
        System.out.println("*****JobKorea App v1.1*****");
        System.out.println("1. 구직자 등록");
        System.out.println("2. 회사 등록");
        System.out.println("3. 구직자 정보 출력 (All)");
        System.out.println("4. 회사 정보 출력 (All)");
        System.out.println("5. 구직자 정보 검색 (이름)");
        System.out.println("6. 구직자 정보 삭제 (연락처)");
        System.out.println("9. 종   료");
        System.out.println("***************************");
        System.out.println("메뉴 번호를 선택하세요 =>");
        System.out.println("***************************");

    }

    public static void registerApplicant() {
        if (applicants.size() >= 5) {
            System.out.println("구직자 등록 마감");
        } else {
            Applicant applicant = new Applicant();
            applicant.showInput();
            applicants.add(applicant);
            System.out.println("구직자 등록 성공!");
        }
    }

    public static void registerCompany() {
        if (companies.size() >= 5) {
            System.out.println("회사 등록 마감");
        } else {
            Company company = new Company();
            company.showInput();
            companies.add(company);
            System.out.println("회사 등록 성공!");
        }
    }

    public static void printAllApplicants() {
        for (Applicant applicant : applicants) {
            applicant.printInfo();
        }
    }

    public static void printAllCompanies() {
        for (Company company : companies) {
            company.printInfo();
        }
    }

    public static void searchApplicantByName() {
        System.out.print("이름을 입력하세요 : ");
        String name = sc.next();
        for (Applicant applicant : applicants) {
            if (applicant.getName().equals(name)) {
                applicant.printInfo();
                return;
            }
        }
        System.out.println("구직자가 존재하지 않습니다");
    }

    public static void deleteApplicantByContact() {
        System.out.print("연락처를 입력하세요 : ");
        int contact = sc.nextInt();
        for (Applicant applicant : applicants) {
            if (applicant.getContact() == contact) {
                applicants.remove(applicant);
                System.out.println("연락처 : " + contact + " 구직자를 삭제하였습니다.");
                return;
            }
        }
        System.out.println("구직자가 존재하지 않습니다.");
    }

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    registerApplicant();
                    break;
                case 2:
                    registerCompany();
                    break;
                case 3:
                    printAllApplicants();
                    break;
                case 4:
                    printAllCompanies();
                    break;
                case 5:
                    searchApplicantByName();
                    break;
                case 6:
                    deleteApplicantByContact();
                    break;
                case 9:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 입력입니다. 다시 입력하세요.");
            }
        }
    }
}
