package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class J12015 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(buffer.readLine());

        int[] num = new int[n];
        String[] input = buffer.readLine().split(" ");

        num[0] = Integer.parseInt(input[0]);
        int size = 1;

        for(int i = 1 ; i < n ; i++){
            int l = Integer.parseInt(input[i]);
            if(num[size-1] < l){
                num[size++] = l;
            }else{
                int from = 0;
                int to = size;
                int mid = 0;
                while(from < to){
                    mid = (from+to)/2;
                    if(num[mid] <l){
                        from = mid+1;
                    }else{
                        to = mid;
                    }
                }
                num[to] = l;
            }
        }

        System.out.println(size);
    }
}
