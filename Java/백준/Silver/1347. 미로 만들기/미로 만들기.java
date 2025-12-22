import java.util.*;
import java.io.*;

public class Main {
    static int N, map[][], dir;
    static int[] dx = new int[]{1,0,-1,0}; // 남 서 북 동
    static int[] dy = new int[]{0,-1,0,1};
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        map = new int[101][101];
        dir = 0;
        int x = 50; int y = 50;
        int minX= 50; int minY= 50; int maxX= 50; int maxY= 50;
        map[x][y] = 1;
        String[] input = buffer.readLine().split("");
        for(int i = 0 ; i < N; i++){
            char c = input[i].charAt(0);
            if(c == 'R') turn(1);
            else if(c == 'L') turn(-1);
            else {
                x = x + dx[dir]; y = y + dy[dir];
                
                maxX = Math.max(maxX, x);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                minY = Math.min(minY, y);
                map[x][y] = 1;
            }
        }
        
        for(int i = minX; i <= maxX; i++){
            for(int j = minY; j <= maxY; j++){
                if(map[i][j] == 1) System.out.print('.');
                else System.out.print('#');
            }
            System.out.println();
        }
    }
    
    public static void turn(int v){
        dir = (dir + v)%4;
        if(dir <0) dir=3;
    }
}
