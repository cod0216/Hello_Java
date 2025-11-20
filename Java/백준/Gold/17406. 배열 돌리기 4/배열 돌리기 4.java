import java.util.*;
import java.io.*;

public class Main {
    static int N, M, R, min, map[][];
    static int[] xR, xC, xS;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        
        map = new int[N][M];
        min = Integer.MAX_VALUE;
        visited = new boolean[R];
        
        
        for(int i = 0 ; i < N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j < M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        
        xR = new int[R]; xC = new int[R]; xS = new int[R];
        
        for(int i = 0; i < R; i++){
            input = buffer.readLine().split(" ");
            xR[i] = Integer.parseInt(input[0]);
            xC[i] = Integer.parseInt(input[1]);
            xS[i] = Integer.parseInt(input[2]);                
        }
        
        dfs(new int[R], 0);
        System.out.println(min);
        
    }
    
    public static void dfs(int[] arr, int idx){
        if(idx == R){
            int[][] temp = new int[N][M];
            for(int i = 0 ; i < N; i++){
                temp[i] = Arrays.copyOf(map[i], M);
            }

            for(int k = 0 ; k < R ; k++){
                int r = xR[arr[k]] - 1;
                int c = xC[arr[k]] - 1;
                int s = xS[arr[k]];
                
                for(int d = 1; d <= s; d++){
                    int top = r - d;
                    int left = c - d;
                    int bottom = r + d;
                    int right = c + d;
                    
                    ArrayList<Integer> list = new ArrayList<>();
                    
                    for(int j = left; j < right; j++) list.add(temp[top][j]);
                    for(int i2 = top; i2 < bottom; i2++) list.add(temp[i2][right]);
                    for(int j = right; j > left; j--) list.add(temp[bottom][j]);
                    for(int i2 = bottom; i2 > top; i2--) list.add(temp[i2][left]);
                    
                    Collections.rotate(list, 1);
                    
                    int index = 0;
                    for(int j = left; j < right; j++) temp[top][j] = list.get(index++);
                    for(int i2 = top; i2 < bottom; i2++) temp[i2][right] = list.get(index++);
                    for(int j = right; j > left; j--) temp[bottom][j] = list.get(index++);
                    for(int i2 = bottom; i2 > top; i2--) temp[i2][left] = list.get(index++);
                }
            }            
            for(int i = 0; i < N; i++){
                int sum = 0;
                for(int j = 0; j < M; j++){
                    sum += temp[i][j];
                }
                min = Math.min(min, sum);
            }
            return;
        }
    
        for(int i = 0 ; i < R; i++){
            if(!visited[i]){
                arr[idx] = i;
                visited[i] = true;
                dfs(arr, idx+1);            
                visited[i] = false;
            }
        }

    }
}
