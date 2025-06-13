package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J28128 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        boolean mobis = false;
        boolean hyundai = false;


        for(int i = 0 ; i < x; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j< y; j++){
                if(input[j].equals("mobis")) mobis = true;
                else if(input[j].equals("hyundai")) hyundai = true;

            }
        }

        if(!hyundai && !mobis){
            System.out.println("MANIPULATED");
            return;
        }


        if(hyundai) System.out.println("hyundai");
        if(mobis) System.out.println("mobis");

    }
}
