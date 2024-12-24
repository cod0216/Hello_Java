package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10800 {

    static int n, arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(buffer.readLine());

        arr = new int[n+1];
        for(int i = 0; i<=n; i++){
            arr[i] = i;
        }

        String[] input;
        for(int i = 0 ; i < n; i++){
            input = buffer.readLine().split(" ");
            int n1 = Integer.parseInt(input[0]);
            int n2 = Integer.parseInt(input[1]);

            union(i+1, n1);
            // 아;
        }


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
