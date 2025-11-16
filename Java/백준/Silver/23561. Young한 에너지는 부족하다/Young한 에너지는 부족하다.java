import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));


        int N = Integer.parseInt(buffer.readLine());
        
        String[] input = buffer.readLine().split(" ");       
        int M = N*3;
        int[] arr = new int[M];
        for(int i = 0 ; i < M; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(arr);
        int idx = 0;
        
        int[][] map = new int[N][3];
        for(int i = 0 ; i < 3; i++){
            for(int j = 0 ; j < N; j++){
                map[j][i] = arr[idx++];
            }
        }
        
        int mid = map[0][1];
        int lastMid = map[N-1][1];

        System.out.println(lastMid - mid);
        
    }
}
