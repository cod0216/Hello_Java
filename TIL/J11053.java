package TIL;

import java.io.*;
import java.util.*;

/*
수열 A가 주어졌을 때, 가장 긴 증가하는 부분 수열을 구하는 프로그램을 작성

예를들어 수열 A{10, 20, 10, 30, 20, 50} 인 경우 가장 긴 증가하는 부분 수열은 A 이다.
A ={ 10, 20, 10, 30, 20, 50} 길이는 4이다.


고기 반찬인줄 알았는데 콩고기였다.
그래도 소스가 맛있어서 좋았다.

 */
public class J11053 {
    static int n;
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        arr = new int[n];
        dp = new int[n];
        dp[0] = 1;

        String[] input = buffer.readLine().split(" ");
        for(int i = 0; i < n; i++ ) {
            arr[i] = Integer.parseInt(input[i]);
        }

        int max = 0;
        for(int i = 1 ; i < n; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
