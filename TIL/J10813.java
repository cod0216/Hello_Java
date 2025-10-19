package TIL;

import java.io.*;
import java.util.*;

public class J10813 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] basket = new int[N + 1];
        for (int i = 1; i <= N; i++) basket[i] = i;

        for (int k = 0; k < M; k++) {
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int tmp = basket[i];
            basket[i] = basket[j];
            basket[j] = tmp;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            if (i > 1) sb.append(' ');
            sb.append(basket[i]);
        }
        System.out.println(sb.toString());
    }
}