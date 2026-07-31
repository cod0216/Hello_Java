package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J1011 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T >t){
            String[] input = buffer.readLine().split(" ");
            long a= Long.parseLong(input[0]);
            long b= Long.parseLong(input[1]);
            long sum = b-a;
            long res=find(sum);
            System.out.println(res);
            t++;
        }
    }
    public static long find(long a){
        long res = (long)Math.sqrt(a);
        if(res*res == a){
            return 2*a - 1;
        } else if(a <= res*res+res){
            return 2*res;
        } else return 2*res+1;

    }
}


/*

1: 1

2: 1 1

3: 1 1 1
4: 1 2 1

5: 1 2 1 1
6: 1 2 2 1

7: 1 2 2 1 1
8: 1 2 2 2 1
9: 1 2 3 2 1

10: 1 2 3 2 1 1
11: 1 2 3 2 2 1
12: 1 2 3 3 2 1

13: 1 2 3 3 2 1 1
14: 1 2 3 3 2 2 1
15: 1 2 3 3 3 2 1
16: 1 2 3 4 3 2 1

17: 1 2 3 4 3 2 1 1
18: 1 2 3 4 3 2 2 1
19: 1 2 3 4 3 3 2 1
20: 1 2 3 4 4 3 2 1

21: 1 2 3 4 4 3 2 1 1
22: 1 2 3 4 4 3 2 2 1
23: 1 2 3 4 4 3 3 2 1
24: 1 2 3 4 4 4 3 2 1
25: 1 2 3 4 5 4 3 2 1

 */