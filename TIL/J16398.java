package TIL;

import java.io.*;
import java.util.*;

class Planet implements Comparable<Planet> {
    int start;
    int end;
    int weight;

    public Planet(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public int compareTo(Planet o){
        return this.weight - o.weight;
    }
}
public class J16398 {
    static int n, map[][], arr[];
    static List<Planet> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        arr = new int[n+1];

        for(int i = 0; i <=n; i++) arr[i]=i;

        String[] input;
        for(int i = 0;  i < n; i++) {
            input = buffer.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                if(Integer.parseInt(input[j]) == 0 ) continue;
                list.add(new Planet(i+1,j+1,Integer.parseInt(input[j])));
            }
        }

        Collections.sort(list);

        long ans=0;
        for(Planet p : list){
            int a = p.start;
            int b = p.end;


            if(find(a) != find(b)) {
                union(a,b);
                ans += p.weight;
            }
        }

        System.out.println(ans);
    }

    public static int find(int a){
        if(a == arr[a]) return a;
        return arr[a] = find(arr[a]);
    }

    public static void union(int a, int b){
        int max = Math.max(find(a), find(b));
        int min = Math.min(find(a), find(b));
        arr[max] = min;
    }
}
