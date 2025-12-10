import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        
        PriorityQueue<int[]> queue = new PriorityQueue<>(
            (a, b) -> {
                if(a[1] == b[1]){
                    if(a[2]==b[2]){
                        return b[3]-a[3];
                    }
                    return b[2]-a[2];
                }
                return b[1]-a[1];
            }
        );
        
        for(int i = 0 ; i < N ; i++){
            input = buffer.readLine().split(" "); 
            int num = Integer.parseInt(input[0]);
            int gold = Integer.parseInt(input[1]);
            int silver = Integer.parseInt(input[2]);
            int bronze = Integer.parseInt(input[3]);
            
            queue.offer(new int[]{num, gold, silver, bronze});
        }
        int idx = 0;
        int preIdx=0;
        int preGold=0;
        int preSilver=0;
        int preBronze=0;
        
        for(int[] A : queue){
            if(
                preGold == A[1] &&
                preSilver == A[2] &&
                preBronze == A[3]
            ) preIdx = idx;
            else idx++;
            if(A[0] == K) System.out.println(idx);

            preIdx = idx;
            preGold = A[1];
            preSilver = A[2];
            preBronze = A[3];
        }

    }
}
