import java.util.*;
import java.io.*;

class Node {
    public int num;
    public int parent;
    public int left;
    public int right;
    
    public Node(int num, int left, int right){
        this.num = num;
        this.parent = -1;
        this.left = left;
        this.right = right;
    }
}

public class Main{
    static int N, max[], min[], nodeIdx=1;
    static Node[] nodes;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        max = new int[N+1];
        min = new int[N+1];
        nodes = new Node[N+1];
        for(int i = 0; i <= N; i++){
            max[i] = 0;   
            min[i] = N;
            nodes[i] = new Node(i, -1, -1);
            
        }
        
        for(int i = 1; i <= N; i++){
            String[] input = buffer.readLine().split(" ");
            
            int num = Integer.parseInt(input[0]);
            int left = Integer.parseInt(input[1]);
            int right = Integer.parseInt(input[2]);
            
            nodes[num].left = left;
            nodes[num].right = right;
            
            if(left != -1) nodes[left].parent = num;
            if(right != -1) nodes[right].parent = num;
        }
        // mapping done
        
        int root = 0;
        for(int i = 1; i <= N; i++){
            if(nodes[i].parent == -1){
                root = i;
                break;
            }
        }
        inoder(root,1);
        int length = 0;
        int level = 1;
        
        for(int i = 0 ; i <= N; i++) {
            int temp = max[i] - min[i];
            if( length < temp) {
                level  = i;
                length = temp;
            }
        }
        
        System.out.println(level + " " + (length+1));
    }
    
    public static void inoder(int node, int level){
        Node cur = nodes[node];
        if(cur.left != -1) inoder(cur.left, level+1);
        min[level] = Math.min(min[level], nodeIdx);        
        max[level] = Math.max(max[level], nodeIdx);
        nodeIdx++;
        if(cur.right != -1) inoder(cur.right, level+1);        
        
    }
}
