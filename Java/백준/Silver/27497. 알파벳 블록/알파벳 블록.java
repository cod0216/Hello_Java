import java.util.*;
import java.io.*;

public class Main {
    static LinkedList<Character> queue = new LinkedList<>();
    static LinkedList<Integer> stack = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        int a;
        char b = 'd';
        
        while(N --> 0){
            String[] input = buffer.readLine().split(" ");
            
            a = Integer.parseInt(input[0]);
            if(a != 3) b = input[1].charAt(0);
            
            play(a, b);
        }
        if(queue.isEmpty()) System.out.println(0);
        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            sb.append(queue.pollFirst());
        }
            System.out.println(sb.toString());
    }
    
    public static void play(int a, char b){
        if(a==1) {
            queue.addLast(b);
            stack.push(a);
        }
        else if(a==2){
            queue.addFirst(b);  
            stack.push(a);
            
        } 
        else if(a==3 && !queue.isEmpty()){
            int command = stack.pop();
            if(command == 1){
                queue.pollLast();
            } else {
                queue.pollFirst();
            }
        } 
    }
    
}
