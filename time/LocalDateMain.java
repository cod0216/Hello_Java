package time;

import java.time.*;
public class LocalDateMain {
    public static void main(String[] args) {
        LocalDate nowDate = LocalDate.now();
        LocalDate ofDate = LocalDate.of(2020, 11, 12);

        System.out.println("nowDate = " + nowDate);
        System.out.println("ofDate = " + ofDate);

        LocalDate plusDays = ofDate.plusDays(10);
        System.out.println("plusDays = " + plusDays);
    }
}
