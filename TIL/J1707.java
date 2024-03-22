package TIL;

import java.util.*;

public class J1707 {
    static int[] union;
    static boolean[] visited;
    static boolean isEven;
    static LinkedList<Integer>[] linkedList;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();

        while(testCase > 0){
            int node = scanner.nextInt();
            int edge = scanner.nextInt();
            union = new int[node+1];
            visited = new boolean[node+1];
            linkedList = new LinkedList[node+1];
            isEven = true;
            for(int i = 0; i <= node; i++){
                linkedList[i] = new LinkedList<Integer>();
            }
            for(int i = 0; i < edge; i++){
                int s = scanner.nextInt();
                int e = scanner.nextInt();

                linkedList[s].add(e);
                linkedList[e].add(s);
            }
            for(int i = 1; i <=node; i++) {
                if(isEven) {
                    visited[i] = true;
                    DFS(i);
                }
                else break;
            }
            if(isEven)
                System.out.println("YES");
            else System.out.println("NO");
            testCase--;
        }

    }

    private static void DFS(int n){

            for (int node : linkedList[n]) {
                if(!visited[node]) {
                    visited[node] =true;
                    union[node] = (union[n] + 1) % 2;
                    DFS(node);
                }
                else {
                    if (union[n] == union[node])
                        isEven = false;
                }

            }
    }

}

