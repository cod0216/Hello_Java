import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(buffer.readLine());

        int minR = Integer.MAX_VALUE, maxR = Integer.MIN_VALUE;
        int minC = Integer.MAX_VALUE, maxC = Integer.MIN_VALUE;
        int total = 0;
        
        for(int i= 0 ; i < N ; i++){
            String[] input = buffer.readLine().split("");
            for(int j= 0; j < N; j++){            
                char v = input[j].charAt(0);
                if(v == 'G'){
                    if(minR > i) minR = i;
                    if(maxR < i) maxR = i;
                    if(minC > j) minC = j;
                    if(maxC < j) maxC = j;
                    total++;
                }
            }
        }

        if (total <= 1) {
            System.out.println(0);
            return;
        }

        int ans;

        if(maxR == minR) {
            ans = Math.min(maxC, (N-1)-minC);
        } else if (maxC == minC) {
            ans = Math.min(maxR, (N-1)-minR);
        } else {
            int top = maxR;
            int bottom = (N-1) - minR;
            int left = maxC;
            int right = (N-1) - minC;
            ans = Math.min( Math.min(top+left, top+right),
                      Math.min(bottom+left, bottom+right)
            );
        }

        System.out.println(ans);
    }
}