package TIL;

import java.io.*;

public class S001 {

    public static void main(String[] arg) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t) {
            int ans = 1;
            int cnt = 1;
            int total = (1 << 10)-1;
            int n = Integer.parseInt(buffer.readLine());
            int visited = 0;
            while(true){
                char[] arr = String.valueOf(n*cnt).toCharArray();
                for(char c : arr) {
                    int num = c - '0';
                    visited = visited | (1 << num);
                }

                if(visited == total) {
                    ans = n*cnt;
                    break;
                }
                cnt++;
            }

            System.out.println("#" + t + " " + ans);
            t++;
        }
    }
}
