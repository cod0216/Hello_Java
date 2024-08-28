package TIL;

import java.io.*;
import java.util.*;
/*
LinkedList를 사용해서 순차적으로 입력값을 넣어주고
home 값인 1번째 인덱스의 값과 맨 마지막 index를 스왑해준다.

2차원 배열을 만들어서
0번 인덱스인 회사를 기준으로 각 고객의 집을 방문했을때의 거리를 2차원 배열 0번째에 넣어주고
고객의 집을 기준으로 회사, 다른 고객, 집 까지의 거리를 미리 다 구해서 2차원 배열에 넣어준다.

이후 순열을 이용해서 각 경우의 수를 구해서 거리의 최소값을 구한다.

[실수했던 부분]
회사에서 고객의 집을 방문할때 순열의 기저 조건이 n==2 즉 depth와 고객의 수가 같을때 빠져나오게 했는데
회사에서 고객 집을 방문할때 1을 줘버려서 디버깅하는데 많은 시간 낭비를 했다.

디버깅을 할떄는 경게값 체크를 우선적으로 해야겠다.
 */

public class S1247 {
    static int min;
    static int n;
    static int m;
    static LinkedList<int[]>[] A;
    static boolean[] visited;
    static int[][] distance;

    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T > t){
            min = Integer.MAX_VALUE;
            n = Integer.parseInt(buffer.readLine());
            m = n+2;
            A = new LinkedList[m];
            visited = new boolean[m];

            String[] input = buffer.readLine().split(" ");
            for(int i = 0 ; i< m; i++){
                A[i] = new LinkedList<>();
            }

            A[0].add(new int[]{Integer.parseInt(input[0]), Integer.parseInt(input[1])});
            A[1].add(new int[]{Integer.parseInt(input[2]), Integer.parseInt(input[3])});
            distance = new int[m][m];
            for(int i = 2 ; i < m; i++){
                A[i].add(new int[]{Integer.parseInt(input[i*2]), Integer.parseInt(input[i*2+1])});
            }

            LinkedList<int[]> temp = A[1];
            A[1] = A[m-1];
            A[m-1] = temp;

            for(int i = 0; i < m; i++){
                int firstX = A[i].get(0)[0];
                int firstY = A[i].get(0)[1];
                for(int j = 0 ; j < m; j++) {
                    int secondX = A[j].get(0)[0];
                    int secondY = A[j].get(0)[1];
                    int x = Math.abs(firstX - secondX);
                    int y = Math.abs(firstY - secondY);
                    distance[i][j] = x+y;
                    distance[j][i] = x+y;
                }
            }

            find(0,0,0);
            t++;
            System.out.println("#" + t + " " + min);
        }
    }

    public static void find(int depth, int dis, int lastNode){
        if(depth == n) {
            dis += distance[lastNode][m-1];
            min = Math.min(min, dis);
            return;
        }
        if(min < dis) return;

        for(int i = 1 ; i < m-1; i++) {
            if(distance[lastNode][i] == 0) continue;
            if (!visited[i] ) {
                visited[i] = true;
                find(depth+1,dis+distance[lastNode][i] ,i);
                visited[i] = false;
            }
        }
    }
}
