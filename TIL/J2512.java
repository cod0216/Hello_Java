package TIL;

import java.io.*;
import java.util.*;

public class J2512 {
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        int[] city = new int[n];
        int total=0;

        String[] input = buffer.readLine().split(" ");
        for(int i = 0 ; i < n; i++){
             city[i] = Integer.parseInt(input[i]);
             total+=city[i];
        }
        Arrays.sort(city);

        int b = Integer.parseInt(buffer.readLine());
        if(total <= b){
            System.out.println(city[n-1]);
            return;
        }

        int start = 1;
        int end = city[n-1];
        int key = 0;

        while(start <= end){
            int mid = (start+end) / 2;
            int sum =0;

            for(int i =0 ; i < n; i++){
                int v = mid < city[i] ? mid : city[i];
                sum +=v;
            }

            if(sum <= b){
                start = mid+1;
                key = mid;
            } else if(sum > b){
                end = mid-1;
            }
        }

        System.out.println(key);
    }
}
