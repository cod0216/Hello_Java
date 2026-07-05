class Solution {
    public int solution(int n, int m, int[] section) {
        int[] wall = new int[n];
        int cnt = 0;

        for (int i = 0; i < section.length; i++) {
            wall[section[i] - 1] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (wall[i] == 1) {
                cnt++;

                for (int j = i; j < Math.min(i + m, n); j++) {
                    wall[j] = 0;
                }
            }
        }

        return cnt;
    }
}