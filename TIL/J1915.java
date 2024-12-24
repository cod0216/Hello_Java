package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1915 {
    static int r, c, map[][], dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        r = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);
        map = new int[r][c];
        int max = 0;

        for (int i = 0; i < r; i++) {
            input = buffer.readLine().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == 1 && isIn(i,j)) map[i][j] =  Math.min(map[i-1][j-1], Math.min(map[i][j-1], map[i-1][j])) +1;
                if(max < map[i][j]) max = map[i][j];
            }
        }
        System.out.println(max*max);
    }
    public static boolean isIn(int x, int y){
        return x >0 && y >0 && x < r && y <c;
    }
}


//dp 에서는 앞에걸 모두 해결했다는 가정
/*
D[i][j] = Min(D[i-1][j-1], D[i][j-1],D[i-1][j]) +1 // 현재 자리의 원래 값이 1
D[i][j] = 0 // 현재 잘의 원래 값이 1


 */