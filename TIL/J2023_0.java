package TIL;

import java.math.*;
import java.util.*;
import java.io.*;

public class J2023_0 {
    static int num;
    public static void main(String[] args)throws IOException {

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input = buffer.readLine();

        num = Integer.parseInt(input);

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);


    }

    public static void DFS(int node, int cnt){
        int n;
        if(cnt == num) {
            System.out.println(node);
        }

        else if(cnt < num){
            node *=10;
            for(int i= 0; i<10; i++){
                n = node+i;
                if(isPrime(n)){
                    DFS(n,cnt+1);
                }
            }
        }
    }

    public static boolean isPrime(int num){
        int Num = (int)Math.sqrt(num);
        for(int i = 2; i <= Num; i++) {
            if (num%i == 0) {
                return false;
            }
        }
        return true;
    }
}
