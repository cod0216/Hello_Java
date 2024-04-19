package lang.math.test;

import java.util.*;
public class LottoGenerator {
    public static void main(String[] args) {
        Random random = new Random();

        int randomNum1 = random.nextInt(45)+1;
        int randomNum2 = random.nextInt(45)+1;
        int randomNum3 = random.nextInt(45)+1;
        int randomNum4 = random.nextInt(45)+1;
        int randomNum5 = random.nextInt(45)+1;
        int randomNum6 = random.nextInt(45)+1;

        while(checkRandom(randomNum1, randomNum2, randomNum3, randomNum4, randomNum5,randomNum6)){
            randomNum1 = random.nextInt(45)+1;
            randomNum2 = random.nextInt(45)+1;
            randomNum3 = random.nextInt(45)+1;
            randomNum4 = random.nextInt(45)+1;
            randomNum5 = random.nextInt(45)+1;
            randomNum6 = random.nextInt(45)+1;
        }


        System.out.println(randomNum1 + " " +randomNum2 + " " +randomNum3 + " " +
                randomNum4 + " " + randomNum5 + " " + randomNum6);
    }

    private static boolean checkRandom(int a, int b, int c, int d, int e, int f){

        if (a == b || a == c || a == d || a == e || a == f)
            return true;
        if (b == c || b == d || b == e || b == f)
            return true;
        if (c == d || c == e || c == f)
            return true;
        if (d == e || d == f)
            return true;
        if (e == f)
            return true;
        return false;
    }
}
