package TIL;

import java.io.*;
import java.util.*;

public class J1715 {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int key= Integer.parseInt(buffer.readLine());
        int[] card = new int[key];


        for (int i = 0; i < key; i++) {
            card[i] = Integer.parseInt(buffer.readLine());
        }

        Arrays.sort(card);

        int[] totalBox = new int[key];
        int index = 2;
        int d = 1;
        int total = card[0]+card[1];
        totalBox[0] = total;

        while(index < card.length){
            total += card[index++];
            totalBox[d++] = total;
        }

        int sum = 0;

        for(int i = 0; i < key; i++){
            sum += totalBox[i];
            System.out.println(sum);
        }

        System.out.println();

        for(int i = 0; i < key; i++) {
            System.out.println("card = " + card[i]);
        }

        System.out.println();

        for(int i = 0; i < key; i++){
            System.out.println("totalBox = " + totalBox[i]);
        }

    }
}
