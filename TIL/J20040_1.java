package TIL;

import java.io.*;
import java.util.*;

public class J20040_1 {
    static int n, m, arr[];
    static List<Integer>[] list;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n];
        list = new ArrayList[n];
        for(int i = 0; i < n; i++){
            arr[i] = i;
        }

        for(int i = 0; i < n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < m; i++) {
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            if(!union(start,end)){
                System.out.println(i+1);
                return;
            }
        }
        System.out.println(0);
    }

    public static int find(int num ){
        if(num == arr[num]) return arr[num];
        return arr[num] = find(arr[num]);
    }

    public static boolean union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));

        if(max == min) return false;
        arr[max]=min;
        return true;
    }
}
