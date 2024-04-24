package time;

import java.time.*;
public class LocalDateTimeMain {

    public static void main(String[] args) {
        LocalDateTime nowLDT = LocalDateTime.now();
        LocalDateTime ofLDT = LocalDateTime.of(2016, 8, 29, 16, 20, 15);

        System.out.println("nowLDT = " + nowLDT);
        System.out.println("ofLDT = " + ofLDT);

        System.out.println();
        LocalDate Date = nowLDT.toLocalDate();
        LocalTime Time = nowLDT.toLocalTime();

        System.out.println("Date = " + Date);
        System.out.println("Time = " + Time);
        System.out.println();

        LocalDateTime ofPlusDays = ofLDT.plusDays(10);
        LocalDateTime ofPlusYears = ofLDT.plusYears(30);
        System.out.println("ofPlusDays = " + ofPlusDays);
        System.out.println("ofPlusYears = " + ofPlusYears);


        System.out.println("현재 날짜시간이 지정 날짜시간보다 이전인가?" + nowLDT.isBefore(ofPlusDays));
        System.out.println("현재 날짜시간이 지정 날짜시간보다 이후인가?" + nowLDT.isAfter(ofPlusDays));
        System.out.println("현재 날짜시간이 지정 날짜시간와 같은가?" + nowLDT.isEqual(ofPlusDays));

    }

}
