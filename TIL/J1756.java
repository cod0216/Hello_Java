package TIL;

import java.io.*;
import java.util.*;


/*
N개의 피자 반죽을 오븐에 넣고 구우려고 한다.
그런데 노답피자에서 만드는 피자 반죽은 지름이 제각각이다.

===========================================

D : 오븐 깊이
N : 피자 반죽 개수

1 <= D, N <= 300,000

둘쨰 줄에는 오픈의 최상단부터 시작하여 깊이만큼 오븐의 지름이 차례대로 주어진다.

세번째는 피자 반죽이 완성되는 순서대로, 그 각각의 지름이 주어진다.

[출력]
첫째 줄에, 마지막 피자 반죽의 위치를 출력

오븐 최상단 1 마지막 깊이 D
피자가 오븐에 들어가지 않는다면 0 출력


 피자 반죽의 지름은 10억 이하의 자연수


 */
public class J1756 {
    static long[] oven;
    static long[] dough;
    static long endMemory;
    static boolean sameDough = true;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");

        long D = Long.parseLong(input[0]);
        long N = Long.parseLong(input[1]);

        input = buffer.readLine().split(" ");
        oven = new long[(int)D];
        for (int i = 0; i < D; i++) {
            oven[i] = Integer.parseInt(input[i]);
        }

        input = buffer.readLine().split(" ");
        dough = new long[(int)N];
        for (int i = 0; i < N; i++) {
            dough[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < D - 1; i++) {
            if (oven[i] < oven[i + 1]){
                oven[i + 1] = oven[i];
                sameDough = false;
            }

        }
        for(int i = 0; i < N; i ++) {
            if (dough[i] > oven[0]){
                System.out.println(0);
                System.exit(0);

            }
        }

/*
            3
            4   -> 3
            3
            6   -? 3

            깊어질수록 갚은 작아지게 될 예정
 */
        endMemory = D;
        long start = 0;
        long end = endMemory;
        long middle = start+end/2;

        for (int i = 0; i < N; i++) {
            start = 0;
            end = endMemory;
            long key = dough[i];
            if( i ==0 && key <= dough[(int)N-1]){
                if(sameDough){
                    endMemory -=1;
                    continue;
                }
            }

            while (start <= end) {
                middle = (start + end) / 2;
                if (key < oven[(int)middle])
                    start = middle+1;
                else if (key > oven[(int)middle])
                    end = middle-1;
                else break;
            }

            endMemory = findEnd(middle);
            System.out.println("middle: " + middle + " endMemory : " + endMemory);

        }
        System.out.println(endMemory+1);
    }
    private static long findEnd(long value) {
        for(long i = value; i< endMemory-1; i++ ){
            if(oven[(int)i] != oven[(int)i+1]){
                return i;
            }
        }
        return endMemory-1;


    }
}
