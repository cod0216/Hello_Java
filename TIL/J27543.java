package TIL;

import java.io.IOException;
import java.util.Scanner;

public class J27543 {
    public static void main(String[] args) throws IOException {
        try{
            Scanner scanner = new Scanner(System.in);
            int T = scanner.nextInt();
            int t = 0;

            while(T>t){
                int n = scanner.nextInt();
                int dummy = scanner.nextInt();

                if (n == 1){
                    System.out.println(-1);
                    t++;
                    continue;
                } //exception

                if (n %2 ==0) System.out.println(1);
                else if (n % 2 ==1) System.out.println(0);
                t++;
            }
        }catch (Exception e){
            return;
        }

    }
}
