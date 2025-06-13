package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1790 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int key = Integer.parseInt(input[1]);
        int cnt = 0;

        for(int i = 1; i <=n; i++){
            if(cnt >= key) break;
            sb.append(i);
            cnt +=i/10+1;
        }

        if(cnt < key){
            System.out.println("-1");
            return;
        }
        System.out.println(sb.charAt(key-1));
    }
}
