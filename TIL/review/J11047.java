package TIL.review;

import java.io.*;


public class J11047 {
    public static void main(String[] args)throws IOException {
        int coin;
        int money;

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String input[] = buffer.readLine().split(" ");

        coin = Integer.parseInt(input[0]);
        money = Integer.parseInt(input[1]);

        int[] coinBox = new int[coin];
        int result = 0;
        int total = money;
        for (int i = 0; i < coin; i++) {
            coinBox[i] = Integer.parseInt(buffer.readLine());
        }

        for(int i = coin-1; i> -1; i--){
            if (total>=coinBox[i]){ // 경계값 체크 잘 해야됨 다음 복습할때 주의하기
                int cnt = total/coinBox[i];
                total -= (coinBox[i]*cnt);
                result += cnt;

            }
        }
        System.out.println(result);
    }
}
