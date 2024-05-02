package TIL.review;

import java.util.*;
import java.io.*;

public class J1931 {

    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int index = Integer.parseInt(buffer.readLine());
        int[][] room = new int[index][2];

        for(int i = 0; i< index; i++){
            String[] input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            room[i][0] = start;
            room[i][1] = end;
        }

        Arrays.sort(room, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[1] == b[1]) return a[0] - b[0];
                return a[1]-b[1];
            }
        });
        int cnt=0;
        int end = -1;
        for(int i = 0; i < index; i++){
            if( room[i][0]>=end){
                end = room[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
