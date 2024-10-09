package TIL;

import java.io.*;
import java.util.*;

/*
2차원 세계에 블록 쌓여있음 비오면 고임
고여있는 빗물의 총량 얼마인가
 */
public class J14719 {
    static int h, w, ans, map[][], max;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        h = Integer.parseInt(input[0]);
        w = Integer.parseInt(input[1]);

        input = buffer.readLine().split(" ");
        for(int i = 0 ; i < h; i++){
            int height = Integer.parseInt(input[i]);
            for(int j = 0; j < height; j++) {
                map[i][j] = 1;
            }
            max = Math.max(max,height);
        }
        if(input.length <1){
            System.out.println(0);
            return ;
        }
    } // main end

    public static void rain(){
        for(int i = 0 ; i <= max; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] == 0) {
                    ans += 1;
                }
            }
        } // outer for end
    }
}
