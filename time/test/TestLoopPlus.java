package time.test;

import java.time.*;
import java.time.temporal.*;

public class TestLoopPlus {
    public static void main(String[] args) {
        LocalDate lD = LocalDate.of(2024, 01, 01);

        for(int i = 0; i <5; i++){
            LocalDate ld= lD.plus(2*i, ChronoUnit.WEEKS);
            System.out.println("날짜 "+i+ ": " + ld);
        }
    }
}
