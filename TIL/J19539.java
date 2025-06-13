package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 1 2 1 2 -> 6
 1 1 2 2 -> 6
 1 1 1 1 2 2 -> x
 */
public class J19539 {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(buffer.readLine());

        int d = 0;
        int s = 0;
        int sum = 0;

        String[] input = buffer.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(input[i]);
            sum += h;

            d+=h/2;
        }

        if(sum%3 == 0){
            if(sum/3 <= d) {
                System.out.println("YES");
                return;
            }
        }
        System.out.println("NO");

    }
}
