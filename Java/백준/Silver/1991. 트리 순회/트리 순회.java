import java.util.*;
import java.io.*;

class Node{
    char value;
    Node left;
    Node right;
    
    public Node(char value){
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class Main {
    static Node[] tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());
        tree = new Node[N+1];
        for(int i = 0 ; i < N; i++){
            String[] input = buffer.readLine().split(" ");
            char mid = input[0].charAt(0);
            char left = input[1].charAt(0);
            char right = input[2].charAt(0);
            
            if(tree[mid - 'A'] == null){
                Node node = new Node(mid);
                tree[mid - 'A'] = node;
            }
            if(left != '.'){
                tree[left -'A'] = new Node(left);
                tree[mid - 'A'].left = tree[left-'A'];
            }
            if(right != '.'){
                tree[right-'A'] = new Node(right);
                tree[mid - 'A'].right = tree[right-'A'];
            }
        }
        
        preorder(tree[0]);
        System.out.println();
        inorder(tree[0]);
        System.out.println();
        postorder(tree[0]);
        System.out.println();
    }
    
    public static void preorder(Node node){
        if(node == null) return;
        System.out.print(node.value);
        preorder(node.left);
        preorder(node.right);        
    }
    public static void inorder(Node node){
        if(node == null) return;
        inorder(node.left);
        System.out.print(node.value);
        inorder(node.right);        
    }
    public static void postorder(Node node){
        if(node == null) return;
        postorder(node.left);
        postorder(node.right);        
        System.out.print(node.value);
    }
}
