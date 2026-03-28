import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input = buffer.readLine();
        while(!input.equals("#")){
            int cnt = 0;
            int size =input.length();
            for(int i = 0; i < size; i++){
                char c = Character.toUpperCase(input.charAt(i));
                if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') cnt++;
            }
            System.out.println(cnt);
            input = buffer.readLine();
        }
    }
}
