import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(buffer.readLine());
        
        String[] input = buffer.readLine().split(" ");
        int[] pos = new int[N];
        for(int i = 0; i < N; i++){
            pos[i] = Integer.parseInt(input[i]);
        }
        
        if (N == 1){
            System.out.println("권병장님, 중대장님이 찾으십니다");
            return;
        }

        int[] power = new int[N];
        int max = 0;
        input = buffer.readLine().split(" ");
        for(int i = 0; i < N-1; i++){
            int after = pos[i+1];
            
            power[i] = Integer.parseInt(input[i]);
            max = Math.max(power[i]+pos[i], max);
            
            if(after > max){
                System.out.println("엄마 나 전역 늦어질 것 같아");
                return;
            }

        }

        System.out.println("권병장님, 중대장님이 찾으십니다");
    }
}
