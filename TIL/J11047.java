package TIL;

import java.io.*;

public class J11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int value = Integer.parseInt(input[1]);
        int[] coin = new int[n];
        for(int i = 0; i <n; i++){
            coin[i] = Integer.parseInt(bufferedReader.readLine());
        }
        int cnt = 0;

        while(value!=0){
            if(coin[--n] <= value){
                cnt += value/coin[n];
                value %= coin[n];
            }

        }
        System.out.println(cnt);
    }
}
