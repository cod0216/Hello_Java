import java.io.*;


// 풀지 마라




public class Main {

    static long[] sum = new long[4];

    public static void main(String[] args) throws Exception {
        InputStream in = System.in;
        OutputStream out = System.out;

        int T = readInt(in);

        while (T-- > 0) {
            int N = readInt(in);

            sum[0] = sum[1] = sum[2] = sum[3] = 0;

            for (int i = 1; i <= N; i++) {
                int v = readInt(in);
                sum[i & 3] += v;
            }

            int start = 0;
            for (int r = 1; r < 4; r++) {
                if (sum[r] < sum[start]) start = r;
            }

            out.write('Y'); out.write('E'); out.write('S'); out.write('\n');

            int length = 0;

            for (int i = 1; i <= N; i++) {
                boolean no = (i == 1) || ((i & 3) == start);

                if (no) {
                    if (length > 0) {
                        int c = '0' + length;
                        for (int k = 0; k < length; k++) out.write(c);
                        length = 0;
                    }
                    out.write('0');
                } else {
                    length++;
                }
            }

            if (length > 0) {
                int c = '0' + length;
                for (int k = 0; k < length; k++) out.write(c);
            }

            out.write('\n');
        }
    }

    static int readInt(InputStream in) throws IOException {
        int c;
        while (true) {
            c = in.read();
            if (c == -1) return -1;
            if (c >= '0' && c <= '9') break;
        }
        int val = c - '0';
        while (true) {
            c = in.read();
            if (c < '0' || c > '9') break;
            val = val * 10 + (c - '0');
        }
        return val;
    }
}
