
package TIL;
import java.util.*;
import java.io.*;

/*
 * N * N 벌통 정사각형 모양
 *
 * 각 벌통에 있는 꿀의 양이 주어졌을 때 , 최대 한 많은 수익을 얻으려고 한다.
 *
 * 두 명 일꾼, 벌통의 수 M
 * 각 일꾼 연속되게 가로로 M개의 벌통 선택
 * 두 명의 일꾼 벌통 서로 겹치게 되면 안된다.
 *
 * 하나의 벌통에서 꿀을 채취할 때, 일부분만 채취할 수 없고 벌통에 있는 모든 꿀을 한번에 채취해야한다.
 *
 * 두 일꾼이 채취할 수 있는 꿀의 최대 양은 C이다.
 *
 */

public class S2115 {
    static int[][] map;
    static int N;
    static int M;
    static int L;
    static boolean[][] visited;
    static int[] memory1 = new int[2];
    static int[] memory2 = new int[2];
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while (T > t) {
            String[] input = buffer.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            L = Integer.parseInt(input[2]);
            ArrayList<Integer> maxList = new ArrayList<>();

            map = new int[N][N];
            max = 0;

            for (int i = 0; i < N; i++) {
                input = buffer.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            // ====================입력 완료===========================


            /*
             * 각 행이 큰 값을 가지는 경우 만 나올 수 있은까
             *
             * 초기값을 저장하면서 dfs 탐색 하는방법 depth로 관리
             *
             *
             */

            int money1 = 0;
            int money2 = 0;

            int A=0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= N-M; j++) {
                    money1 = makeMoney(i, j);
                    for(int x = i; x < N; x++) {
                        if(x == i)A =  j + M;
                        else A = 0;
                        for(int y = A; y <= N-M; y++) {
                            money2 = makeMoney(x,y);
                            max = Math.max(max, money1 + money2);
                        }
                    }
                }
            }
            t++;
            System.out.println("#" + t + " " + max);
        }
    }

    public static int makeMoney(int x, int y) {
        int[] H = new int[M];
        for(int i = 0; i< M; i++) {
            H[i] = map[x][y+i];
        }

        return getMoney(H, 0, 0, 0);
    }

    public static int getMoney(int[] H, int index, int cnt, int total) {

        if(cnt > L) return 0;
        if(index == M) return total;

        int select = getMoney(H, index+1, cnt+H[index], total + H[index] * H[index]);
        int nonSelect = getMoney(H, index+1, cnt, total);

        return Math.max(select, nonSelect);
    }


}
