package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class S24472 {
    public static BufferedReader buffer;
    public static int T, a, b;
    public static HashSet<Integer> number;

    public static void buffer() throws IOException {
        buffer = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void initCase() throws IOException {
        T = Integer.parseInt(buffer.readLine());
    }

    public static void solve(int T) throws IOException {
        int t = 0;
        while(T>t){
            String[] input = buffer.readLine().split(" ");
            long n = Long.parseLong(input[0]);
            int m = Integer.parseInt(input[1]);

            long ans = (n % 2 == 0) ? -(n/2) : (n/2 + 1);
            System.out.print(ans + " ");

            number = new HashSet<>();
            input = buffer.readLine().split(" ");
            for(int i = 1; i <m; i++){
                int target = Integer.parseInt(input[i-1]);
                boolean initTeamA = (target % 2 == 1);
                boolean isToggled = number.contains(target);
                boolean nowTeamA = initTeamA ^ isToggled;

                if(nowTeamA) ans -= 2L * target;
                else ans += 2L * target;

                if(isToggled) number.remove(target);
                else number.add(target);
                System.out.print(ans + " ");
            }

            System.out.println();
            t++;
        }
    }

    public static void main(String[] args) throws IOException {
        buffer();
        initCase();
        solve(T);
    }
}
