package TIL;

import java.io.*;
import java.util.*;

public class J12891_5 {
    static int a;
    static int c;
    static int g;
    static int t;
    static int cnt;
    static int[] box;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);


        String str = buffer.readLine();

        char[] arr = str.toCharArray();
        char[] check = new char[k];


        for (int i = 0; i < k; i++) {
            check[i] = arr[i];
        }
        input = buffer.readLine().split(" ");
        box = new int[4];
        for (int i = 0; i < 4; i++) {
            box[i] = Integer.parseInt(input[i]);
        }
        cnt = 0;
        int start = 0;
        int end = k;

        for(int i = 0; i < k; i++){
            checking(arr[i]);
        }
        result();

        while (n > end) {
            deleting(arr[start++]);
            checking(arr[end++]);
            result();
        }
        System.out.println(cnt);
    }

    public static void checking(char p) {
        switch (p) {
            case 'A':
                a++;
                break;
            case 'C':
                c++;
                break;
            case 'G':
                g++;
                break;
            case 'T':
                t++;
                break;
        }
    }

    public static void deleting(char p) {
        switch (p) {
            case 'A':
                a--;
                break;
            case 'C':
                c--;
                break;
            case 'G':
                g--;
                break;
            case 'T':
                t--;
                break;
        }
    }

    static public void result() {
        if (box[0] <= a && box[1] <= c & box[2] <= g & box[3] <= t)
            cnt++;
    }
}
