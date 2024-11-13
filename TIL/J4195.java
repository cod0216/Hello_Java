package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class J4195 {
    static int f, parent[], size[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input;
        int n = Integer.parseInt(buffer.readLine());



        for(int t= 0; t < n; t++){
            f = Integer.parseInt(buffer.readLine());
            parent = new int[f*2+1];
            size = new int[f*2+1];

            Arrays.fill(size, 1);
            for(int i = 0; i<= f*2; i++) parent[i] = i;

            HashMap<String, Integer> map = new HashMap<>();

            int index = 0;
            for(int i= 0; i< f; i++){
               input = buffer.readLine().split(" ");

               if(!map.containsKey(input[0])){
                   map.put(input[0],index++);
               }
               if(!map.containsKey(input[1])){
                   map.put(input[1],index++);
               }
                union(find(map.get(input[0])), find(map.get(input[1])));
            }
        } // tc end
    }

    public static int find (int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static void union(int a, int b){
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        if(max != min) {
            parent[max] = min;
            size[min] += size[max];
        }
        System.out.println(size[min]);
    }

//    Set<Integer> a = new
}
