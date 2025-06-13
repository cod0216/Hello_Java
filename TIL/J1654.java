package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        long key = Long.parseLong(input[1]);

        long[] arr = new long[n];
        long max = Long.MIN_VALUE;

        for(int i = 0; i < n; i++){
            arr[i] = Long.parseLong(buffer.readLine());
            max = Math.max(max,arr[i]);
        }

        long from = 1;
        long to = max;
        long mid;
        long ans = 0;

        while(from <= to) {
            mid = (from+to)/2;
            long cnt = cutting(mid, arr);
            if(cnt<key){
                to = mid-1;
            }else{
                from = mid+1;
                ans = mid;
            }
        }
        System.out.println(ans);
    }

    private static long cutting(long mid, long[] arr) {
        long sum = 0;
        for(int i= 0; i<arr.length; i++){
            sum += arr[i]/mid;
        }
        return sum;
    }
}