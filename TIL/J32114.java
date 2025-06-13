package TIL;

import java.io.*;
import java.util.StringTokenizer;

/*
처음 가는 길을 운전할 때
갈림길을 잘못 들거나 차선을 잘못 타서 곤란해하는 사람을 지켜본 경험이 누구나 한 번쯤은 있다.
네비게이션이 있어도 초행길은 네비게이션 화면과 실제로

 */

public class J32114 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");


        // 도시의 수 N과 교통 정보의 수 M 읽기
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        // 각 도로의 차선 수 (총 N-1개의 도로)
        long[] roads = new long[N - 1];
        input = buffer.readLine().split(" ");

        for (int i = 0; i < N - 1; i++) {
            roads[i] = Long.parseLong(input[i]);
        }

        // 각 도로(도시 i와 i+1 사이)의 차량 수를 구하기 위한 차이 배열 생성
        // 길이는 N (마지막 도시는 도로가 없으므로 실제 사용은 N-1까지)
        long[] diff = new long[N];

        // M개의 교통 정보를 처리
        for (int i = 0; i < M; i++) {
            input = buffer.readLine().split(" ");

            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            long x = Long.parseLong(input[2]);

            // u번 도시부터 (v-1)번 도로까지 x대를 추가
            diff[u - 1] += x;
            // v번 도시 이후 도로에 대해서 x대를 빼준다.
            diff[v - 1] -= x;
        }

        // 차이 배열의 prefix sum을 구하여 각 도로의 차량 수를 계산
        long[] traffic = new long[N - 1];  // 도로 i (0-indexed): 도시 i와 i+1 사이의 도로
        long curr = 0;
        for (int i = 0; i < N - 1; i++) {
            curr += diff[i];
            traffic[i] = curr;
        }

        // BufferedWriter를 사용해 결과를 빠르게 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 각 도로마다 '도로 부담'을 계산
        // 부담 = (w - r) * a^2 + r * (a+1)^2, where a = c / w, r = c % w.
        for (int i = 0; i < N - 1; i++) {
            long c = traffic[i];  // 해당 도로를 지나는 차량 수
            long w = roads[i];    // 해당 도로의 차선 수

            long a = c / w;       // 각 차선에 기본적으로 할당할 차량 수
            long r = c % w;       // 추가로 1대를 더 할당해야 하는 차선의 수

            // 최적 분배에 따른 도로 부담 계산
            long burden = (w - r) * a * a + r * (a + 1) * (a + 1);
            bw.write(String.valueOf(burden));
            bw.newLine();
        }
    }

}
