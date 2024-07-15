package TIL;

import java.io.*;



public class s2008 {
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    static char[][] build;
    static int N;
        public static void main(String[] args) throws IOException {
            BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

            N = Integer.parseInt(buffer.readLine());

            build = new char[N][N];

            for(int i = 0; i < N ; i++){
                String[] input = buffer.readLine().split(" ");
                for(int j = 0; j< N ; j++){
                    build[i][j] = input[j].charAt(0);
                }
            }

            int nx=0;
            int ny=0;
            int max = 0;

            int hight = 0;
            boolean check = false;

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++) {
                    if (build[i][j] == 'G') continue;
                    for (int k = 0; k < 8; k++) {
                        nx = i + dx[k];
                        ny = j + dy[k];
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                            if (build[nx][ny] == 'G') {
                                hight = 2;
                                if (max < hight) {
                                    max = hight;
                                }
                                check = true;
                                break;
                            }
                        }
                    }
                    if (!check) {

                        int x = col(j);
                        int y = row(i);
                        hight = x + y - 1;
                        if (max < hight) {
                            max = hight;
                        }
                    }
                    check = false;
                }
            }

            System.out.println(max);
        }


        public static int col(int index){
            int high = 0;
            for(int i = 0; i < N; i++){
                if(build[i][index] == 'B')
                    high ++;
            }
            return high;
        }
        public static int row(int index){
            int high = 0;
            for(int i = 0; i < N; i++){
                if(build[index][i] == 'B')
                    high ++;
            }
            return high;
        }

}
