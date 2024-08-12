package TIL;

import java.io.*;

public class S1953 {
    static int[][] underCity;
    static int maxTime;
    static int cnt;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(buffer.readLine());
        int k = 0 ;
        underCity = new int[50][50];

        String[] input = buffer.readLine().split(" ");
        int indexX = Integer.parseInt(input[0]);
        int indexY = Integer.parseInt(input[1]);
        int capX = Integer.parseInt(input[2]);
        int capY = Integer.parseInt(input[3]);
        maxTime = Integer.parseInt(input[4]);
        cnt = 0;

        while(K > k){
            int cnt = 0;
            for(int i = 0; i < indexX;){
                input = buffer.readLine().split(" ");
                for (int j = 0; j < indexY; j++){
                    underCity[i][j] = Integer.parseInt(input[j]);
                }
            }
            DFS(capX, capY, 0);
            k++;
            System.out.println("#" + k + cnt);
        }

    }
    public static void DFS(int x, int y, int time){
        int value = underCity[x][y];

        if(maxTime == time){
            cnt++;
            return;
        }
        if(value == 0){
            return;
        }
        if(value == 1){

        }else if(value == 2 ){

        }else if(value == 3){

        }else if(value == 4){

        }else if(value == 5){

        }else if(value == 6){

        }else if(value == 7){

        }


    }
}
