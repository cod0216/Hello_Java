class Solution {
    public int solution(int[] num_list) {
        int dou = 0;
        int odd = 0;
        for(int i = 0; i < num_list.length; i++){
            if(i%2 == 0) dou += num_list[i];
            else odd += num_list[i];
        }
        return (int)Math.max(dou, odd);
    }
}