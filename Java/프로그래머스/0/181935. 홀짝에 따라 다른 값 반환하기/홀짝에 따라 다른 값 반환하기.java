import java.util.*;

class Solution {
    public int solution(int n) {
        int ans = 0;
        if(n%2 == 1){
            for(int i = 1 ; i <= n; i++){
                if(i%2 == 1) ans += i;
                else continue;
            }
        }else {
            for(int i = 1 ; i <= n; i++){
                if(i%2 == 0) ans += (int)Math.pow(i,2);
                else continue;
            }
        }
        
        return ans;
        
    }
}