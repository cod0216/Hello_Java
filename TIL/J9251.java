package TIL;

import java.io.*;
import java.util.*;

/*

LCS는 최장 공통 부분 수열이고 두 수열이 주어졌을떄
모두의 부분 수열이 되는 수열중 가장 긴 것을 찾는것

맛없는 문제


 */

public class J9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] str1 = buffer.readLine().split("");
        String[] str2 = buffer.readLine().split("");

        int n1 = str1.length;
        int n2 = str2.length;
        int[][] dp = new int[n1+1][n2+1];

        for(int i = 1; i<=n1; i++) {
            for(int j = 1; j<=n2; j++) {
                if (str2[j - 1].equals(str1[i - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }

        System.out.println(dp[n1][n2]);
    }
}


/*
https://yeons4every.tistory.com/134  참고하기

 */