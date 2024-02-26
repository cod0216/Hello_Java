package TIL;

import java.util.*;
import java.lang.*;
public class J11726 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long[] D = new long[N+2];

        D[1] = 1;
        D[2] = 2;

        for(int i = 3; i <= N; i++){
            D[i] = (D[i-1]+D[i-2])%10007;
        }
        System.out.println(D[N]);
    }
}
