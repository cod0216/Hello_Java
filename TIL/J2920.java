package TIL;
import java.io.*;
import java.util.*;

public class J2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int[] num = new int[8];

        for(int i = 0; i < 8; i++){
            num[i] = Integer.parseInt(input[i]);
        }

        int n = 7;
        int d = 0;
        boolean down = false;
        boolean up = false;

        for(int i = 0; i < 8; i++){
            if(num[0] == 1){
                if(num[i] - d++ == 1){
                    up = true;
                } else {
                    System.out.println("mixed");
                    return;
                }
            } else if (num[0] == 8){
                if(num[i] - n-- == 1){
                    down = true;
                } else {
                    System.out.println("mixed");
                    return;
                }
            } else {
                System.out.println("mixed");
                return;
            }
        }

        if(up) System.out.println("ascending");
        else if (down) System.out.println("descending");

    }
}
