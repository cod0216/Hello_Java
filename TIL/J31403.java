package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J31403 {
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(buffer.readLine());
        int b = Integer.parseInt(buffer.readLine());
        int c = Integer.parseInt(buffer.readLine());

        System.out.println(a+b-c);
        StringBuilder res = new StringBuilder();
        res.append(a).append(b);
        int n=Integer.parseInt(res.toString());
        System.out.println(n-c);
    }
}
