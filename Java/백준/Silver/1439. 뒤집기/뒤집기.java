import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split("");
        
        int size = input.length;
        
        int before = Integer.parseInt(input[0]);
        int cnt[] = new int[2];
        ArrayList a = new ArrayList<>();
        a.add(before);
        for(int i = 1 ; i < size; i++){
            int n = Integer.parseInt(input[i]);
            if(before != n){
                a.add(n);
                cnt[before]++;
            }
            before = n;
        }
        cnt[before]++;
        
        System.out.println(Math.min(cnt[0],cnt[1]));
        
    }
}
