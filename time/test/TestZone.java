package time.test;

import java.time.*;
import java.util.TimeZone;

public class TestZone {
    public static void main(String[] args) {




        LocalDate ld = LocalDate.of(2024, 01, 01);
        ZoneId local = ZoneId.of("Europe/London");
        LocalTime london = LocalTime.of(0, 0, 0);
        ZonedDateTime zdt = ZonedDateTime.of(ld, london, local);
        System.out.println("zdt = " + zdt);

        zdt = zdt.withZoneSameInstant(ZoneId.of("Asia/Seoul"));
        System.out.println("zdt = " + zdt);

        zdt = zdt.withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println("zdt = " + zdt);

    }



}
