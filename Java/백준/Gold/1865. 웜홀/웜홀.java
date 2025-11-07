import java.util.*;
import java.io.*;

public class Main {
    static int N, M, W;
    static LinkedList<int[]>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        
        while(T-- > 0){
            String[] input = buffer.readLine().split(" ");
            
            N = Integer.parseInt(input[0]);
            M = Integer.parseInt(input[1]);
            W = Integer.parseInt(input[2]);
            
            list = new LinkedList[N+1];
            
            for(int i = 0 ; i <= N; i++){
                list[i] = new LinkedList<>();
            }           
            
            for(int i = 0; i < M; i++){
                input = buffer.readLine().split(" ");

                int s = Integer.parseInt(input[0]);
                int e = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);
                
                list[s].add(new int[]{e,w});
                list[e].add(new int[]{s,w});
            }
            
            for(int i = 0; i < W; i++){
                input = buffer.readLine().split(" ");

                int s = Integer.parseInt(input[0]);
                int e = Integer.parseInt(input[1]);
                int w = Integer.parseInt(input[2]);
                
                list[s].add(new int[]{e, -w});
            }
            
            int[] arr = new int[N+1];
            Arrays.fill(arr, 0);
            
            for(int k = 0; k < N; k++){
                boolean check = false;
                for(int i = 1; i <= N; i++){
                    for(int[] now : list[i]){

                        if(arr[now[0]] > arr[i] + now[1]){
                            arr[now[0]] = arr[i] + now[1];
                            check = true;
                        }
                    }
                }
                if(!check) break;
            }
            
            boolean good = false;            
            
            for(int k = 0; k <= N; k++){
                for(int[] now : list[k]){
                    if(arr[now[0]] > arr[k] + now[1]){
                        good = true;
                        break;
                    }
                }
                if(good) break;
            }
            
            System.out.println(good ? "YES" : "NO");
        }
    }
}
