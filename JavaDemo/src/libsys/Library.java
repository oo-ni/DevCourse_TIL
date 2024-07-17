package libsys;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<RentalRecord> borrowRecords;

    public Library() {
        books = new ArrayList<>();
        borrowRecords = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAllBooks() {
        for (Book book : books) {
            book.printInfo();
        }
    }

    public void printAllRentalRecords() {
        for (RentalRecord record : borrowRecords) {
            record.printRecord();
        }
    }

    public void borrowBook(String title, String memberId, LocalDate borrowDate) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book instanceof Borrowable) {
                ((Borrowable) book).borrow(memberId, borrowDate);
                borrowRecords.add(new RentalRecord(title, memberId, borrowDate));
                return;
            }
        }
        System.out.println("도서를 찾을 수 없습니다.");
    }

    public void searchBook(String title, String author) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.getAuthor().equalsIgnoreCase(author)) {
                book.printInfo();
                return;
            }
        }
        System.out.println("도서를 찾을 수 없습니다.");
    }

}
