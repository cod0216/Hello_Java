import java.util.*;
import java.io.*;

public class Main {
    static int T, N, preIdx;
    static int[] preOrder, inOrder;
    public static void main(String[] args) throws IOException{
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(buffer.readLine());
        while(T --> 0){
            N = Integer.parseInt(buffer.readLine());
            preOrder = new int[N];
            inOrder = new int[N];
            preIdx=0;
            preOrder = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inOrder = Arrays.stream(buffer.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 3 2 1 4
            // 2  |3| 4 1
            
            postOrder(0, N-1);
            System.out.println();
        }
        
    }
    
    public static void postOrder(int start, int end){
        if (start > end) return;
        int middle = preOrder[preIdx++];
        int inIdx = -1;
            
        for(int i = start; i <= end; i++){
            if(inOrder[i] == middle){
                inIdx = i; break;
            }
        }
        postOrder(start, inIdx-1);
        postOrder(inIdx+1, end);
        System.out.print(middle + " ");
           
    }
}
