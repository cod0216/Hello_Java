import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String a = buffer.readLine();
        long ans = 0;
        for(int i = 0; i < a.length(); i++){
            ans = (ans * 10 + (a.charAt(i) - '0')) % 20000303;
        }
        System.out.print(ans);
    }
}