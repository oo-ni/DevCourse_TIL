package w1.libsys;

import java.time.LocalDate;

public interface Borrowable {
    void borrow(String memberId, LocalDate borrowDate);
}
