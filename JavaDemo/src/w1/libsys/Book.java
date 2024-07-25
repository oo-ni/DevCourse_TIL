package w1.libsys;

import java.time.LocalDate;

abstract class Book {
    protected String title;
    protected String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public abstract void printInfo();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class RegularBook extends Book implements Borrowable {
    public RegularBook(String title, String author) {
        super(title, author);
    }

    @Override
    public void printInfo() {
        System.out.println("=== Regular Book Info ===");
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("=========================");
    }

    @Override
    public void borrow(String memberId, LocalDate borrowDate) {
        System.out.println("회원 ID : " + memberId + " / 책 제목 : " + title + " / 대여 일자" + borrowDate);
    }
}

class ReferenceBook extends Book {
    public ReferenceBook(String title, String author) {
        super(title, author);
    }
    @Override
    public void printInfo() {
        System.out.println("=== Reference Book Info ===");
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("===========================");
    }
}
