package TIL;

import java.io.*;

public class J1365 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(buffer.readLine());
        int[] num = new int[n];

        String[] input = buffer.readLine().split(" ");

        num[0] = Integer.parseInt(input[0]);
        int idx = 1;

        for(int i = 1 ; i<n; i++){
            int l = Integer.parseInt(input[i]);
            if(num[idx-1] < l) num[idx++] = l;
            else{
                int from = 0;
                int to = idx;
                int mid = 0;
                while(from < to){
                    mid = (from + to)/2;
                    if(num[mid]<l ){
                        from = mid +1;
                    }else{
                        to = mid;
                    }
                }
                num[to] = l;
            }
        }

        System.out.println(n-idx);
    }
}