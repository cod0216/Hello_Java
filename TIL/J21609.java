package TIL;

import java.nio.Buffer;
import java.util.*;
import java.io.*;

/*

검은색 블록, -1
무지개 블록, 0으로 표현
일반 블록, M가지 색상

* |r1 - r2| + |c1 - c2| = 1을 만족하는 두 칸 (r1, c1)과 (r2, c2)를 인접한 칸

블록 그룹은 연결된 블록의 집합
그룹에는 일반 블록이 적어도 하나 있어야 하며, 일반 블록의 색은 모두 같아야 한다.
검은 블록은 포함되면 안됨, 무지개 블록은 얼마든지 포함되어있어도 상관없다.

그룹에 있는 블록의 개수는 2보다 크거나 같아야 한다.

임의의 한 블록 선택시 그 블록이 속한 그룹의 다른 블룩칸으로 이동할 수 있어야한다.
블록 그룹 기준 블록은 무지개 블록이 아닌 블록 중에서 행번호가 가장 작은 블록, 그러한 블록이 여러개면 열 의 번호가
가장 작은 블록이 답
열 : |||
행 " =

1.
그룹의 크기가 가장 큰 그룹 찾기 (유,파 -> cnt)
동일한 cnt { 1. 무지개 , 2. 기분블록 행 큰값, 열이 가장 큰 값}
2. 찾은 블록의 그룹의 모든 블록 제거 (카운트 필요) 카운트 시 B^2점 획득
3. 격자 중력
4. 격자가 90도 반시계 방향 회전
5. 다시 중력

<기준 블록 선택 방법 > 해당 그룹에서 행번호가 가장 작은 블록, 열 번호가 가장 작은 블록

중력이란?  검정 블록을 제외한 모든 블록이 행 번호가 큰 칸으로 이동한다.

검은 블록은 폭탄인듯

N : 배열 한 변
M : 일반 블록 개수

BFS() 미로탐색
같은 블록 및 0 값의 좌표를 arrlist[] 각 값에 넣기
arraylist값 size() 큰놈 찾기
찾은 큰놈에서 2개 이상 있는 경우 행 번호가 큰 블록, 큰 행 블록 2개 이상시 열 번호 쿤 블록

이거 조건으로 만들기


중력 로직

열 기준 -2 직전 좌표 탐색 기준 |  가낭 큰 행 부터 탐색 -1 탐색 false 그 위에 탐색 진행 이 직전 좌표에 넣기
//
 */
public class J21609 {

    static ArrayList<int[]>[] dirList;
    static int[] dx = new int[]{1, 0, -1, 0 };
    static int[] dy = new int[]{0, 1, 0, -1 };

    static int N;
    static int M;
    static int[] generalBlock;
    static int[][] map;
    static int cnt;
    static ArrayList<Integer> cntList;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        generalBlock = new int[M];

        for(int i = 1; i <= M ; i ++){
            generalBlock[i] = i;
        } // 일반 블록 초기화

        map = new int[N][N];

        for(int i = 0; i<N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j<N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        // 1. 기준 먼저 찾기

        /*
        임의의 한 블록 선택시 그 블록이 속한 그룹의 다른 블룩칸으로 이동할 수 있어야한다.
        블록 그룹 기준 블록은 무지개 블록이 아닌 블록 중에서 행번호가 가장 작은 블록, 그러한 블록이 여러개면 열 의 번호가
        가장 작은 블록이 답
         */
        // 2. 이후 BFS탐

        //3.  if( if( if()) ) 이 조건으로 그룹 선택

//======================================================

        // 4. 선택된 그룹 cnt 및 -2로 변환
        // 5, 중력 [배열 옮기기]
        // 6. 회전 드립;
        // 7. 중력 드립;

    }

    public static void BFS(int[] dir){
        int cnt = 0;
        int x = dir[0];
        int y = dir[1];
        int select = map[x][y];

        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(dir);
        while(!queue.isEmpty()){
            int[] dummy = queue.poll();
            x = dummy[0];
            y = dummy[1];

            for(int d = 0 ; d < 4 ; d++){
                int nx = x + dx[d];
                int ny = y + dy[d];
                if(isIn(nx,ny)){
                    if(map[nx][ny] == select || map[nx][ny] == 0){
                        queue.offer(new int[]{nx,ny});
                        cnt++;
                    }
                }
            }

        }
        cntList.add(cnt);
    }


    public static boolean isIn(int x, int y){
        if(x >= 0 && y>= 0 && x < N && y < N ) return true;
        return false;
    }

}
