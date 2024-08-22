package TIL;

import java.io.*;

public class J3040 {
    static int[] hat;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        hat = new int[9];

        for(int i = 0; i < 9; i++){
            hat[i] = Integer.parseInt(buffer.readLine());
        }
        int n = 9;
        combination(0, 0, 0, new int[7]);
    }
    public static void combination(int start, int index, int sum, int[] bucket){
        if(sum > 100 || index > 7){
            return;
        }

        if(index == 7){
            if(sum == 100) {
                for (int i = 0; i < 7; i++) {
                    System.out.println(bucket[i]);
                }
            }
            return;
        }

        for(int i = start; i < 9; i++){
            bucket[index] = hat[i];
            combination(i+1, i+1, sum+hat[i], bucket);
        }
    }
}
