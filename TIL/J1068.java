package TIL;

import java.io.*;
import java.util.*;

public class J1068 {
    static int[] tree;
    static boolean[] visited;
    static int value = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(buffer.readLine());

        tree = new int[node];
        visited = new boolean[node];

        String[] input = buffer.readLine().split(" ");
        int root = 0;
        for (int i = 0; i < node; i++) {
            tree[i] = Integer.parseInt(input[i]);
            if (tree[i] == -1) root = i;
        }
        int removeNode = Integer.parseInt(buffer.readLine());

        removeNode(removeNode);
        findLeaf(root);

        System.out.println(value);
    }

    public static void removeNode(int node) {
        tree[node] = -2;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == node) {
                removeNode(i);
            }
        }
    }

    public static void findLeaf(int node) {
        boolean check = true;
        visited[node] = true;
        if(tree[node] != -2){
            for(int i = 0; i<tree.length; i++) {
                if (!visited[i] && tree[i] == node) {
                    findLeaf(i);
                    check = false;
                }
            }
            if(check) value++;
        }

    }
}