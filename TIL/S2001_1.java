package TIL;
import java.io.*;

public class S2001_1 {
    static int[][] map, sumMap;
    static int n, m, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0 ;
        while(T > t){
            String[] input = buffer.readLine().split(" ");
            ans = 0;
            n = Integer.parseInt(input[0]);
            m = Integer.parseInt(input[1]);

            map = new int[n+1][n+1];
            sumMap = new int[n+1][n+1];

            for(int i = 1 ; i<= n; i++){
                input = buffer.readLine().split(" ");
                for(int j = 1 ; j <= n; j++){
                    map[i][j] = Integer.parseInt(input[j-1]);
                }
            }

            for (int i = 1; i <= n ; i++) {
                for (int j = 1; j <= n ; j++) {
                    sumMap[i][j] = map[i][j] + sumMap[i][j-1] + sumMap[i-1][j] - sumMap[i-1][j-1];
                }
            }

            for (int i = m; i <= n ; i++) {
                for (int j = m; j <= n ; j++) {
                    ans = Math.max(ans,sumMap[i][j] - sumMap[i][j-m] - sumMap[i-m][j] + sumMap[i-m][j-m]);
                }
            }

            t++;
            System.out.println("#" + t + " " + ans);
        }
    }
}

