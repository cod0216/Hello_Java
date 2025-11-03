import java.io.*;
import java.util.*;

class Info implements Comparable<Info>{
    int e;
    public Info(int e){
        this.e = e;
    }
    public int compareTo(Info o){
        return o.e - this.e;
    }
}
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0 ;
        while(T>t){
            int sum = 0;
            int v = 0;
            int year = 1;
            PriorityQueue<Info> list = new PriorityQueue<>();
            while((v = Integer.parseInt(buffer.readLine())) != 0){
                list.offer(new Info(v));
                year++;
            }
            
            for(int i = 0 ; i < year-1; i++){
                sum += getPrice(list.poll().e, i+1);
            }
            System.out.println(sum > 5000000 ? say() : sum);
            t++;
        }
        
    }
    public static double getPrice(int price, int year){    
        return 2*Math.pow(price,year);
    }
    public static String say(){
        return "Too expensive";
    }
}
