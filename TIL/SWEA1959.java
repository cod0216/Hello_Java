package TIL;


import java.util.*;
import java.io.*;

public class SWEA1959 {
    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int cnt = 0;
        while(cnt < T) {
            String[] input = buffer.readLine().split(" ");

            int num1 = Integer.parseInt(input[0]);
            int num2 = Integer.parseInt(input[1]);



            int[] arr1 = new int[num1];
            int[] arr2 = new int[num2];

            input = buffer.readLine().split(" ");
            for (int i = 0; i < num1; i++) {
                arr1[i] = Integer.parseInt(input[i]);
            }

            input = buffer.readLine().split(" ");
            for (int i = 0; i < num2; i++) {
                arr2[i] = Integer.parseInt(input[i]);
            }
            int n1 = num1;
            int n2 = num2;

            if(num1 > num2){
                int[] tmp = arr1;
                arr1 = arr2;
                arr2 = tmp;
                int temp = n1;
                n1 = n2;
                n2 = temp;
            }

            int start = 0;
            int end = start + n1 - 1;
            int max = 0;

            while (end < n2) {
                int sum = 0;
                for (int i = 0; i < n1; i++) {
                    sum += arr1[i] * arr2[start + i];
                }
                max = Math.max(max, sum);

                start++;
                end++;
            }
            System.out.println("#" + (cnt + 1) + " " + max);
            cnt++;
        }
    }
}
