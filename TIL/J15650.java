package TIL;

import java.io.*;

public class J15650 {
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        dfs(0, new boolean[n], 0);
    }

    public static void dfs(int target, boolean[] isSelected, int idx) {
        if(idx==m){
            for(int i = 0; i < n; i++){
                if(isSelected[i]) System.out.print(i+1 + " ");
            }
            System.out.println();
            return;
        }

        for(int i = target ; i< n; i++){
            isSelected[i] = true;
            dfs(i+1, isSelected, idx+1);
            isSelected[i] = false;
        }
    }
}
