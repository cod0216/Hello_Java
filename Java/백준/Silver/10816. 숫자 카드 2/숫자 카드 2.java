import java.util.*;
import java.io.*;

public class Main {
    static int[] card;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");
        card = new int[N];
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(input[i]);
        }
        
        int M = Integer.parseInt(buffer.readLine());
        Arrays.sort(card);
        
        int[] target = new int[M];
        input = buffer.readLine().split(" ");
        
        for(int i = 0 ; i < M; i++){
            target[i] = Integer.parseInt(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M; i++){
            int t = target[i];
            int ans = high(t,N)-low(t,N);
            sb.append(ans + " ");
        }        
        System.out.println(sb.toString());
    }
    public static int low(int t, int n){
        int s = 0;
        int e = n;
        while(s < e){
            int m = (s+e)/2;
            if(t <= card[m]){
                e = m;
            } else{
                s = m+1;
            }
        }
        return s;
    }

    public static int high(int t, int n){
        int s = 0;
        int e = n;
        while(s < e){
            int m = (s+e)/2;
            if(t < card[m]){
                e = m;
            } else{
                s = m+1;
            }
        }
        return s;
    }
}
