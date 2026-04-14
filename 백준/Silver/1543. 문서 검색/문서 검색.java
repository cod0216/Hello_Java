import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String doc = buffer.readLine();
        String word = buffer.readLine();

        int N = doc.length();
        int M = word.length();
        int cnt = 0;
        int pos = 0;

        while (pos + M <= N) {
            int found = doc.indexOf(word, pos);
            if (found == -1) break;

            cnt++;
            pos = found + M;
        }

        System.out.println(cnt);
    }
}
