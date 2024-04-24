package time;

import java.time.*;
public class ZonedDateTimeMain {

    public static void main(String[] args) {
        ZonedDateTime nowZdt = ZonedDateTime.now();
        System.out.println("nowZdt = " + nowZdt);
        System.out.println();


        LocalDateTime ldt = LocalDateTime.of(2030, 1, 1, 11, 50);
        ZonedDateTime zDtl = ZonedDateTime.of(ldt, ZoneId.of("Asia/Seoul"));
        System.out.println("zDtl = " + zDtl);
        System.out.println();

        ZonedDateTime zdt2 = ZonedDateTime.of(2030, 1, 1, 11, 50, 2, 3, ZoneId.of("Asia/Seoul"));
        System.out.println("zdt2 = " + zdt2);

        ZonedDateTime utcZdt = zdt2.withZoneSameInstant(ZoneId.of("UTC"));
        System.out.println("utcZdt = " + utcZdt);


    }
}
