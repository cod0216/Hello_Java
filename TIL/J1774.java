package TIL;

import java.io.*;
import java.util.*;

/*
 * 항선자씨는 우주신과 교감을 할 수 있는 채널러이다.
 * 매번 여럿의 우주신과 교감하느라 힘드시단다
 * 새로운 우주신이 황선자씨 이용
 * 우주신은 황선자씨와 바로 연결될 필요없다.
 * 이미 황선자씨와 교감할 수 있는 우주신들이 있기때문에 거쳐서 교감할 수있다.
 *
 * 우주신들과의 교감은 우주신들과 황선자시 혹은 우지신들 끼리 이어진 정신적인 통로를 통해 이루어진다.
 * 근데 항선자시는 통로 길어질수록 않좋아함
 *
 *
 * 대츙 유니온 파인드 사용해서 크루스칼 조져야될듯
 */

class Noode implements Comparable<Noode> {
    public int start;
    public int end;
    public double weight;

    public Noode(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Noode o) {

        return Double.compare(this.weight, o.weight);
    }

}

public class J1774 {
    static ArrayList<Noode> list;
    static int[] pointX, pointY, parents;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        list = new ArrayList<>();
        pointX = new int[N + 1];
        pointY = new int[N + 1];
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            input = buffer.readLine().split(" ");
            pointX[i] = Integer.parseInt(input[0]);
            pointY[i] = Integer.parseInt(input[1]);
            parents[i] = i;

        }
        // 입력 완료

        for (int i = 0; i < M; i++) {
            input = buffer.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            int max = Math.max(a, b);
            int min = Math.min(a, b);
            max = find(max);
            min = find(min);

            if (max != min)
                union(min, max);
        }

        match();
        kruskal();

    }

    public static void match() {
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double w = Math.sqrt(Math.pow(pointX[i] - pointX[j], 2) + Math.pow(pointY[i] - pointY[j], 2));
                list.add(new Noode(i, j, w));
            }
        }
    }

    public static void kruskal() {
        Collections.sort(list);
        double ans = 0;

        for (Noode node : list) {
            if (find(node.start) != find(node.end)) {
                ans += node.weight;
                union(node.start, node.end);
            }
        }
        System.out.printf("%.2f\n", ans);
        ;
    }

    public static int find(int node) {
        if (node != parents[node])
            return parents[node] = find(parents[node]);
        return parents[node];
    }

    public static void union(int min, int max) {
        int rootMin = find(min);
        int rootMax = find(max);

        if(rootMin != rootMax){
            parents[rootMax] = rootMin;
        }
    }
}
