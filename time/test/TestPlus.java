package time.test;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class TestPlus {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2024, 01, 01, 0, 0, 0);
        LocalDateTime dt2 = dt.plusYears(1).plusMonths(2).plusMonths(3).plusDays(4);
        System.out.println("dt = " + dt);
        System.out.println("dt2 = " + dt2);
    }
}
