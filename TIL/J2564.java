package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class J2564 {
    static int N,M,F, mX, mY, total;
    static int[] house;
    static BufferedReader buffer;


    public static void initializeBuffer() throws IOException {
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }
    public static void setValues() throws IOException {
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        F = Integer.parseInt(buffer.readLine());
        house = new int[F+1];

        for (int i = 0; i < F; i++) {
            input = buffer.readLine().split(" ");

            int first = Integer.parseInt(input[0]);
            int seconds = Integer.parseInt(input[1]);

            house[i] = setDir(first, seconds, i);
        }
        total = 2*N + 2*M;
        input = buffer.readLine().split(" ");

        int first = Integer.parseInt(input[0]);
        int seconds = Integer.parseInt(input[1]);

        house[F] = setDir(first, seconds, F);
    }

    public static int setDir(int first, int seconds, int index){
        int x=0; int y=0;
        switch (first){
            case 1:
                y = 0;
                x = seconds;
                break;
            case 2:
                y = M + N;
                x = N-seconds;
                break;
            case 3:
                x = N*2 + M;
                y = M-seconds;
                break;
            case 4:
                x = N;
                y = seconds;
                break;
        }
        return x+y;

    }

    public static int getAns(){
        int ans=0;
        for (int i = 0; i < F; i++) {
            int a = Math.abs(house[F]-house[i]);
            int b = total-a;
            int value = Math.min(a,b);
            ans += value;
        }
        return ans;
    }
    public static void main(String[] args) throws IOException {
        initializeBuffer();
        setValues();
        System.out.println(getAns());
    }
}
