package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class J1125_1 {
    static int N, table[], modify[];
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        table = new int[N];
        modify = new int[N];
        String[] input = buffer.readLine().split("");
        int cnt = 0;
        int fix = 0;
        //origin
        for(int i = 0 ; i < N; i++){
            char c = input[i].charAt(0);
            table[i] = c;
            if(c == 'w') cnt++;
        }
        boolean umm = false;
        input = buffer.readLine().split("");
        //modify
        for(int i = 0 ; i < N; i++){
            char c = input[i].charAt(0);
            modify[i] = c;
            if(c == 'w') fix++;
            if(modify[i] != table[i]) umm = true;
        }

//        System.out.println(Arrays.toString(table));
//        System.out.println(Arrays.toString(modify));


        if(fix > cnt) System.out.println("Manners maketh man");
        else if(fix < cnt) System.out.println("Oryang");
        else{
            if(umm) System.out.println("Its fine");
            else System.out.println("Good");
        }
    }
}
