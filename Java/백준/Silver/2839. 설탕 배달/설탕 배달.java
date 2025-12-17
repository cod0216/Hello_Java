import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(fuck(Integer.parseInt(buffer.readLine())));
    }
              
    public static int fuck(int n){
        if (n == 4 || n == 7) {
           	return -1;
        }
        else if (n % 5 == 0) {
           	return (n / 5);
        }
        else if (n % 5 == 1 || n % 5 == 3) {
           	return (n / 5) + 1;
        }
        else if (n % 5 == 2 || n % 5 == 4) {
           	return (n / 5) + 2;
        }
        
        return -1;
    }
}
