import java.io.*;
import java.util.*;
import java.util.function.Predicate;

public class Main {
    static int N, M, map[][];
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        
        map = new int[N][M];
        visited = new boolean[N][M];
        Predicate<Integer> p = v -> v%2==0;
        
        int odd=0; int even = 0;
        for(int i = 0 ; i < N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j < M; j++){
                int v = Integer.parseInt(input[j]);
                map[i][j] = Integer.parseInt(input[j]);
                if (p.test(v)) even++;
                else odd++;
            }
        } // input
        
        if(!p.test(even) || !p.test(odd)) {
            System.out.println("-1");
            return;
        }
        
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < M; j++){
                remove(i,j);
            }
        }    
 
        System.out.println("-1"); 
        
    }
    
    public static void remove(int x, int y){
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});
        visited[x][y] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0]; int cy = cur[1];
            
            if(map[cx][cy] == 1){
                for(int i = 0; i< 4; i++){
                    int nx = cx+ dx[i];
                    int ny = cy+ dy[i];
                    
                    if(isIn(nx,ny) && !visited[nx][ny]){
                        if(map[nx][ny] == map[cx][cy]){
                            System.out.println("1");
                            System.exit(0);
                        }
                    }
                }
            }
        }
        
    }
    
    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < N && y < M;
    }
}
