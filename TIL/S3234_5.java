package TIL;

import java.io.*;
import java.util.*;

public class S3234_5 {
    static int N;
    static int res;
    static int[] chu;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer =new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split("-");
        for(int i = 0; i <input.length; i++ ) {

            char[] A = input[i].toCharArray();
            System.out.print(A[0]);
        }

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T > t){
            N = Integer.parseInt(buffer.readLine());
            chu = new int[N];
            input = buffer.readLine().split(" ");
            int sum = 0;

            for(int i = 0 ; i < N ; i++){
                chu[i] = Integer.parseInt(input[i]);
                sum += chu[i];
            }


            //한 츄 당 츄 선택 되고 안되고 2가지 경우, 메모이제이션 기능
            dp = new int[sum+1][(1<<N)];


            t ++;
            res = dfs(0,0,0,0);
            System.out.println("#" + t + " " + res);
        }
    }
    public static int dfs(int depth, int sumL, int sumR, int visited){
        if(depth >= N) return 1;

        if(dp[sumL][visited]!=0) return dp[sumL][visited];

        int res = 0;
//        0~N번 추를 다 올려 놓는 시도를 계속 Do
        for(int i = 0; i < N; i++) {
            if ((visited & (1 << i)) != 0) continue; //조합(이미 올린거 다시 올릴 수 없음)

            //왼쪽에 올리기
            res += dfs(depth + 1, sumL + chu[i], sumR, visited | (1 << i));
            if (sumL >= sumR + chu[i]) {
                res += dfs(depth + 1, sumL, sumR + +chu[i], visited | (1 << i));
            }
        }

        return dp[sumL][visited] = res;
    }
}
