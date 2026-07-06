class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int n = photo.length;
        int[] ans = new int[n];
        
        while(n > 0){
            for(int i = 0; i < photo[n-1].length; i++){
                String target = photo[n-1][i];
                for(int j = 0; j < yearning.length; j++){
                    if(target.equals(name[j])){
                        ans[n-1] += yearning[j];
                        break;
                    } 
                }    
            }
            n--;
        }
        
        
        return ans;
    }
}