import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        int N = Integer.parseInt(buffer.readLine());
        for(int i = 0 ; i< N; i++){
            String input = buffer.readLine();
            set.add(input);
        }
        int T = set.size();
        ArrayList<String> list = new ArrayList<>(set);
        
        Collections.sort(list, (a, b) -> {
            int s1 = a.length();
            int s2 = b.length();
            if (s1 == s2) return a.compareTo(b);
            return s1 - s2;
        });
        
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s).append('\n');
        }
        System.out.print(sb);
    }
}
