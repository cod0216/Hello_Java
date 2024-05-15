package TIL;

import java.util.*;
import java.io.*;

public class J11657 {
    static ArrayList<int[]>[] list;

    static int N;
    static int M;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        list = new ArrayList[M];
        long[] array = new long[N];
        long[] array2 = new long[N];

        for(int i = 0; i<N; i++){
            array[i] = 9999999;
            array2[i] = 9999999;
        }
        array[0] = 0;
        array2[0] = 0;
        for(int i = 0; i<M; i++){
            list[i] = new ArrayList<>();
            input = buffer.readLine().split(" ");

            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);
            list[i].add(new int[]{A,B,C});
        }

        for(int i = 0; i<N-1;i++){
            array=bell(array);
        }
        for(int i = 0; i<N;i++) {
            array2 = bell(array2);
        }

        for(int i =1; i < N;i++) {
            if (array[i] != array2[i]) {
                System.out.println(-1);
                return;
            }
        }
        for(int i =1; i < N;i++){
            if(array[i] == 9999999) System.out.println(-1);
            else System.out.println(array[i]);
        }
    }

    public static long[] bell(long[] array){
        for(int i = 0; i<M; i++){
            int[] node = list[i].get(0);
            int start = node[0]-1;

            if(array[start] == 9999999) continue; //?? 왜??

            int end = node[1]-1;
            int weight = node[2];

            array[end] = Math.min(array[end], array[start]+weight);


        }
        return array;

    }
}
