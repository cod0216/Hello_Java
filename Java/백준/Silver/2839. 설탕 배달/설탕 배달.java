import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int cnt = 0;
        while(N>0){
            if(N % 5 == 0){
                cnt += N/5;
                break;
            }
            cnt++;
            N -= 3;
        }
        System.out.println(N < 0 ? -1 : cnt);
    }
}
