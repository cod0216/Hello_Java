package TIL;

import java.io.*;
import java.util.*;

/*
DSLR 계산기
이 계산기는 0~ 10000미만 십진수 저장 가능
D : n의 값을 두배로 바꿈
S : s는 n에서 1을 뺀 결과 값 0 이면 9999
L : 각 자리수 왼쪽으로 회전
R : 각 자리수 오른쪽으로 회전

DSLR 기능을 구현해서 쉽게 풀기
 */
public class J9019 {
    static int num, target;
    static boolean[] visited;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T >t) {
            String[] input  = buffer.readLine().split(" ");

            num = Integer.parseInt(input[0]);
            target = Integer.parseInt(input[1]);
            visited = new boolean[99999];
            arr = new String[99999];
            Arrays.fill(arr,"");

            BFS(num);
            System.out.println(arr[target]);
            t++;
        }
    }

    public static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        visited[n] = true;
        queue.add(n);
        while(!queue.isEmpty()){
            int now = queue.poll();
            if(!visited[target]) {

                int D = (2 * now) % 10000;
                int S = now == 0 ? 9999 : now - 1;
                int L = (now % 1000) * 10 + now / 1000;
                int R = (now % 10) * 1000 + now / 10;

                if (!visited[D]) {
                    queue.add(D);
                    visited[D] = true;
                    arr[D] = arr[now] + "D";
                }
                if (!visited[S]) {
                    queue.add(S);
                    visited[S] = true;
                    arr[S] = arr[now] + "S";
                }
                if (!visited[L]) {
                    queue.add(L);
                    visited[L] = true;
                    arr[L] = arr[now] + "L";
                }
                if (!visited[R]) {
                    queue.add(R);
                    visited[R] = true;
                    arr[R] = arr[now] + "R";
                }
            }
        }
    }
}
