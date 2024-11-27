package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class J1963 {
    static int ans;
    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t){
            ans = Integer.MAX_VALUE;

            String[] input= buffer.readLine().split(" ");
            makePrise(input[0], input[1], 0);

            System.out.println(ans);
            t++;

        }
    }

    private static void makePrise(String o, String t, int cnt) {
        int[] before = new int[4];
        int[] target = new int[4];


        for(int i = 0 ; i < 4; i++){
            before[i]= o.charAt(i) - '0';
            target[i]= t.charAt(i) - '0';
        }

        for(int z = 1; z <= 9; z++) {
            before[0] = z;
            if(tool(before, t, cnt)){
                return;
            }
            for(int k = 0; k <= 9; k++) {
                before[1] = k;
                if(tool(before, t, cnt)){
                    return;
                }
                for(int e = 0; e <= 9; e++) {
                    before[2] = e;
                    if(tool(before, t, cnt)){
                        return;
                    }
                    for(int x = 0; x <= 9; x++) {
                        before[3] = x;
                        if(tool(before, t, cnt)){
                            return;
                        }
                    }
                }
            }
        }

    }

    public static boolean tool(int[] before, String t, int cnt) {
        StringBuilder modify = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            modify.append(before[i]);
        }
        int after = Integer.parseInt(modify.toString());

        if (isPrime(after)) {
            makePrise(modify.toString(), t, cnt + 1);
        }

        if (after == Integer.parseInt(t)) {
            ans = Math.min(ans, cnt);
            return true;
        }
        return false;
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
