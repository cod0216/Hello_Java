package TIL;

import java.util.*;
import java.io.*;
class SS1952
{
    static int[] price;
    static int min;
    static int[] plan;

    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;


        while(T>t) {
            String[] input= buffer.readLine().split(" ");

            price = new int[4];
            for(int i = 0 ; i < 4; i++) {
                price[i] = Integer.parseInt(input[i]);
            }

            input= buffer.readLine().split(" ");

            plan = new int[12];
            for(int i = 0 ; i < 12;i++) {
                plan[i] = Integer.parseInt(input[i]);
            }

            min = price[3];
            signUp(0, 0);

            t++;
            System.out.println("#" + t + " " + min);
        }
    }

    public static void signUp (int month, int totalPrice) {
        if(month >= 12) {
            min = Math.min(min, totalPrice);
            return;
        }

        signUp(month+1, price[0]*plan[month]+totalPrice);
        signUp(month+1, price[1]+totalPrice);
        if(month <10) signUp(month+3, price[2]+totalPrice);
    }
}
