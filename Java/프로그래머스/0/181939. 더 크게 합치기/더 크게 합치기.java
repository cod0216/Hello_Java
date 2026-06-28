class Solution {
    public int solution(int a, int b) {
        int max = Math.max(a,b);
        int min = Math.min(a,b);
        return Math.max(Integer.parseInt(max + "" + min), Integer.parseInt(min + "" + max));
    }
}