import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int bit = 0;
        int t =0;
        StringBuilder sb = new StringBuilder();
        while(N>t){
            String[] input = buffer.readLine().split(" ");
            String keyword = input[0];
            int v = 0;
            if(!keyword.equals("all")  && !keyword.equals("empty")) v = Integer.parseInt(input[1]);
            
            switch(keyword){
                case "add" :
                    bit |= (1<<v);
                    break;
                case "check" :
                    if((bit & (1<<v)) == 0) sb.append(0).append("\n");
                    else sb.append(1).append("\n");
                    break;
                case "remove" :
                    bit &= ~(1<<v);
                    break;
                case "toggle" :
                    bit ^=(1<<v);
                    break;    
                case "all" :
                    bit =(1<<21)-1;
                    break;
                default :
                    bit = 0;
            }
            t++;
        }
        System.out.println(sb.toString());
        
    }
}
