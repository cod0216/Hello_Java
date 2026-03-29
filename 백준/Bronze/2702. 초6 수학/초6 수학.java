import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        for(int i = 0 ; i < N; i++){
            int max = 0;
            int min = 0;
            String[] input = buffer.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            max = gcd(a,b);
            min = lcm(a,b);
            System.out.println(min + " " + max);
        }
    }
    public static int gcd(int a, int b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b){
        return a * b / gcd(a,b);
    }
}