package TIL;

import java.util.*;
import java.io.*;

public class S4796 {

    static int cnt;
    static int bottom;
    static int top;
    static int n;
    static int[] mount;
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        int t = 0;
        while(T> t){

            n = scanner.nextInt();
            mount = new int[n];

            for(int i = 0; i < n; i++){
                mount[i] = scanner.nextInt();
            }
            cnt = 0;


            bottom = 0;
            top =0;


            int start = 0;
            int index = 0;
            if(mount[0]<mount[1]){
                start = 0;
            }else findBottom(0);
            start = bottom;
            index = start;

            while(index <n) {
                findTop(index);
                for (int i = start; i < top; i++) {
                    if (i > bottom) cnt++;
                }
                start = bottom;
                findBottom(index);
                if(start == bottom) break;
                index++;
            }



            t++;
            System.out.println("#" + t + " " + cnt);
        }
    }

    public static void findTop(int index){
        if(index == n-1) return;


        if(mount[index] < mount[index+1]){
            findTop(index+1);
        }
        if(mount[index] > mount[index+1]){
            top = index;
        }

    }

    public static void findBottom(int index){
        if(index == n-1) return;
        if(mount[index] > mount[index+1]){
            findBottom(index+1);
        }
        if(mount[index] < mount[index+1]){
            bottom = index;
        }
    }
}
