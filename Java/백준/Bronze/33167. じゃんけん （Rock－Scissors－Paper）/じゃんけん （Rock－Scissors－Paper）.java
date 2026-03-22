import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        String T = br.readLine();

        int aoiWin = 0;
        int bitaroWin = 0;

        for (int i = 0; i < N; i++) {
            char s = S.charAt(i);
            char t = T.charAt(i);

            if (s == 'S' && t == 'P') {
                aoiWin++;
            } else if ((s == 'R' && t == 'P') || (s == 'S' && t == 'R')) {
                bitaroWin++;
            }
        }

        System.out.println(aoiWin + " " + bitaroWin);
    }
}