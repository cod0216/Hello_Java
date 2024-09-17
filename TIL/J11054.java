package TIL;

import java.io.*;


/*
바이토닉 특정 수를 기준으로 왼쪽에서 위치한 숫자는 증가하고 오른쪽에 위치한 숫자는 감소하는 형태
맞없는거 2개 합치면 될듯

 */
public class J11054 {
    static int n, dp[], dp2[], arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        arr = new int[n];
        dp = new int[n+1];
        dp2 = new int[n+1];

        String[] input = buffer.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            arr[i] =Integer.parseInt(input[i]);
        } //input end


        int max = 0;
        for(int i = 0; i <n; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] >= dp[i]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }//LIS

        for(int i = n-1; i >=0; i--) {
            dp2[i] = 1;
            for(int j = n-1; j > i; j--) {
                if (arr[i] > arr[j] && dp2[j] >= dp2[i]) {
                    dp2[i] = dp2[j] + 1;
                }
            }
        }//LDS

        for(int i = 0 ; i <= n; i++){
            max = Math.max(dp[i]+dp2[i]-1, max);
        }
        System.out.println(max);

    }

}
