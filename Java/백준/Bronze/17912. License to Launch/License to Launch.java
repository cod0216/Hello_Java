import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(buffer.readLine());
        StringTokenizer st = new StringTokenizer(buffer.readLine());
        
        long minValue = Long.MAX_VALUE;
        int minIndex = 0;
        
        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(st.nextToken());
            
            if (value < minValue) {
                minValue = value;
                minIndex = i;
            }
        }
        
        System.out.println(minIndex);
    }
}
