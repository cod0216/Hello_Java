package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J16236 {
    static int N, MAP[][];
    static int SHARK_SIZE = 2;
    static int X, Y;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        MAP = new int[N][N];

        for (int i = 0; i <N; i++) {
            String[] input = buffer.readLine().split(" ");
            for (int j = 0; j<N; j++) {
                MAP[i][j] = Integer.parseInt(input[j]);

                if(MAP[i][j] == 9){
                    X = i; Y = j;
                }
            }
        }

        while(isFinish()){

            count++;
        }
        System.out.println(count);
    }


    public static boolean isFinish(){
        for (int i = 0; i <N; i++) {
            for (int j = 0; j < N; j++) {
                if(MAP[i][j] != 0 && MAP[i][j] != 9){
                    return true;
                }
            }
        }
        return false;
    }

}
