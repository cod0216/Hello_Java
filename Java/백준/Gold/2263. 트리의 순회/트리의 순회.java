import java.util.*;
import java.io.*;

public class Main {
    static int N, postOrder[], inOrder[], inOrderIdx[], postIndex;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(buffer.readLine());
        postOrder = new int[N];
        inOrder = new int[N];
        visited = new boolean[N];
        inOrderIdx = new int[N];
        String[] input = buffer.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            inOrder[i] = Integer.parseInt(input[i])-1;
            inOrderIdx[inOrder[i]] = i;
        }

        input = buffer.readLine().split(" ");
        for(int i = 0 ; i < N; i++){
            postOrder[i] = Integer.parseInt(input[i])-1;
        }
        
        search(0, N-1, 0, N-1);
        
        
    }
    public static void search(int start, int end, int postStart, int postEnd){
        if(end < start || postEnd < postStart) return;
        int mid = postOrder[postEnd];
        System.out.print(mid+1 + " ");
        int inIdx = inOrderIdx[mid]; 
        int length = inIdx - start;
        search(start, inIdx-1, postStart, postStart+length-1);
        search(inIdx+1, end, postStart+length, postEnd-1);
    }
}
