package TIL;

import java.util.*;
import java.io.*;


public class S1767 {
    static int[] dx = new int[]{0, 1, 0, -1};
    static int[] dy = new int[]{1, 0, -1, 0};
    static ArrayList<int[]> A;
    static int[][] arr;
    static int elec;
    static int chip;
    static int cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int k=0;
        while(T>k) {
            int n = Integer.parseInt(buffer.readLine());
            A = new ArrayList<>();
            arr = new int[n][n];
            for(int i = 0; i < n; i++) {
                String[] input = buffer.readLine().split(" ");
                for(int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                    if(arr[i][j] == 1 && i != 0 && i <n) {
                        A.add(new int[] {i, j});
                    }
                }
            }
            elec = 12*12;
            chip = 0;
            DFS(0,0,0);
            k++;
            System.out.println("#"+k+ " " + elec);

        }

    }

    public static void DFS(int index, int e, int c) {
        if(A.size() == index) {
            if(chip < c) {
                chip = c;
                elec = e;
            }
            else if(chip == c) {
                if(e < elec) elec = e;
            }
            return;
        }

        for(int i = 0; i<4; i++) {
            int[] dummy = A.get(index);
            if(check(dummy, i)) {
                input(dummy, i, 2);
                DFS(index+1, e+cnt, c+1);
                input(dummy, i, 0);
            }
        }

        DFS(index+1, e, c);


    }

    public static void input(int[] dummy, int i, int value) {
        cnt = 0;
        int nx = dummy[0]+dx[i];
        int ny = dummy[1]+dy[i];
        while(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length ) {
            arr[nx][ny] = value;
            nx +=dx[i];
            ny +=dy[i];
            cnt++;
        }
    }

    public static boolean check(int[] dummy, int i) {
        int nx = dummy[0]+dx[i];
        int ny = dummy[1]+dy[i];

        while(nx >= 0 && ny >= 0 && nx < arr.length && ny < arr.length ) {
            if(arr[nx][ny] != 0) return false;
            nx +=dx[i];
            ny +=dy[i];

        }
        return true;

    }

}

