import java.util.*;

class Solution {
    public int[] solution(int l, int r) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = l; i <= r ; i++){
            String str = String.valueOf(i);
            
            boolean flag = true;
            
            for(char c : str.toCharArray()){
                if(c != '0' && c != '5'){
                    flag =  false;
                    break;
                }
            }
            if(flag) list.add(i);
        }
        
        if(list.isEmpty()) return new int[] {-1};
        int[] ans = new int[list.size()];
        
        for(int i = 0 ; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}