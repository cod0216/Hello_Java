package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J10159 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(buffer.readLine());
        int m = Integer.parseInt(buffer.readLine());

        boolean arr[][] = new boolean[n+1][n+1];
            for(int j = 0; j<m; j++){
               String[] input = buffer.readLine().split(" ");
               int a = Integer.parseInt(input[0]);
               int b = Integer.parseInt(input[1]);

               arr[a][b] = true;
            }

        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(arr[i][k] && arr[k][j])
                        arr[i][j] = true;
                }
            }
        }

        int cnt =0;
        for(int i =1; i<=n; i++){
            cnt = 0;
            for(int j =1; j<=n; j++){
                if (i != j && (arr[i][j] || arr[j][i])) {
                    cnt++;
                }
            }
            System.out.println(n-1-cnt);
        }
    }
}