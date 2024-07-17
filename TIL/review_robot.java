package TIL;

import java.io.*;

public class review_robot {
    static char[][] ground;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int n = 0;
        while (T > n) {
            int N = Integer.parseInt(buffer.readLine());

            ground = new char[N][N];

            for (int i = 0; i < N; i++) {
                String[] input = buffer.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    ground[i][j] = input[j].charAt(0);
                }
            }
            cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (ground[i][j] == 'A') {
                        right(i, j, N);
                    } else if (ground[i][j] == 'B') {
                        right(i, j, N);
                        left(i, j,-1);
                    } else if (ground[i][j] == 'C') {
                        right(i, j, N);
                        left(i, j,-1);
                        down(j,i,N);
                        up(j,i,-1);
                    }
                }
            }
            System.out.println(cnt);
            n++;
        }

    }

    public static void right(int fix, int j, int endIndex){
        int start = j+1;
        for(int i = start; i < endIndex; i++){
            if (ground[fix][i] == 'S') cnt++;
            else break;
        }
    }
    public static void left(int fix, int j, int endIndex){
        int start = j-1;
        for(int i = start; i > endIndex; i--){
            if (ground[fix][i] == 'S') cnt++;
            else break;
        }
    }
    public static void down(int fix, int j, int endIndex){
        int start = j+1;
        for (int i = start; i < endIndex; i++) {
            if (ground[i][fix] == 'S') cnt++;
            else break;
        }
    }
    public static void up(int fix, int j, int endIndex){
        int start = j-1;
        for (int i = start; i > endIndex; i--) {
            if (ground[i][fix] == 'S') cnt++;
            else break;
        }
    }
}
