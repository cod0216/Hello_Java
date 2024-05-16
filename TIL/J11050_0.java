package TIL;

import java.io.*;


public class J11050_0 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        if( K == 0){
            System.out.println(1);
            return;
        }
        int result = factorial(N,K) / factorial(K,K);
        System.out.println(result);
    }

    public static int factorial(int num, int cnt){
        if(cnt == 1) return num;
        return num*factorial(num-1, cnt-1);
    }
}
