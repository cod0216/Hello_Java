import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T > t){
            String[] input = buffer.readLine().split(" ");
            int cnt = 0;
            long power = Long.parseLong(input[0]);
            long feed = Long.parseLong(input[1]);            
            
            while(power > 0){
                power = power/2;
                cnt++;
            }
            
            System.out.println(feed+cnt);
            t++;
        }

    }
}
