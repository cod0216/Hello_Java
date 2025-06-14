package time;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
//import java.time.temporal.

public class ChronoUnitMain {
    public static void main(String[] args) {
        System.out.println();
        ChronoUnit[] values = ChronoUnit.values();
        for (ChronoUnit value : values) {
            System.out.println("value = " + value);
        }
        System.out.println();
        System.out.println("Hours = " + ChronoUnit.HOURS);
        System.out.println("Hours.duration = " + ChronoUnit.HOURS.getDuration().getSeconds());
        System.out.println();
        System.out.println("Days = " + ChronoUnit.DAYS );
        System.out.println("Days.duration = " + ChronoUnit.DAYS.getDuration().getSeconds());
        System.out.println();
        LocalTime lt1 = LocalTime.of(1, 10, 0);
        LocalTime lt2 = LocalTime.of(1, 20, 0);

        Long secondsBetween = ChronoUnit.SECONDS.between(lt1, lt2);
        System.out.println("secondsBetween = " + secondsBetween);

        long minutesBetween = ChronoUnit.MINUTES.between(lt1, lt2);
        System.out.println("minutesBetween = " + minutesBetween);

    }
}
