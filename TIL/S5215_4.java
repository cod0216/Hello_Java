package TIL;

public class S5215_4 {
    static int N, L, ans;
    static int[] point, cal;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;
        while (T > t) {
            String[] input = buffer.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            L = Integer.parseInt(input[1]);
            point = new int[N];
            cal = new int[N];
            ans = 0;

            for (int i = 0; i < N; i++) {
                input = buffer.readLine().split(" ");
                point[i] = Integer.parseInt(input[0]);
                cal[i] = Integer.parseInt(input[1]);
            }

            combinate(0, new boolean[N], 0);

            t++;
            System.out.println("#" + t + " " + ans);
        }
    }

    public static void combinate(int idx, boolean[] selected, int calory) {
        if (calory > L) return;

        int score = 0;
        for (int i = 0; i < selected.length; i++) {
            if (selected[i]) score += point[i];
        }

        ans = Math.max(ans, score);
        for (int i = idx; i < selected.length; i++) {
            selected[i] = true;
            combinate(i + 1, selected, calory + cal[i]);
            selected[i] = false;
        }
    }
}
