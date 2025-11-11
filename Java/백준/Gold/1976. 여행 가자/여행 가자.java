import java.util.*;
import java.io.*;
class Info implements Comparable<Info>{
    int s;
    int e;
    int w;
    
    public Info(int s, int e, int w){
        this.s = s;
        this.e = e;
        this.w = w;
    }
    
    public int compareTo(Info o){
        return this.w - o.w;
    }
}
public class Main {
    static int[] A;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int M = Integer.parseInt(buffer.readLine());
        A = new int[N+1];
        for(int i = 0; i <= N; i++){
            A[i] = i;
        }
        
        String[] input;
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split(" ");
            
            for(int j = 0 ; j< N; j++){
                int v = Integer.parseInt(input[j]);
                if(v == 1){
                    union(i+1,j+1);
                }   
            }
        }
        
        
        input = buffer.readLine().split(" ");
        int pre = Integer.parseInt(input[0]);
        for(int i = 1; i < M; i++){
            int a = Integer.parseInt(input[i]);
            if(find(pre) != find(a)) {
                System.out.println("NO");
                return;
            }
            pre = a;
        }
        System.out.println("YES");
    }
    
    public static int find(int n){
        if(A[n] != n) return A[n] = find(A[n]);
        return n;
    }

    public static void union(int a, int b){    
        int max =Math.max(find(a),find(b));
        int min =Math.min(find(a),find(b));
        
        A[max] = min;
    }
}
