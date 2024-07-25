package w2.day03.ws;

// 오늘의 실습 2 : ArrayList<Book> 또는 LinkedList<Book> 저장

import java.util.ArrayList;
import java.util.List;

public class BookManagerImpl implements IBookManager {
    // 개발자가 클래스 내에 생성자가 하나라도 존재하면 컴파일러는 기본생성자를 끼워넣지 않음.
    // 이제 다른 클래스에서 new BookManagerImpl을 못하는 상태가 되었음.
    private BookManagerImpl(){}
    private static BookManagerImpl instance = new BookManagerImpl();
    public static BookManagerImpl getInstance() {
        return instance;
    }

    private List<Book> books = new ArrayList<>();

    @Override
    public void add(Book book) {
        books.add(book);
    }

    @Override
    public void remove(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbn)) {
                books.remove(i);
                break;
            }
        }
    }

    @Override
    public Book[] getList() {
        return books.toArray(new Book[0]);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }

        return null;
    }

    @Override
    public Book[] searchByTitle(String title) {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                list.add(book);
            }
        }

        return list.toArray(new Book[0]);
    }

    @Override
    public Magazine[] getMagazines() {
        List<Magazine> list = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof Magazine) {
                list.add((Magazine) book);
            }
        }

        return list.toArray(new Magazine[0]);
    }

    @Override
    public Book[] getBooks() {
        List<Book> list = new ArrayList<>();
        for (Book book : books) {
            if (!(book instanceof Magazine)) {
                list.add(book);
            }
        }

        return list.toArray(new Book[0]);
    }

    @Override
    public int getTotalPrice() {
        int total = 0;
        for (Book book : books) {
            total += book.getPrice();
        }

        return total;
    }

    @Override
    public double getPriceAvg() {
        int total = getTotalPrice();
        int totalBooks = books.size();

        return (double) total / totalBooks;
    }

    @Override
    public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
        Book book = searchByIsbn(isbn);
        if (book == null) {
            throw new ISBNNotFoundException(isbn);
        } else if (book.getQuantity() < quantity) {
            throw new QuantityException(book.getQuantity());
        }
        book.setQuantity(book.getQuantity() - quantity);
    }

    @Override
    public void buy(String isbn, int quantity) throws ISBNNotFoundException {
        Book book = searchByIsbn(isbn);
        if (book == null) {
            throw new ISBNNotFoundException(isbn);
        }
        book.setQuantity(book.getQuantity() + quantity);
    }

}
