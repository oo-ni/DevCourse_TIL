package w1.libsys;

import java.time.LocalDate;

public class RentalRecord {
    private String bookTitle;
    private String memberId;
    private LocalDate borrowDate;

    public RentalRecord(String bookTitle, String memberId, LocalDate borrowDate) {
        this.bookTitle = bookTitle;
        this.memberId = memberId;
        this.borrowDate = borrowDate;
    }

    public void printRecord() {
        System.out.println("-------대여 기록-------");
        System.out.println("Member ID : " + memberId + " / Book Title : " + bookTitle + " / Borrow Date : " + borrowDate);
    }
}
