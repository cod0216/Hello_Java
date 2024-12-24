package TIL;

import java.io.*;
import java.util.*;

public class J2531 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int plate = Integer.parseInt(input[0]);
        int choBob = Integer.parseInt(input[1]);
        int eat = Integer.parseInt(input[2]);
        int coupon = Integer.parseInt(input[3]);

        int[] plates = new int[plate];
        for (int i = 0; i < plate; i++) {
            plates[i] = Integer.parseInt(buffer.readLine());
        }

        int[] eatCnt = new int[choBob + 1];
        int cnt = 0;

        for (int i = 0; i < eat; i++) {
            if (eatCnt[plates[i]] == 0) cnt++;
            eatCnt[plates[i]]++;
        }

        int eatMore = cnt;
        if (eatCnt[coupon] == 0) {
            eatMore = cnt + 1;
        }

        for (int i = 1; i < plate; i++) {
            eatCnt[plates[i - 1]]--;
            if (eatCnt[plates[i - 1]] == 0) {
                cnt--;
            }

            int newPlate = plates[(i + eat - 1) % plate];
            if (eatCnt[newPlate] == 0) {
                cnt++;
            }
            eatCnt[newPlate]++;

            int current = cnt;
            if (eatCnt[coupon] == 0) {
                current = cnt + 1;
            }

            if (current > eatMore) {
                eatMore = current;
            }
        }

        System.out.println(eatMore);
    }
}
