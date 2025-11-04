import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String EXIT = "what does the fox say?";
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while(T > t){
            String[] text = buffer.readLine().split(" ");
            LinkedList<String> str = new LinkedList<>();

            
            for(String a : text){
                str.add(a);
            }
            boolean[] check = new boolean[str.size()];            
            String s;
            while(!EXIT.equals(s = buffer.readLine())){
               String keyword = s.split(" ")[2];
                int idx = 0;
                for(String a : str){
                    if(a.equals(keyword)) check[idx] = true;
                    idx++;
                }
            }
            for(int i = 0 ; i < str.size(); i++){
                if(check[i])continue;
                System.out.print(str.get(i) + " ");
            }
            System.out.println();
            t++;
        }
    }
}
