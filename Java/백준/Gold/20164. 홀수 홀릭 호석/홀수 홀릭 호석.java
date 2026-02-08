import java.util.*;
import java.io.*;

public class Main {
    static int MIN = Integer.MAX_VALUE, MAX = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        cut(N,cntOdd(N));
        System.out.println(MIN + " " + MAX);

    }
    public static void cut(int n, int total){
        if(n < 10){
            MIN = Math.min(MIN, total);
            MAX = Math.max(MAX, total);
        } else if(n < 100){
            int sum = (n/10) + (n%10);
            cut(sum, total + cntOdd(sum));
        } else {
            String str = Integer.toString(n);
            int len = str.length();
            for(int i = 0 ; i <= len-3; i++){
                for(int j = i+1; j <= len-2; j++){                
                    String s1 = str.substring(0, i+1);
                    String s2 = str.substring(i+1, j+1);
                    String s3 = str.substring(j+1, len);
                    
                    int sum = Integer.parseInt(s1) + Integer.parseInt(s2) + Integer.parseInt(s3);
                    cut(sum, total+cntOdd(sum));
                }
            }
        }
    }
    
    public static int cntOdd(int n){
        int cnt = 0;
        while(n>0){
            int cur = n%10;
            if(cur %2 == 1) cnt++;
            n /=10;
        }
        return cnt;
    }
}
