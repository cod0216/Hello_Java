package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class J230861{
    int idx;
    int start;
    int end;

    public J230861(int idx, int start, int end) {
        this.idx = idx;
        this.start = start;
        this.end = end;
    }
}

public class J23086 {
    static LinkedList<J230861> list[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        boolean[] visited = new boolean[n];

        list = new LinkedList[n+1];

        for(int i = 1; i <= n; i++){
            list[i] = new LinkedList<>();
        }

        for(int i = 1 ; i <= m; i++){
            input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            list[a].add(new J230861(i, a, b));
        }

        for(int i = 0; i < k; i++){
            int num = Integer.parseInt(buffer.readLine());
            visited[num] = true;

            // Somthing(탐색)
        }
    }
}
