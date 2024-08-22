package TIL;

import java.io.*;

public class S2805 {
    static int price;
    static int[][] arr;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t){
            int N = Integer.parseInt(buffer.readLine());


            arr = new int[N][N];

            for(int i = 0; i< N; i++){
                String str = buffer.readLine();
                for(int j = 0; j<N; j++) {
                   arr[i][j] = Integer.parseInt(str.substring(j,j+1));
                }
            }

            price = 0;
            cutter(N);

            t++;
            System.out.println("#" + t + " " + price);

        }
    }

    public static void cutter(int N){
        if(N == 1){
            price += arr[0][0];
            return;
        }
        // 3, 5, 7
        int size = N/2;

        for(int i = 0 ; i<=size; i++){
            price +=arr[size][i];
            up(i,i, size);
            down(i,i, size);
        }

        for(int i = N-1 ; i>N-1-size; i--){
            price +=arr[size][i];
            up(N-1-i, i, size);
            down(N-1-i, i, size);
        }
    }
    public static void up(int up, int index, int size){
        if(up == 0){
            return;
        }
        for(int i = size-1; i>size-1-up; i--){
            price += arr[i][index];
        }
    }

    public static void down(int down, int index, int size){
        if(down == 0){
            return;
        }

        for(int i = size+1; i < size+1+down; i++){
            price += arr[i][index];
        }
    }
}
