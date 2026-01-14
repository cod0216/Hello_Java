import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");
        boolean[] num = new boolean[1001];
        num[1] = true;
        for(int i = 2 ; i < 1001; i++){
            int cnt = 2;
            int n = i*cnt;
            if(num[i]) continue;
            while(n <1001){
                cnt++;
                num[n] = true;
                n = i*cnt;
            }
        }
        int cnt = 0;
        for(int i = 0; i < N; i++){
            int v = Integer.parseInt(input[i]);
            if(!num[v]) cnt++;
        }
        System.out.println(cnt);

    }
}
