package TIL;

import java.io.*;
import java.util.*;

public class S1218_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;
        int t = 0;

        while(T > t){
            int ans = 1;
            int n = Integer.parseInt(buffer.readLine());
            String[] str = buffer.readLine().split("");
            LinkedList<Character> box = new LinkedList<>();
            for(int i = 0; i < n; i++){
                char value = str[i].toCharArray()[0];
                if(entWord(value)) box.push(value);
                else{
                    char c = box.pop();
                    if(inspect(c)!=value) {
                        ans = 0;
                        break;
                    }
                }
            }

            t++;
            System.out.println("#" + t + " " + ans);
        }
    }

    public static char inspect(char value) {
        if (value == '[') return ']';
        else if (value == '{') return '}';
        else if (value == '(') return ')';

        return '>';
    }

    public static boolean entWord(char value) {
        if(value == '{' || value == '[' || value == '(' || value == '<') return true;
        else return false;
    }
}
