import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int ans = 0;
        while(T --> 0){
            String[] input = buffer.readLine().split("");
            int idx = input.length;
            LinkedList<Integer> list = new LinkedList<>();
            
            for(int i = 0; i < idx; i++){
                char v = input[i].charAt(0);
                if(list.isEmpty()){
                    if(v == 'A') list.push(1);
                    else list.push(2);
                }else {
                    if(v == 'A'){
                        if(1 != list.peek()) list.push(1);
                        else list.pop();
                    } else {
                        if(2 != list.peek()) list.push(2);
                        else list.pop();
                    } 
                }

            }
            if(list.isEmpty()) ans++;
        }
        System.out.println(ans);
    }
}
