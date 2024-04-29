package time;

import java.time.*;
import java.time.temporal.*;

public class ChangeTimeWithMain {
    public static void main(String[] args) {
        LocalDateTime dt = LocalDateTime.of(2018, 1, 1, 13, 30, 59);
        System.out.println("dt = " + dt);

        LocalDateTime changeDt1 = dt.with(ChronoField.YEAR, 2020);
        System.out.println("changeDt1 = " + changeDt1);

        LocalDateTime changeDt2 = dt.withYear(2020);
        System.out.println("changeDt2 = " + changeDt2);

        LocalDateTime with1 = dt.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        System.out.println("기준 날씨 = " + dt);
        System.out.println("다음 금요일 = " + with1);

        LocalDateTime with2 = dt.with(TemporalAdjusters.lastInMonth(DayOfWeek.SUNDAY));
        System.out.println("같은 달의 마지막 월요일 = " + with2);

    }
}
