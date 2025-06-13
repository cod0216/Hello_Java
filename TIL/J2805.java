package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int bring =Integer.parseInt(input[1]);

        int[] tree = new int[n];

        long from = 0;
        long to = Integer.MIN_VALUE;
        input = buffer.readLine().split(" ");

        for(int i = 0; i < n; i++){
            tree[i] = Integer.parseInt(input[i]);
            to = Math.max(to,tree[i]);
        }

        long mid;
        long ans = 0;
        while(from<=to){
            mid = (from+to)/2;

            long key =  cutting(mid, tree);

            if(key >= bring ){
                from = mid+1;
                ans = mid;
            }else if(key <= bring){
                to = mid-1;
            }
        }

        System.out.println(ans);
    }

    public static long cutting(long mid, int[] tree){
        long sum = 0;
        for(int i = 0; i<tree.length; i++){
            if(tree[i]>mid) {
                sum += tree[i]-mid;
            }
        }
        return sum;
    }
}
