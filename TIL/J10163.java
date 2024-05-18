package TIL;

import java.io.*;

public class J10163{
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int n= Integer.parseInt(buffer.readLine());
        int[][] arr = new int[1001][1001];
        int[] cnt = new int[n+1];


        for(int i = 1; i<=n; i++){
            String[] input = buffer.readLine().split(" ");

            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);
            int h = Integer.parseInt(input[3]);
            y =1001-y-1;
            h = y-h;
            w = x+w;

            for(int j = y; j>h; j--){
                for(int k = x; k<w; k++){
                    arr[j][k] = i;
                }
            }
        }
        int num = 1;
        for(int i = 1; i<n+1; i++) {
            for (int j = 0; j < 1001; j++) {
                for (int k = 0; k < 1001; k++) {
                    if (arr[j][k] == i)
                        cnt[i]++;
                }
            }
            System.out.println(cnt[i]);
        }





    }

}
