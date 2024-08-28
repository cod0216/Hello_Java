import java.io.*;

public class S5644 {

    static int[] dx = {0, -1, 9, 1, 0};
    static int[] dy = {0, 0, 1, 0, -1};
    static int M;
    static int A;
    static int[][] person;
    static int[][] battery;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while (T > t) {
            String[] input= buffer.readLine().split(" ");

            person = new int[10][10];

            M = Integer.parseInt(input[0]);
            A = Integer.parseInt(input[1]);

            person = new int[2][M];


            for(int i = 0; i < 2; i++) {
                input = buffer.readLine().split(" ");
                for (int j = 0; j < M; i++) {
                    person[i][j] = Integer.parseInt(input[j]);
                }
            }

            for(int i = 0; i < A; i++){
                input = buffer.readLine().split(" ");
                for(int j = 0; j < 4; j++){
                    battery[i][j] = Integer.parseInt(input[j]);
                }
            }
            for(int i = 0; i < M; i++){
//                person1(i);
            }


        }
// person1이 지나간 자리는 1
// person2이 지나간 자리는 2
// person이 중복된 자리는 3
// 이후 미리 깔아두고 베터리 배열에 넣기





    }
//    public static void person1(int n){
//        int nx = x + dx[n];
//    }
}
