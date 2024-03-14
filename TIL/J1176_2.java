package TIL;

import java.util.*;
import java.io.*;

public class J1176_2 {
    static LinkedList<int[]>[] A;
    static boolean[] visited;
    static int node;
    static int[] distance;
    static int max = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        visited = new boolean[num+1];

        A = new LinkedList[num+1];
        for(int i = 1; i <= num; i++){
            A[i] = new LinkedList<>();
        }
        int cnt = 1;
        for(int i = 1; i <= num; i++){
            int n = scanner.nextInt();
            while(true) {
                int e = scanner.nextInt();
                if (e == -1) {
                    break;
                }
                int dis = scanner.nextInt();
                A[n].add(new int[] {e, dis});
            }
        }
        distance = new int[num+1];
        BFS(1, 0);
        visited = new boolean[num+1];
        distance = new int[num+1];
        BFS(node, distance[node]);
        System.out.println(max);
    }

    public static void BFS(int n, int dis){
        Queue<Integer> queue = new LinkedList<>();
        visited[n] = true;
        queue.add(n);
        distance[n] = dis;
        while(!queue.isEmpty()){
            int now = queue.poll();
            for(int[] i : A[now]){
                if(!visited[i[0]]){
                    visited[i[0]] = true;
                    distance[i[0]] = i[1]+distance[now];
                    if(distance[i[0]] > max){
                        max = distance[i[0]];
                        node = i[0];
                    }
                    queue.add(i[0]);
                }
            }
        }

    }
}
