package TIL;


import java.io.*;
import java.util.*;
import java.lang.*;
public class J1929 {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] numArray = new int[m + 1];

        for(int i = 0 ; i <= m; i++){
            numArray[i] = i;
        }
        numArray[1] = 0;
        for(int i = 2; i <= Math.sqrt(m); i++){
            if(numArray[i] == 0){
                continue;
            }
            for(int j = i+i; j<=m; j=j+i){
                numArray[j] = 0;
            }
        }
        for(int i = n; i <= m; i++){
            if(numArray[i] != 0)
            System.out.println(numArray[i]);
        }
    }
}
