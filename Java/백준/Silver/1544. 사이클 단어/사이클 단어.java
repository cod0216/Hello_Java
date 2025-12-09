import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int n = 0;
        int cnt = 0;
        String[] box = new String[N];
        while(n < N){
            String s = buffer.readLine();
            boolean good = false;
            String str = s+s;
            for(int i = 0; i < cnt; i++){
                if(box[i].length() != s.length()) continue;
                if((box[i]+box[i]).contains(s)) {
                    good=true;
                    break;
                }
                
            }
            if(!good){
                box[cnt++] = s;
            }
            n++;
        }
        System.out.println(cnt);
    }
}
