import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        long beem = 0;
        int tall = 0;

        int building[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            building[i] = Integer.parseInt(st.nextToken());
            tall = Math.max(tall, building[i]);
        }

        int row = tall - D;
        if (row < 0) {
            row = 0;
        }

        for (int i = 0; i < N; i++) {
            if (building[i] > row) {
                beem = beem + building[i] - row;
            }
        }

        System.out.println(beem);
    }
}