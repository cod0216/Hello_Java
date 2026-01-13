import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        int n = 0;
        
        
        while(T > t){
            String[] input = buffer.readLine().split(" ");
            String fun = input[0];
            int num = 0;
            if(!fun.equals("all") && !fun.equals("empty")) num = Integer.parseInt(input[1]);
            switch(fun){
                case "add" :
                    n |= 1<<(num-1);
                    break;
                case "remove" :
                    num = ~(1<<(num-1));
                    n &= num;
                    break;    
                case "check" :
                    if((n & (1<<(num-1))) != 0) sb.append("1");
                    else sb.append("0");
                    sb.append("\n");
                    break;
                case "all" :
                    n = (1<<20) -1;
                    break;
                case "toggle" :
                    n ^= (1<<num-1);
                    break;
                default :
                    n = 0;    
                    break;
            }
            
            t++;
        }
        System.out.println(sb.toString());
        
    }
}
