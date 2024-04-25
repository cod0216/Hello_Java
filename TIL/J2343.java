package TIL;

import java.io.*;
import java.util.*;


public class J2343 {
    public static void main (String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int lectureCnt = Integer.parseInt(input[0]);
        int maxBlueRay = Integer.parseInt(input[1]);

        input = buffer.readLine().split(" ");

        int[] lecture = new int[lectureCnt];
        int blueRayCnt = 0;
        int maxNum = 0;
        int sum = 0;

        for (int i = 0; i < lectureCnt; i++) {
            lecture[i] = Integer.parseInt(input[i]);
            if(maxNum < lecture[i])
                maxNum = lecture[i];
            sum += lecture[i];
        }
        int start = maxNum;
        int end = sum;
        while (end >= start) {
            sum = 0;
            int mid = (start + end) / 2;
            blueRayCnt = 0;

            for (int i = 0; i < lectureCnt; i++) {
                if ((sum + lecture[i]) > mid) {
                    blueRayCnt++;
                    sum = 0;
                }
                sum += lecture[i];
            }
            if (sum != 0) blueRayCnt++;
            if (blueRayCnt > maxBlueRay) start = mid + 1;
            else end = mid - 1;
        }

        System.out.println(start);


    }
}
