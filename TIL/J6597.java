package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class J6597 {
    static char[] pre, in;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String input = buffer.readLine();
            if (Objects.isNull(input)) break;

            String a = input.split(" ")[0];
            String b = input.split(" ")[1];

            pre = a.toCharArray();
            in = b.toCharArray();

            post(0, 0, pre.length);
            System.out.println();
        }
    }

    private static void post(int r, int from, int to) {
        if (r >= pre.length) return;

        char root = pre[r];

        for (int i = from; i < to; i++) {
            if (root == in[i]) {
                post(r + 1, from, i);
                post(r + (i - from + 1), i + 1, to);
                System.out.print(root);
                return;
            }
        }
    }
}

