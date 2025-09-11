import java.util.*;
import java.io.*;

public class J3040_1 {
    static int[] small = new int[9];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i< 9; i++){
            int size = Integer.parseInt(buffer.readLine());
            small[i] = size;

        }

        inspect(0,0,new int[7]);
    }

    public static void inspect(int start, int idx, int[] tmp){
        if(idx == 7){
            int sum = 0;

            for(int i = 0 ; i < 7 ; i++){
                sum += tmp[i];
            }

            if(sum == 100){
                for(int i = 0 ; i < 7 ; i++){
                    System.out.println(tmp[i]);
                }

            } else return;
            System.exit(0);
        }


        int v = small[start];
        tmp[idx] = v;
        inspect(start+1, idx+1, tmp);
        tmp[idx] = -1;
        inspect(start+1, idx, tmp);

    }
}
