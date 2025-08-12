package TIL;
import java.io.*;

public class J11659_4 {
    static int n, m;
    static int[] box, sumBox;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String[] input = buffer.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        box = new int[n+1];
        sumBox = new int[n+1];

        input = buffer.readLine().split(" ");
        for(int i = 1 ; i <= n; i++){
            box[i] = Integer.parseInt(input[i-1]);
            sumBox[i] = sumBox[i-1] + box[i];
        }

        for(int i = 0 ; i < m; i++){
            input = buffer.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            System.out.println(sumBox[end]- sumBox[start-1]);
        }
    }
}
