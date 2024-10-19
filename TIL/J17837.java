package TIL;
import java.io.*;
import java.util.*;
/*
    A번 말이 이동하려는 칸이
        흰색인 경우에는 그 칸으로 이동, 이동하려는 칸에 말이 이미 있는 경우 가장 위에 A번 말을 올려 놓는다.
            A번 말의 위에 다른 말이 있는 경우에는 A번 말과 위에 있는 모든 말이 이동

        빨강인 경우
*/
class Horse{
    public int x;
    public int y;
    public int dir;

    public Horse(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }


}
public class J17837 {
    static int n, map[][], k, turn, maxBlock;
    static int[] dx= new int[]{0,0,-1,1};
    static int[] dy= new int[]{1,-1,0,0,};
    static LinkedList<Horse> list;
    static LinkedList<Horse>[][] status;
    static int start;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        map = new int[n][n];
        status = new LinkedList[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                status[i][j] = new LinkedList<>();
            }
        }

        list= new LinkedList<>();

        for(int i = 0 ; i <n; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0 ; j <n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        for(int i = 0; i < k; i++){
            input = buffer.readLine().split(" ");
            int xd = Integer.parseInt(input[0])-1;
            int yd = Integer.parseInt(input[1])-1;
            int dir = Integer.parseInt(input[2])-1;
            list.add(new Horse(xd, yd, dir));
            status[xd][yd].push(list.get(i));
        } // input end

        newGame();
        System.out.println(turn==1001 ? "-1" : turn);
    }

    public static void newGame(){
        while(turn <= 1000){
            if(maxBlock >= 4) break;
            start %= list.size();

            Horse horse= list.get(start);
            int hx = horse.x; int hy = horse.y; int hd = horse.dir;
            int nx = hx + dx[hd]; int ny = hy + dy[hd];

            blockStatus(status[horse.x][horse.y], horse);
            if(!isIn(nx,ny)){
                start++;
                turn++;
                findMax();
                continue;
            }

            start++;
            turn++;
            findMax();
            System.out.println("maxBlock = " + maxBlock);
        } // while end

    }

    private static void blockStatus(LinkedList<Horse> status1, Horse horse) {
        int n = status1.indexOf(horse);
        boolean isRed = false;
        LinkedList<Horse> temp = new LinkedList<>();
        int tx = 0; int ty = 0;
        for(int i = n; i >=0; i--){
            Horse tempHorse = status1.get(i);
            int hx = tempHorse.x; int hy = tempHorse.y; int hd = tempHorse.dir;
            int nx = hx + dx[hd]; int ny = hy + dy[hd];
            if(isIn(nx, ny)){
                int color=getColor(nx, ny);
                if(color == 0) {
                    tempHorse.x = nx;
                    tempHorse.y = ny;
                    status[nx][ny].offerFirst(tempHorse);
                    status1.remove(i);
                } else if(color == 1) {
                    isRed = true;
                    tempHorse.x = nx;
                    tempHorse.y = ny;
                    tx = nx;
                    ty = ny;
                    temp.push(tempHorse);
                    status1.remove(i);
                } else if(color == 2) {
                    tempHorse.x = nx;
                    tempHorse.y = ny;
                    tempHorse.dir=reverse(hd);
                    status[nx][ny].offerFirst(tempHorse);
                    status1.remove(i);

                }
            }else{
                tempHorse.dir=reverse(hd);
            }
        }
        if(isRed) {
            status[tx][ty].offerFirst(temp.pop());
        }

    }

    public static int reverse(int n){
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return 0;
        }
        if(n == 2) {
            return 3;
        }
        if(n == 3) {
            return 2;
        }
        return -1;
    }

    public static void findMax(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                maxBlock = Math.max(maxBlock,status[i][j].size());
            }
        }
    }

    private static int getColor(int x, int y) {
        return map[x][y];
    }

    public static boolean isIn(int x, int y) {
        return x >=0 && y >= 0 && x < n && y < n;
    }

}
