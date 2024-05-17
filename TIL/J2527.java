package TIL;

import java.io.*;
import java.util.*;

public class J2527 {
    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while(cnt != 4){
            String[] input = buffer.readLine().split(" ");

            int x1= Integer.parseInt(input[0]);
            int y1= Integer.parseInt(input[1]);
            int p1= Integer.parseInt(input[2]);
            int q1= Integer.parseInt(input[3]);

            int x2= Integer.parseInt(input[4]);
            int y2= Integer.parseInt(input[5]);
            int p2= Integer.parseInt(input[6]);
            int q2= Integer.parseInt(input[7]);

            if((p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1)) System.out.println("d");
            else if ((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) System.out.println("c");
            else if((p1 == x2) || (q1 == y2) || (x1 == p2) || ( y1 == q2)) System.out.println("b");
            else System.out.println("a");
            cnt++;
        }
    }
}
