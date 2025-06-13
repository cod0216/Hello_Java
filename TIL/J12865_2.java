package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J12865_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int[][] bag = new int[n+1][k+1];
        int[][] items = new int[n+1][2];

        for(int i = 0; i < n; i++){
            input = buffer.readLine().split(" ");
            items[i+1][0] = Integer.parseInt(input[0]);
            items[i+1][1] = Integer.parseInt(input[1]);
        }

        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= k; j++){
                bag[i][j] = bag[i-1][j];
                if(items[i][0] <= j){
                    bag[i][j] = Math.max(bag[i][j], bag[i-1][j - items[i][0]] + items[i][1]);
                }
            }
        }

        System.out.println(bag[n][k]);



    }
}
