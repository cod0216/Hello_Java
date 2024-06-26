package TIL.review;

import java.util.*;
import java.io.*;

public class J1300 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int array = Integer.parseInt(buffer.readLine());
        int index = Integer.parseInt(buffer.readLine());

        int start = 0;
        int end = index;

        int result = 0;
        int mid;

        while(start <= end) {
            int cnt = 0;
            mid = (start + end) / 2;
            for (int i = 1; i <= array; i++){
                cnt += Math.min(mid/i, array);
            }

            if(cnt < index){
                start = mid+1;
            }else{
                end = mid-1;
                result = mid;
            }

        }
        System.out.println(result);
    }
}
