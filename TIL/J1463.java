package TIL;

/*
정수 x 연산 3가지
1. x % 3 ==0이면 3 으로 나눔
2. x % 2 ==0이면 2 으로 나눔
3. 1을 빼기
 */

import java.io.*;
import java.util.*;

public class J1463 {
    static int x;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        x = Integer.parseInt(buffer.readLine());
        dp = new int[x+1];
        Arrays.fill(dp,-1);
        dp[1] = 0;

        System.out.println(numCal(x));
    }

    public static int numCal(int num){
        if(dp[num] == -1) {// 메모 안됏으면
            if (num % 6 == 0) return dp[num] = Math.min(Math.min(numCal(num / 2), numCal(num - 1)), numCal(num / 3))+1;
            if (num % 3 == 0) return dp[num] = Math.min(numCal(num / 3), numCal(num - 1)) + 1;
            if (num % 2 == 0) return dp[num] = Math.min(numCal(num / 2), numCal(num - 1)) + 1;

            dp[num] = numCal(num-1)+1; // 문제 똑바로 읽기
        }

        return dp[num];
    }


}
