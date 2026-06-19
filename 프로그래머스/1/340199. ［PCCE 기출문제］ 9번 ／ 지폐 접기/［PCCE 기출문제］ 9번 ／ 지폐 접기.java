class Solution {
    public int solution(int[] wallet, int[] bill) {
        int cnt = 0;
        
        while(!check(bill[0], bill[1], wallet)){
            if(bill[0] > bill[1]){
                bill[0] /=2;
            } else {
                bill[1] /= 2;
            }
            cnt++;
        }
        return cnt;
    }
    
    public static boolean check (int a, int b, int[] wallet) {
        if((wallet[0] >= a && wallet[1] >= b) || (wallet[0] >= b && wallet[1] >= a)) return true;
        return false;
    }
}