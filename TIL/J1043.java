package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1043 {
    static int n, m, c, know[], s;
    static BufferedReader buffer;

    private static void init() throws IOException {
        buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        s=0;

        input = (buffer.readLine().split(" "));
        if(input.length == 1){
            System.out.println(m);
            System.exit(0);
        }

        c = Integer.parseInt(input[0]);
        know = new int[n+1];

        for(int i = 0; i < c; i++){
            int index = Integer.parseInt(input[i+1]);
            know[index] = -1;
        }
    }

    private static void party() throws IOException {
        for(int i = 0; i< m; i++) {
            boolean flag = false;
            String[] input = buffer.readLine().split(" ");
            c = Integer.parseInt(input[0]);

            for(int j = 1; j <= c; j++){
                int p = Integer.parseInt(input[j]);
                if(know[p] == -1){
                    for(int z = 1; z <= c; z++){
                        know[z] = -1;
                    }
                }
                if(!flag){
                    s++;
                    flag = true;
                }
            }
        }
    }

    public static void main(String[] args)throws IOException {
        init();
        party();
        System.out.println(m-s);
    }
}
