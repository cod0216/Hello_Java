package TIL;

import java.io.*;
import java.util.*;

public class S16546 {

    static int[] cnt;
    static int[] arr;



    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while(T > t) {

            int tNum = 0;
            int rNum = 0;

            boolean key= false;
            boolean triple = false;
            boolean run = false;

            String str = buffer.readLine();
            char[] num = str.toCharArray();

            cnt = new int[10];
            arr = new int[10];

            for (int i = 0; i < 6; i++) {
                arr[i] = num[i] - '0';
                cnt[arr[i]] += 1;
            }

            t++;
            for (int i = 0; i < 10; i++) {
                if (cnt[i] >= 6) {
                    System.out.println("#" + t + " " + true);
                    key = true;
                    break;
                }
                if (cnt[i] >= 3) {
                    if (triple) {
                        System.out.println("#" + t + " " + true);
                        key = true;
                        break;
                    }
                    triple = true;
                    cnt[i] -= 3;
                }

            }
            if(!key) {
                for (int i = 0; i < 5; i++) {
                    if (cnt[i] == 2) {
                        if (cnt[i + 1] == 2) {
                            if (cnt[i + 2] == 2) {
                                System.out.println("#" + t + " " + true);
                                key = true;
                                break;
                            }
                        }
                    }
                    if(!key) {
                        if (cnt[i] == 1) {
                            if (cnt[i + 1] == 1) {
                                if (cnt[i + 2] == 1) {
                                    run = true;
                                    if (cnt[i + 3] == 1) {
                                        if (cnt[i + 4] == 1) {
                                            if (cnt[i + 5] == 1) {
                                                System.out.println("#" + t + " " + true);
                                                key = true;
                                                break;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if(!key) {
                if (run && triple) System.out.println("#" + t + " " + true);

                else System.out.println("#" + t + " " + false);
            }
        }
    }
}
