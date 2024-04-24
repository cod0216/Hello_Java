package TIL;

import java.util.*;
import java.io.*;

    public class J1167_0 {
        static LinkedList<int[]>[] A;
        static boolean[] visited;
        static int maxNode;
        static int maxNum;
        static int[] distance;
        public static void main(String[] args) throws IOException {
            Scanner scanner = new Scanner(System.in);

            int num = scanner.nextInt();
            A = new LinkedList[num+1];
            distance = new int[num+1];
            visited = new boolean[num+1];

            for(int i = 0 ; i < num+1; i++){
                A[i] = new LinkedList<>();
            }
            for(int i = 1; i <= num; i++){
                int node = scanner.nextInt();
                int edge = scanner.nextInt();
                while(edge != -1){

                    int len = scanner.nextInt();
                    A[node].add(new int[]{edge,len});
                    edge = scanner.nextInt();
                }
            }

            BFS(1, 0 );
            visited = new boolean[num+1];
            distance = new int[num+1];
            BFS(maxNode, distance[maxNode]);

            System.out.println(maxNum);

        }
        private static void BFS(int node, int len){
            visited[node] = true;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(node);
            distance[node] = len;
            while(!queue.isEmpty()){
                node = queue.poll();

                for(int[] i : A[node]){
                    if(!visited[i[0]]){
                        visited[i[0]] = true;
                        distance[i[0]] = distance[node]+i[1];
                        if(maxNum < distance[i[0]]){
                            maxNum = distance[i[0]];
                            maxNode = i[0];
                        }
                        queue.add(i[0]);

                    }
                }
            }


        }

    }