package TIL;
import java.io.*;

public class J11660 {
    static int N, M;
    static int[][] box, sumBox;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        box = new int[N+1][N+1];
        sumBox = new int[N+1][N+1];

        for(int i = 1; i<= N; i++){
            input = buffer.readLine().split(" ");
            for(int j = 1; j<= N; j++){
                box[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        for(int i = 1; i<= N; i++){
            for(int j = 1; j<= N; j++){
                sumBox[i][j] = box[i][j]
                        + sumBox[i-1][j] + sumBox[i][j-1] - sumBox[i-1][j-1];
            }
        }

        for(int i = 0; i< M; i++){
            input = buffer.readLine().split(" ");
            int x1 = Integer.parseInt(input[0]);
            int y1 = Integer.parseInt(input[1]);
            int x2 = Integer.parseInt(input[2]);
            int y2 = Integer.parseInt(input[3]);

            int ans = sumBox[x2][y2] - sumBox[x1-1][y2]
                    - sumBox[x2][y1-1] + sumBox[x1-1][y1-1];
            System.out.println(ans);
        }
    }
}
