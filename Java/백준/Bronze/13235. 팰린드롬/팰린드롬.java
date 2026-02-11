import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split("");
        
        int size = input.length;
        
        for(int i = 0 ; i < size/2; i++){
            char a = input[i].charAt(0);            
            char b = input[size-1-i].charAt(0);
            if(a != b){
                System.out.println("false");
                return;
            }
        }
        
        System.out.println("true");        
        
    }
}
