package TIL;

import java.io.*;
import java.util.*;

class Cell {
    public int x, y;
    int life;
    int time;
    int state;
    int remainig;

    public Cell(int x, int y, int life, int time) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.time = time;
        this.state = 2;
    }
}

public class S5653 {
    static int n, m, k, sizeX, sizeY;
    static int[] dx = new int[]{0,1,0,-1};
    static int[] dy = new int[]{-1, 0,1,0};
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t){
            PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)->b.life-a.life );
            String[] input= buffer.readLine().split(" ");

            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);
            k = Integer.parseInt(input[2]);
            List<Cell> cell = new ArrayList<>();
            sizeX = n + k * 2;
            sizeY = m + k * 2;

            visited = new boolean[sizeX][sizeY];


            for(int i = 0 ; i < n; i++){
                input = buffer.readLine().split(" ");
                for(int j = 0 ; j < m; j++){
                    int life = Integer.parseInt(input[j]);
                    if(life == 0) continue;
                    int x = i + k;
                    int y = j + k;
                    visited[x][y] = true;
                    Cell c = new Cell(x,y,life,life);
                    cell.add(c);
                }
            }

            for(int time = 1; time <= k; time++){
                while(!pq.isEmpty()) {
                    Cell c = pq.poll();
                    int x = c.x;
                    int y = c.y;

                    if(!visited[x][y]) {
                        visited[x][y] = true;
                        cell.add(c);
                    }
                }

                for (int i = 0; i < cell.size(); i++) {
                    if(cell.get(i).state == 0) continue;

                    else if(cell.get(i).state == 2 && cell.get(i).time == time) {
                        cell.get(i).state = 1;
                        cell.get(i).time= time + cell.get(i).life;

                        for (int d = 0; d < 4; d++) {
                            int nx = cell.get(i).x + dx[d], ny = cell.get(i).y + dy[d];
                            pq.add(new Cell(nx,ny,cell.get(i).life,cell.get(i).life+time+1));
                        }
                    } else if(cell.get(i).state == 1 && cell.get(i).time == time) {
                        cell.get(i).state = 0;
                        cell.get(i).time = 0;
                        cell.get(i).life = 0;
                    }
                }
            }

            int cnt = 0;
            for (int i = 0; i < cell.size(); i++) {
                if(cell.get(i).state == 2 || cell.get(i).state == 1) cnt++;
            }
            t++;
            System.out.println("#" + t + " " + cnt);

        }
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < sizeX && y < sizeY;
    }
}