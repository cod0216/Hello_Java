package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10220 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());
        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(buffer.readLine());

            if(m == 1 || m == 2 || m == 3 || m == 6) System.out.println(0);
            else if(m == 4) System.out.println(2);
            else System.out.println(1);
        }
    }
}
