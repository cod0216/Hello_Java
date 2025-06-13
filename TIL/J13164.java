package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J13164 {
    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[] arr =  new int[n];
        int[] diff = new int[n-1];

        input = buffer.readLine().split(" ");

        for(int i = 0 ; i< n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i<n-1;i++){
            diff[i] = arr[i+1]-arr[i];
        }

        Arrays.sort(diff);
        int ans=0;
        for(int i = 0; i<(n-1) - (k-1);i++){
            ans += diff[i];
        }

        System.out.println(ans);

    }
}
