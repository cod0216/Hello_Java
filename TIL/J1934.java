package TIL;
import java.io.*;

public class J1934 {
    static int min;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for(int i = 0; i < n; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            gcd(A,B);
            int minA = A/min;
            int minB = B/min;
            System.out.println((minA * minB) * min);
        }


    }
    public static void gcd(int num1, int num2){
        if(num1 < num2){
            int temp = num1;
            num1 = num2;
            num2 = temp;
        }
        if(num1%num2 == 0){
            min =  num2;
            return;
        }
        gcd(num2, num1%num2);

    }
}
