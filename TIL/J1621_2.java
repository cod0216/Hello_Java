package TIL;

import java.util.*;
import java.io.*;

public class J1621_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] bait = new long[N];
        long[] fish = new long[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) bait[i] = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) fish[i] = Long.parseLong(st.nextToken());

        Arrays.sort(fish);

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) pq.add(bait[i]);

        long[] caught = new long[M];
        int c = 0;
        int idx = 0;

        while (!pq.isEmpty()) {
            long b = pq.poll();

            while (idx < M && fish[idx] <= b) idx++;
            if (idx >= M) break;

            long f = fish[idx++];
            caught[c++] = f;
            pq.add(f);
        }

        long ans = 0;
        int take = Math.min(N, c);
        for (int i = c - take; i < c; i++) ans += caught[i];

        System.out.println(ans);
    }
}
