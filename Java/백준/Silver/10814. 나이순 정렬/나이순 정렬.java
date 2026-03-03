import java.util.*;
import java.io.*;

class Human implements Comparable<Human> {
    int id;
    int age;
    String name;
    
    public Human(int cnt, int age, String name) {
        this.id = cnt;
        this.age = age;
        this.name = name;
    }
    
    public int compareTo(Human o){
        if( this.age == o.age) return this.id - o.id;
        return this.age - o.age;
    }
}


public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Human> queue = new PriorityQueue<>();
        int N = Integer.parseInt(buffer.readLine());
        for(int i = 0; i < N; i++){
            cnt += 1;
            String input[] = buffer.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            String name = input[1];
            
            queue.offer(new Human(cnt, age, name));
        }
        
        while(!queue.isEmpty()){
            Human human = queue.poll();
            System.out.println(human.age + " " + human.name);
        }
        
    }
}
