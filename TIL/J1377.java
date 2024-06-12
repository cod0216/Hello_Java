package TIL;

import java.io.*;
import java.util.*;

public class J1377 {
    static LinkedList<int[]>[] A;
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int index = Integer.parseInt(buffer.readLine());
        A = new LinkedList[index];

        for(int i = 0; i< index; i++){
            A[i] = new LinkedList<>();
        }

        for(int i = 0; i<index; i++){
            int num = Integer.parseInt(buffer.readLine());
            A[i].add(new int[]{num, i});
        }

//        Collections.sort(A, Comparator.comparingInt(a -> a.get(0)[0]));

        Arrays.sort(A, Comparator.comparingInt(a -> a.get(0)[0]));


        for(int i = 0; i<index; i++){
            int[] a =A[i].get(0);
            int result = a[1] - i;
            if( max < result)
                max = result;
        }
        System.out.println(max+1);
    }
}
