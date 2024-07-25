package w1.libsys;

import java.time.LocalDate;
import java.util.Scanner;

public class LibraryApp {
    static Scanner sc = new Scanner(System.in);
    public static void addRegularBook(Library library) {
        System.out.print("일반도서 제목 입력 : ");
        String title = sc.nextLine();
        System.out.print("일반도서 저자 입력 : ");
        String author = sc.nextLine();
        library.addBook(new RegularBook(title, author));
        System.out.println("일반도서 목록에 추가되었어요 : " + title);
    }

    public static void addReferenceBook(Library library) {
        System.out.print("참고도서 제목 입력 : ");
        String title = sc.nextLine();
        System.out.print("참고도서 저자 입력 : ");
        String author = sc.nextLine();
        library.addBook(new ReferenceBook(title, author));
        System.out.println("참고도서 목록에 추가되었어요 : " + title);
    }

    public static void borrowBook(Library library) {
        System.out.print("member ID 입력 : ");
        String memberId = sc.nextLine();
        System.out.print("대여할 도서 제목 입력 : ");
        String title = sc.nextLine();
        LocalDate borrowDate = LocalDate.now();
        library.borrowBook(title, memberId, borrowDate);
        System.out.println("대여된 도서 정보 : " + title + "by Member ID " + memberId);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("== Library System Menu ==");
            System.out.println("1. Regular Book 등록");
            System.out.println("2. Reference Book 등록");
            System.out.println("3. 모든 도서 출력");
            System.out.println("4. 도서 대여하기");
            System.out.println("5. 대여된 모든 도서목록 보기");
            System.out.println("6. 종료");
            System.out.println("=========================");
            System.out.print("메뉴 번호를 선택하세요: ");
            int num = sc.nextInt();
            sc.nextLine();
            System.out.println("=========================");

            switch (num) {
                case 1:
                    addRegularBook(library);
                    break;
                case 2:
                    addReferenceBook(library);
                    break;
                case 3:
                    library.printAllBooks();
                    break;
                case 4:
                    borrowBook(library);
                    break;
                case 5:
                    library.printAllRentalRecords();
                    break;
                case 6:
                    sc.close();
                    System.out.println("Good Bye!");
                    return;
                default:
                    System.out.println("다시 입력해주세요.");
            }
        }
    }
}
