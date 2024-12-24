package TIL;

import java.io.*;

public class J1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        int ans=0;
        while(true){
            int temp = n;
            int cnt = 0;
            while(temp>0){
                temp -= (~temp+1)&temp;
                cnt++;
            }
            if(cnt<=k) break;
            n++;
            ans++;
        }
        System.out.println(ans);
    }
}
