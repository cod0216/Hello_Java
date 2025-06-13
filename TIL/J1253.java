package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n;

        n = Integer.parseInt(buffer.readLine());

        long[] num = new long[n];

        String[] input = buffer.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            num[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(num);
        int ans=0;


        for(int i = 0; i<n; i++ ) {
            long key = num[i];
            int from = 0;
            int to = n-1;

            while (from < to) {
                long sum = num[from] + num[to];

                if(i == from){
                    from++; continue;
                } else if(to == i){
                    to--; continue;
                }

                if (sum > key) to--;
                else if (sum < key) from++;
                else { ans++; break; }
            }
        }
        System.out.println(ans);
    }
}
