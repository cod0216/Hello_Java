import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;
        while ((s = buffer.readLine()).charAt(0) != '#') {
            int sum = 0, l = s.length();
            for (int i = 0; i < l; ) sum += Math.max(0, s.charAt(i++) - '@') * i;
            sb.append(sum).append('\n');
        }

        System.out.println(sb.toString());
    }

}