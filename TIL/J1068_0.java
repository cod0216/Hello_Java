package TIL;

import java.io.*;
import java.util.*;

public class J1068_0 {
    static int n;
    static int[] array;
    static boolean[] visited;
    static int cnt =  0;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buffer.readLine());
        array = new int[n];
        visited = new boolean[n];

        int root = 0;
        String[] input = buffer.readLine().split(" ");

        for(int i = 0; i< n; i++){
            array[i] = Integer.parseInt(input[i]);
            if(array[i] == -1) root = i;
        }

        int removeNode = Integer.parseInt(buffer.readLine());
        removeNode(removeNode);
        findLeaf(root);

        System.out.println(cnt);
    }
    public static void removeNode(int node){
        array[node] = -2;
        for(int i = 0 ; i< n; i++){
            if(array[i] == node){
                removeNode(i);
            }
        }
    }

    public static void findLeaf(int node){
        boolean check =  true;
        visited[node] = true;
        if(array[node] != -2) {
            for (int i = 0; i < n; i++) {
                if (array[i] == node && !visited[i]) {
                    findLeaf(i);
                    check = false;
                }
            }
            if(check) cnt++;
        }
    }
}
