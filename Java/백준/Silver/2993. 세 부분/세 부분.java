import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        String min = "z";
        for (int i = 1; i < s.length() - 1; i++) {
            for (int j = i + 1; j < s.length(); j++) {
                String tmp = reverse(s.substring(0, i)) + reverse(s.substring(i, j)) + reverse(s.substring(j));
                if (min.compareTo(tmp) > 0) min = tmp;
            }
        }

        bw.write(min);
        bw.flush();
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }

}