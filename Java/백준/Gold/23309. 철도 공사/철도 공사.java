import java.util.*;
import java.io.*;

class Node {
    int v;
    Node next = null;
    Node prior = null;
    
    public Node(int v){
        this.v = v;
    }
}
public class Main {
    static int N, M;
    static Node[] pos;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(buffer.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        pos = new Node[1_000_001];
        
        st = new StringTokenizer(buffer.readLine());    
        
        Node head = null; Node prev = null;
        
        for(int i = 0 ; i < N; i++){
            int x = Integer.parseInt(st.nextToken());
            Node cur = new Node(x);
            pos[x] = cur;
            
            if(head == null) head = cur;
            
            if(prev != null){ 
                prev.next = cur;
                cur.prior = prev;
            }
            prev = cur;
        }
        
        prev.next = head;
        head.prior = prev;
        
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(buffer.readLine());
            String str = st.nextToken();
            int f = Integer.parseInt(st.nextToken());
            Node v = pos[f];
            
            if(str.equals("BN")){
                int x = Integer.parseInt(st.nextToken());
                Node next = v.next;
                sb.append(next.v).append("\n");
                
                Node cur = new Node(x);
                pos[x] = cur;
                
                v.next = cur;
                cur.prior = v;
                
                cur.next = next;
                next.prior = cur;
                
            }else if(str.equals("BP")){
                int x = Integer.parseInt(st.nextToken());
                Node cur = new Node(x);
                Node prior = v.prior;
                sb.append(prior.v).append("\n");
                pos[x] = cur;
                
                prior.next = cur;
                cur.prior = prior;
                
                cur.next = v;
                v.prior = cur;
                
            } else if(str.equals("CP")){
                Node del = v.prior;
                sb.append(del.v).append("\n");
                
                Node a = del.prior;
                Node b = del.next;
                
                a.next = b;
                b.prior = a;
                pos[del.v] = null;

            } else if(str.equals("CN")){
                Node del = v.next;
                sb.append(del.v).append("\n");
                
                Node a = del.prior;
                Node b = del.next;
                
                a.next = b;
                b.prior = a;
                pos[del.v] = null;

            }
        }
        System.out.println(sb.toString());
    }
}
