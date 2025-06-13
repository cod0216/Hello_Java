package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J1114 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        long l = Long.parseLong(input[0]);
        int k = Integer.parseInt(input[1]);
        int c = Integer.parseInt(input[2]);

        int[] cut = new int[k];

        input = buffer.readLine().split(" ");
        for(int i = 0; i < k; i++){
            cut[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(cut);

        long from = 1;
        long to = l;
        long mid = 0;
        long result =0;
        long resultCut =cut[0];
//
//        while(from <= to){
//            mid = (from + to)/2;
//
//            if(cutting != -1){
//                result = mid;
//                resultCut = cutting;
//                to = mid-1;
//            }else{
//                from = mid+1;
//            }
//        }

    }
}
