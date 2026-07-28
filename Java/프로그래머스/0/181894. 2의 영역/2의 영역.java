class Solution {
    public int[] solution(int[] arr) {
        int max = 0; int min = 9999999;
        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == 2){
                max = Math.max(max, i);
                min = Math.min(min, i);
            }
        } 
        if (min == 9999999) return new int[]{-1};
        int idx = max-min+1;
        int[] result = new int[idx];
        for(int i = 0 ; i < idx; i++){
            result[i] = arr[min+i];
        } 
        
        return result;
    }
}