import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        String[] input = buffer.readLine().split(" ");
        int[] get = new int[5];
        PriorityQueue<Integer> one = new PriorityQueue<>();
        PriorityQueue<Integer> two = new PriorityQueue<>();
        PriorityQueue<Integer> three = new PriorityQueue<>();
        PriorityQueue<Integer> four = new PriorityQueue<>();
        PriorityQueue<Integer> five = new PriorityQueue<>();        
        
        for(int i = 0 ; i < 5; i++){
            get[i] = Integer.parseInt(input[i]);
        }
        
        for(int i = 0; i < N; i++){
            input = buffer.readLine().split(" ");
            int idx = Integer.parseInt(input[0]);
            int value = Integer.parseInt(input[1]);
            if(idx == 1) one.offer(value);
            else if(idx == 2) two.offer(value);
            else if(idx == 3) three.offer(value);
            else if(idx == 4) four.offer(value);
            else five.offer(value);
        }
        
        int idx = 0;
        int sum = 0;
        int pre = 0;
        boolean first = true;
        while(true){
            if(idx == 5)break;
            
            if(get[idx] == 0){
                if(idx != 4)sum += 60;
                idx++;
                pre = 0;
                first = true;
                continue;
            }
            
            get[idx]--;
            if(idx == 0){
                int v = one.poll();  
                sum += v;
                if(first){
                    first = false;
                } else {
                    int temp = v;
                    temp -= pre;
                    sum += temp;
                }
                pre = v;
                // System.out.println(sum);
            } 
            else if(idx == 1){
                int v = two.poll();  
                sum += v;
                if(first){
                    first = false;
                } else {
                    int temp = v;
                    temp -= pre;
                    sum += temp;
                }
                pre = v;
                // System.out.println(sum);
            } 
            else if(idx == 2){
                int v = three.poll();  
                sum += v;
                if(first){
                    first = false;
                } else {
                    int temp = v;
                    temp -= pre;
                    sum += temp;
                }
                pre = v;
                // System.out.println(sum);
            }  
            else if(idx == 3){
                int v = four.poll();  
                sum += v;
                if(first){
                    first = false;
                } else {
                    int temp = v;
                    temp -= pre;
                    sum += temp;
                }
                pre = v;
                // System.out.println(sum);
            } 
            else{
                int v = five.poll();  
                sum += v;
                if(first){
                    first = false;
                } else {
                    int temp = v;
                    temp -= pre;
                    sum += temp;
                }
                pre = v;
                // System.out.println(sum);
            }  
        }
        
        System.out.println(sum);
        
    }
}
