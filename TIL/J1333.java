package TIL;

import java.util.*;
import java.io.*;

public class J1333 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int D = Integer.parseInt(input[2]);

        int ring = D;
        int time = L - 1;
        int t = 0;
        int rest = time + 5;
        while (t < N) {
            if (time < ring && ring < rest) {
                System.out.println(ring);
                return;
            }
            time = rest + L;
            rest = time + 5;
            if (ring < time) {
                ring = ring + ring;
            }

            t++;
        }
    }

}
