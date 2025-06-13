package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1072 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int r = (int)((long)y/(long)x*100)+1;

        int start = 0;
        int end = 1000000000;
        int ans = -1;

        while(start <= end) {
            int mid = (start + end)/2;
            if((int)(((long)(start+mid)/(long)(end+mid))*100) != r) {
                ans = mid;
                end = mid-1;
            }else {
                start = mid +1;
            }
        }
        System.out.println(ans);
    }
}
