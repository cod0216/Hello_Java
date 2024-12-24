package TIL;

import java.io.*;

public class J30455 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(buffer.readLine());
        if (n%2 ==0) System.out.println("Duck");
        else System.out.println("Goose");
    }
}
