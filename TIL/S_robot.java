package TIL;

import java.io.*;

public class S_robot {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int n = 0;
        while (T > n) {
            int N = Integer.parseInt(buffer.readLine());

            char[][] ground = new char[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = buffer.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    ground[i][j] = input[j].charAt(0);
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // 부루트포스로 배열 모든 요소 순회해사 A,B,C 인 경우 해당 조건에 맞게 구현
                    if (ground[i][j] == 'A') {
                        for (int k = j + 1; k < N; k++) {
                            if (ground[i][k] == 'S') cnt++; // S인 경우만 카운트
                            else break; // S가 아닌 다른 글자를 만나면 break;
                        }
                    } else if (ground[i][j] == 'B') {
                        for (int k = j + 1; k < N; k++) {
                            if (ground[i][k] == 'S') cnt++;
                            else break;
                        }
                        for (int k = j - 1; k > -1; k++) {
                            if (ground[i][k] == 'S') cnt++;
                            else break;
                        }

                    } else if (ground[i][j] == 'C') {
                        for (int k = j + 1; k < N; k++) {
                            if (ground[i][k] == 'S') cnt++;
                            else break;
                        }
                        for (int k = j - 1; k > -1; k--) {
                            if (ground[i][k] == 'S') cnt++;
                            else break;
                        }
                        for (int k = i + 1; k < N; k++) {
                            if (ground[k][j] == 'S') cnt++;
                            else break;
                        }
                        for (int k = i - 1; k > -1; k--) {
                            if (ground[k][j] == 'S') cnt++;
                            else break;
                        }
                    }
                }
            }
            System.out.println(cnt);
            n++;
        }

    }
}
