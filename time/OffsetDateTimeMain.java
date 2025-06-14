package time;

import java.time.*;
public class OffsetDateTimeMain {
    public static void main(String[] args) {
        OffsetDateTime nowOdt = OffsetDateTime.now();
        System.out.println("nowOdt = " + nowOdt);

        System.out.println();

        LocalDateTime ldt = LocalDateTime.of(2030,1,1,13,30,50);
        System.out.println("ldt = " + ldt);
        System.out.println();

        OffsetDateTime odt = OffsetDateTime.of(ldt, ZoneOffset.of("+01:00"));
        System.out.println("odt = " + odt);

    }
}
