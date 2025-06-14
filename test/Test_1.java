package test;

import java.io.*;
import java.util.*;

public class Test_1 {
    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(t <T){
            String[] input = buffer.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);
            ArrayList<int []>[] arr = new ArrayList[n*n];
            int[] put = new int[n];
            input = buffer.readLine().split(" ");
            for(int i = 0; i < n*n; i++){
                arr[i] = new ArrayList<>();
            }

            for(int i = 0; i< n; i++){
                put[i] = Integer.parseInt(input[i]);
            }
            Arrays.sort(put);
            int index=0;
            for(int i = 0; i <n ;i++){
                for(int j = 0; j<n; j++){
                    int value = put[i];
                    int value2= put[j];
                    arr[index++].add(new int[]{value, value2});
                }
            }
            Arrays.sort(arr, new Comparator<ArrayList<int[]>>() {
                @Override
                public int compare(ArrayList<int[]> o1, ArrayList<int[]> o2) {
                    if(o1.get(0)[0] == o2.get(0)[0]){
                        return o1.get(0)[1] - o2.get(0)[1];
                    }
                    return o1.get(0)[0] - o2.get(0)[0];
                }
            });

            int a = arr[k-1].get(0)[0];
            int b = arr[k-1].get(0)[1];
            System.out.println("#" + (t+1) + " " +(a+b));

            t++;
        }
    }
}
