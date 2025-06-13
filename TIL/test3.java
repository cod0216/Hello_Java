package TIL;

import access.b.AccessOuterMain;

public class test3 {
    public static void main(String[] args) {

        int n = 0;
        for (int i = 0; i < 500; i++) {
            long startTime = System.nanoTime();
            for (int j = 0; j < 1000; j++) {
                n++;
            }
            long endTime = System.nanoTime();
            System.out.println(i+"\t"+ (endTime - startTime));
        }
    }
}
