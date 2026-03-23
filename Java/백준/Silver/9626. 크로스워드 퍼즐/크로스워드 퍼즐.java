import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        input = buffer.readLine().split(" ");
        int U = Integer.parseInt(input[0]);
        int L = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);
        int D = Integer.parseInt(input[3]);

        String[] board = new String[N];
        for (int i = 0; i < N; i++) {
            board[i] = buffer.readLine();
        }

        int totalRow = N + U + D;
        int totalCol = M + L + R;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalCol; j++) {
                if (i >= U && i < U + N && j >= L && j < L + M) {
                    sb.append(board[i - U].charAt(j - L));
                } else {
                    sb.append((i + j) % 2 == 0 ? '#' : '.');
                }
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}