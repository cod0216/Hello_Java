import java.util.*;
import java.io.*;

class Node {
    char v;
    Node left = null;
    Node right = null;
    
    public Node(char c){
        v = c;
    }
}
public class Main {
    static Node[] tree;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        tree = new Node[N];
        for(int i = 0; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            char a = input[0].charAt(0);
            char b = input[1].charAt(0);
            char c = input[2].charAt(0);
            if(tree[a - 'A'] == null) tree[a - 'A'] = new Node(a);
            if(b != '.'){
                if(tree[b-'A'] == null){
                    tree[b-'A'] = new Node(b);
                    tree[a-'A'].left = tree[b-'A'];
                }
            }
            if(c != '.'){
                if(tree[c-'A'] == null){
                    tree[c-'A'] = new Node(c);
                    tree[a-'A'].right = tree[c-'A'];
                }
            }
        }

        preOrder(tree[0]);
        System.out.println();
        inOrder(tree[0]);
        System.out.println();
        postOrder(tree[0]);
    }
    public static void preOrder(Node c){
        System.out.print(c.v);
        if(c.left != null) preOrder(c.left);
        if(c.right != null) preOrder(c.right);
    }
    public static void inOrder(Node c){
        if(c.left != null) inOrder(c.left);
        System.out.print(c.v);        
        if(c.right != null) inOrder(c.right);
    }
    public static void postOrder(Node c){
        if(c.left != null) postOrder(c.left);
        if(c.right != null) postOrder(c.right);
        System.out.print(c.v);
    }

}
