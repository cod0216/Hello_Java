package TIL;

import java.util.*;
import java.io.*;

public class J1300 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(buffer.readLine());
        int key = Integer.parseInt(buffer.readLine());

        int start = 1;
        int end = key;

        int mid = 0;
        int cnt = 0;
        int answer = 0;
        while(start <= end) {
            cnt = 0;
            mid = (start + end)/2;

            for (int i = 1; i <= index; i++) {
                cnt += Math.min(mid/i, index);
            }

            if(cnt < key){
                start = mid+1;
            }else {
                end = mid-1;
                answer = mid;

            }
        }

        System.out.println(answer);

    }
}
