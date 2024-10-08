package w2.day03.ws;

// 오늘의 실습 3 : Map형식으로 데이터 저장

import java.io.*;
import java.util.*;
import java.util.concurrent.RunnableFuture;

public class BookManagerImpl implements IBookManager {
    // 개발자가 클래스 내에 생성자가 하나라도 존재하면 컴파일러는 기본생성자를 끼워넣지 않음.
    // 이제 다른 클래스에서 new BookManagerImpl을 못하는 상태가 되었음.
    private BookManagerImpl() {
        loadData();
    }
    private static BookManagerImpl instance = new BookManagerImpl();
    public static BookManagerImpl getInstance() {
        return instance;
    }

    // isbn을 key로 활용해보자
    private Map<String, Book> books = new HashMap<>();

    @Override
    public void add(Book book) {
        books.put(book.getIsbn(), book);
    }

    @Override
    public void remove(String isbn) {
        books.remove(isbn);
    }

    @Override
    public Book[] getList() {
        return books.values().stream()
                .toArray(Book[]::new);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        return books.get(isbn);
    }

    @Override
    public Book[] searchByTitle(String title) {
        return books.values().stream()
                .filter(book -> book.getTitle().contains(title))
                .toArray(Book[]::new);
    }

    @Override
    public Magazine[] getMagazines() {
        return books.values().stream()
                .filter(book -> book instanceof Magazine)
                .map(book -> (Magazine) book)
                .toArray(Magazine[]::new);
    }

    @Override
    public Book[] getBooks() {
        return books.values().stream()
                .filter(book -> !(book instanceof Magazine))
                .toArray(Book[]::new);
    }

    @Override
    public int getTotalPrice() {
        return books.values().stream()
                .mapToInt(Book::getPrice)
                .sum();
    }

    @Override
    public double getPriceAvg() {
        return books.values().stream()
                .mapToInt(Book::getPrice)
                .average()
                .orElse(0.0);
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

    @Override
    public void saveData() {
//        ObjectOutputStream oos = null;
//
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("books.dat"));
//        } catch (IOException e) {
//            throw new RuntimeException(e)   ;
//        } finally {
//            if (oos != null) {
//                try {
//                    oos.close();
//                } catch (IOException e){
//
//                }
//            }
//        }
        // try ()에서 괄호안에 적어준 애들은, finally에서 close 해주는 걸 자동으로 해줌.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("JavaDemo/src/w2/day03/ws/book.dat"))) {
            oos.writeObject(books);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadData() {
        File f = new File("JavaDemo/src/w2/day03/ws/book.dat");
        if (!f.exists()) {
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            books = (Map<String, Book>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}
