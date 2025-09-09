package TIL;

import java.io.*;
import java.util.*;

class Shark {
    int id;
    int[] favorites;

    public Shark (int id, int[] favorites){
        this.id = id;
        this.favorites = favorites;
    }
}

public class J21608 {
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());
        int[][] map = new int[n][n];
        int[] dx = new int[]{0,-1,0,1};
        int[] dy = new int[]{1,0,-1,0};
        int totalScore = 0;

        //input
        LinkedList<Shark> list = new LinkedList<>();
        for (int i = 0; i < n*n; i++){
            String[] input = buffer.readLine().split(" ");
            int id = Integer.parseInt(input[0]);
            int f1 = Integer.parseInt(input[1]);
            int f2 = Integer.parseInt(input[2]);
            int f3 = Integer.parseInt(input[3]);
            int f4 = Integer.parseInt(input[4]);

            int[] favorite = new int[]{f1,f2,f3,f4};

            list.add(new Shark(id,favorite));
        }

        // inspect
        for(int s = 0; s < n*n; s++){
            int mX = 0;
            int mY = 0;
            int mFC= -1;
            int mEC= -1;
            for(int i = 0 ; i < n; i++){
                for(int j = 0 ; j < n; j++){
                    int favoriteCnt = 0;
                    int emptyCnt = 0;
                    if(map[i][j] != 0 ) continue;
                    for(int d = 0 ; d < 4; d++){
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if(isIn(nx,ny)) {
                            //empty location
                            if(map[nx][ny] == 0) emptyCnt++;

                            //favorite student
                            for(int f = 0; f < 4; f++){
                                int favorite = list.get(s).favorites[f];
                                if(map[nx][ny] == favorite) favoriteCnt++;
                            }
                        }

                    }

                    if(mFC < favoriteCnt) {
                        mX = i; mY = j; mFC = favoriteCnt; mEC = emptyCnt;
                    } else if(mFC == favoriteCnt ){
                        if(emptyCnt > mEC){
                            mX = i; mY = j; mFC = favoriteCnt; mEC = emptyCnt;
                        } else if(emptyCnt == mEC){
                            if(mX > i ) {
                                mX = i; mY = j; mFC = favoriteCnt; mEC = emptyCnt;
                            }else if (mX == i) {
                                if(mY > j){
                                    mX = i; mY = j; mFC = favoriteCnt; mEC = emptyCnt;
                                }
                            }
                        }
                    }
                }
            }
            map[mX][mY] = list.get(s).id;
        }

        //get score
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                for(int s = 0; s < n*n; s++){
                    Shark shark = list.get(s);
                    int score = 0;
                    if(shark.id == map[i][j]){
                        for(int d = 0; d< 4; d++){
                            int nx = i + dx[d];
                            int ny = j + dy[d];
                            if(isIn(nx,ny)){
                                int[] favorite = shark.favorites;
                                for(int f = 0; f < 4; f++){
                                    if(map[nx][ny]==favorite[f]){
                                        score++;
                                    }
                                }
                            }
                        }
                        totalScore = totalScore + (int)Math.pow(10,score-1);
                    }
                }
            }

        }
        System.out.println(totalScore);
    }

    public static boolean isIn(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}

