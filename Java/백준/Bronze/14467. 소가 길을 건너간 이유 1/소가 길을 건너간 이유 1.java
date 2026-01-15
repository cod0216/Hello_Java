import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int[] cow = new int[N+1];
        int cnt = 0;
        Arrays.fill(cow, -1);
        for(int i = 0; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            int umm = Integer.parseInt(input[0]);
            int pos = Integer.parseInt(input[1]);

            if(cow[umm] == -1) cow[umm] = pos;
            else {
                if(cow[umm] != pos) {
                    cow[umm] = pos;
                    cnt++;
                }
            }
                
        }
            System.out.println(cnt);
        
    }
}
