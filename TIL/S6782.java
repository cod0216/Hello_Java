package TIL;

import java.io.*;
import java.util.*;


public class S6782 {
    static long min;
    static long cnt;

    static double[] box;
    static double N;
    static int index;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T>t){

            min = 0;
            N = Double.parseDouble(buffer.readLine());
            cnt = 0;
            index = 1;
            box = new double[40];

            while(N != 2){
                double  n = Math.sqrt(N);
                long a = (long)n;
                if(n == a){
                    N = n;
                    cnt++;
                }
                else {
                    a *= a;
                    double b = Math.sqrt(a);
                    cnt = (long)(b-N)+cnt;
                }
            }




//            up(N); // N+1 하면서 가까운 2의 제곱수 찾기
//            System.out.println(cnt);
//            check(N); // 찾으면 2로 나눠서 2일 때 까지 값 찾기

            t++;
            System.out.println("#" + t + " " + cnt++);
        }
    }
    public static void up(double num) {
        if(num == box[index]){
            N=num;
            return;
        }
        cnt++;
        up(num+1);

    }
    public static void check(double num){
        if(num == 2){
            return;
        }
//        System.out.println("num : " + num);
        cnt++;

        check(num/2);
    }
}


/*

4
2
3
4
99
 */
//