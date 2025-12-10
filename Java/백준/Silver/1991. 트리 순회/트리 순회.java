import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());

        list = new LinkedList[27];
        for(int i = 0 ; i <= 26; i++){
            list[i] = new LinkedList<>();
        }
        
        for(int i = 0 ; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            int a = input[0].charAt(0) -'A';
            
            if(input[1].charAt(0) != '.'){
                list[a].add((int)input[1].charAt(0) -'A');
            }else {
                list[a].add(-1);
            }
            
            if(input[2].charAt(0) != '.'){
                list[a].add((int)input[2].charAt(0) -'A');
            }else {
                list[a].add(-1);
            }
        }
        preOrder(0);
        System.out.println();
        inOrder(0);
        System.out.println();
        postOrder(0);
    }
    
    public static void preOrder(int n){
        System.out.print((char)(n + 'A'));
        for(int c : list[n]){
            if(c == -1) continue;
            preOrder(c);            
        }
    }
    
    public static void inOrder(int n){
        if(list[n].size() > 0){
            if(list[n].get(0) != -1) inOrder(list[n].get(0));
        }
        
        System.out.print((char)(n + 'A'));
        
        if(list[n].size() > 1){
            if(list[n].get(1) != -1) inOrder(list[n].get(1));
        }
    }
    
    public static void postOrder(int n){

        for(int c : list[n]){
            if(c == -1) continue;
            postOrder(c);           
        }
        System.out.print((char)(n + 'A'));
    }
}
