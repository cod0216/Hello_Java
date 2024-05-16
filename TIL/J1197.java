package TIL;

import java.io.*;
import java.util.*;

public class J1197 {
    static int[] array;
    static ArrayList<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int node = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);

        array = new int[node+1];
        list = new ArrayList[edge];

        for(int i = 0; i<= node; i++){
            array[i] = i;
        }

        int cnt = 0;
        long value = 0;

        for(int i = 0; i< edge; i++){
            list[i] = new ArrayList<>();

            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list[i].add(new int[]{start, end, weight});
        }
        Arrays.sort(list, Comparator.comparingInt(o -> o.get(0)[2]));

        for(int i = 0; i< edge; i++){
            int[] now = list[i].get(0);
            int min= Math.min(now[0],now[1]);
            int max= Math.max(now[0],now[1]);
            int x = find(min);
            int y = find(max);

            if (x != y) {
                union(x, y);
                cnt++;
                value += now[2];
            }else continue;
            if (cnt == node - 1) break;
        }


        System.out.println(value);

    }
    public static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(array[a] != array[b]) array[array[b]] = array[array[a]];
    }
    public static int find(int a){
        if(array[a] == a) return a;
        return array[a] = find(array[array[a]]);
    }
}
