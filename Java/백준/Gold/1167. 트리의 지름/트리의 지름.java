
import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<int[]>[] A;
    static int[] recode;
    static boolean[] visited;
    static int maxNum;
    static int maxNode = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int index = Integer.parseInt(buffer.readLine());
        A = new LinkedList[index + 1];
        for (int i = 0; i <= index; i++) {
            A[i] = new LinkedList<>();
        }
        recode = new int[index + 1];
        visited = new boolean[index + 1];
        for (int i = 0; i < index; i++) {
            String[] input = buffer.readLine().split(" ");
            int node = Integer.parseInt(input[0]);
            int edge = Integer.parseInt(input[1]);
            int cnt = 2;
            while (edge != -1) {

                int len = Integer.parseInt(input[cnt++]);
                A[node].add(new int[]{edge, len});
                edge = Integer.parseInt(input[cnt++]);

            }
        }

        BFS( 1);
        recode = new int[index + 1];
        visited = new boolean[index + 1];
        BFS(maxNode);
        System.out.println(maxNum);
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        recode[node] = 0;

        while (!queue.isEmpty()) {
            node = queue.poll();
            for (int[] nowNode : A[node]) {
                if (!visited[nowNode[0]]) {
                    recode[nowNode[0]] = nowNode[1] + recode[node];
                    if (maxNum < recode[nowNode[0]]){
                        maxNum = recode[nowNode[0]];
                        maxNode = nowNode[0];
                    }
                    visited[nowNode[0]] = true;
                    queue.add(nowNode[0]);
                }
            }
        }
    }
}