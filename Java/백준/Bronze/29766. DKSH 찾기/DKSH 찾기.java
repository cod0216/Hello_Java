import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input = buffer.readLine();
        int size = input.length();
        int cnt = 0;
        for(int i = 0 ; i < size-3; i++){
            if(input.charAt(i) == 'D' && input.charAt(i+1) == 'K' && input.charAt(i+2) == 'S' && input.charAt(i+3) == 'H')cnt++;
        }
        System.out.println(cnt);
    }
}
