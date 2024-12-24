package TIL;

import java.util.*;
import java.io.*;

public class J15787 {

    public static void main(String[] args) throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        boolean[][] train = new boolean[n][20];

        while (m-- > 0) {

            input = buffer.readLine().split(" ");

            int c = Integer.parseInt(input[0]);
            int a, b;

            switch(c) {
                case 1:
                    a = Integer.parseInt(input[1]);
                    b = Integer.parseInt(input[2]);
                    train[a-1][b-1] = true;
                    break;
                case 2:
                    a = Integer.parseInt(input[1]);
                    b = Integer.parseInt(input[2]);
                    train[a-1][b-1] = false;
                    break;
                case 3:
                    a = Integer.parseInt(input[1]);
                    for (int i = 19; i > 0; i--) {
                        train[a-1][i] = train[a-1][i-1];
                    }
                    train[a-1][0] = false;
                    break;
                case 4:
                    a = Integer.parseInt(input[1]);
                    for (int i = 0; i < 19; i++) {
                        train[a-1][i] = train[a-1][i+1];
                    }
                    train[a-1][19] = false;
                    break;
            }
        }

        ArrayList<String> list = new ArrayList<>();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 20; j++) {
                if (train[i][j]) sb.append("1");
                else sb.append("0");
            }
            String str = sb.toString();

            if (!list.contains(str)) {
                list.add(str);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}