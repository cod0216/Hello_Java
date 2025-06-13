package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J17615 {
    static int n;
    static String balls;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        balls = buffer.readLine();

        int red = 0;
        int blue = 0;

        for(int i = 0; i < n; i++){
            if(balls.charAt(i) == 'R') red++;
            else blue++;
        }

        int ans = 0;
        int count = 0;
        char color = balls.charAt(0);

        for(int i=0; i<n; i++){
            if(color != balls.charAt(i)) break;
            count++;
        }

        ans = (color == 'R') ? red - count : blue - count;

        color = balls.charAt(n-1);
        count = 0;
        for(int i = n-1; i >= 0; i--){
            if(color != balls.charAt(i)) break;
            count++;
        }
        ans = Math.min(ans,((color == 'R') ? red - count : blue - count));

        System.out.println(ans);

    }
}
