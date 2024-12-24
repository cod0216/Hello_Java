package TIL;

import java.io.*;

public class J2023_5 {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(buffer.readLine());

        dfs(2,1);
        dfs(3,1);
        dfs(5,1);
        dfs(7,1);

    }

    public static void dfs(int num, int cnt){
        if(cnt == n){
            System.out.println(num);
            return;
        }

        for(int i = 0; i < 10; i++){
            int v = num*10+i;
            if(isPrime(v)) dfs(v,cnt+1);
        }
    }

    public static boolean isPrime(int p){
        for(int i = 2; i<=Math.sqrt(p); i++){
            if(p%i ==0) return false;
        }
        return true;
    }
}
