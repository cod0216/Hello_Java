package TIL;

import java.util.*;

public class J2023 {
    static int count;
    public static void main(String[] args){
     Scanner scanner = new Scanner(System.in);

     int n = scanner.nextInt();
     count = n;

     DFS(2, 1);
     DFS(3, 1);
     DFS(5, 1);
     DFS(7, 1);

    }
    public static void DFS(int num, int cnt){
     //만약 소수라면
         if(cnt == count) {
             System.out.println(num);
             return;
         }
         cnt +=1;
        for(int i = 0; i < 10; i++) {
            int value = num * 10 + i;
                if (isPrime(value))
                    DFS(value, cnt);

        }

    }
    public static boolean isPrime(int num){
        for(int i = 2; i<=Math.sqrt(num); i++){
            if(num % i == 0)
                return false;
        }
        return true;

    }
}