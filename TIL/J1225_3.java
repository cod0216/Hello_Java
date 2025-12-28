package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1225_3 {
    static int hour, min;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        hour = Integer.parseInt(input[0]);
        min = Integer.parseInt(input[1]);

        int now = hour * 60 + min;

        int umm = Integer.parseInt(buffer.readLine());
        int best = Integer.MAX_VALUE;

        for(int i = 0; i < umm; i++){
            input = buffer.readLine().split(" ");
            int busHour = Integer.parseInt(input[0]);
            int busMin = Integer.parseInt(input[1]);
            int interval = Integer.parseInt(input[2]);

            int next = attach(now, busHour, busMin, interval);
            if (next < best) best = next;

        }

        int ans = best % 1440;
        int hh = ans / 60;
        int mm = ans % 60;

        System.out.printf("%02d:%02d\n", hh, mm);
    }

    private static int attach(int now, int busHour, int busMin, int interval) {
        int s = busHour * 60 + busMin;
        int d = interval;

        int last = s + ((1439 - s) / d) * d;

        if (now > last) {
            return s + 1440;
        }
        if (now <= s) return s;

        int diff = now - s;
        int k = (diff + d - 1) / d;
        return s + k * d;
    }
}
