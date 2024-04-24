package time;

import java.time.*;
public class LocalTimeMain {
    public static void main(String[] args) {


        LocalTime localTime = LocalTime.now();
        LocalTime ofTime = LocalTime.of(17, 05, 20);
        System.out.println("localTime = " + localTime);
        System.out.println("ofTime = " + ofTime);

        LocalTime plusSeconds = ofTime.plusSeconds(101);
        System.out.println("plusSeconds = " + plusSeconds);
    }

}
