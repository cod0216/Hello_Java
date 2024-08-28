package TIL;


import java.io.*;
import java.util.*;

public class S20055 {
    static LinkedList<int[]> beltUp; // 벨트 위 0번 벨트, 1번 로봇 유무
    static LinkedList<int[]> beltDown; // 벨트 아래

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        beltUp = new LinkedList<>();
        beltDown = new LinkedList<>();
        int[][] temp = new int[101][2];

        input = buffer.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            beltUp.offerLast(new int[]{Integer.parseInt(input[i]), 0});
        }

//        int []{ 내구, 0};

        int result = 0;

        for (int i = N; i < 2 * N; i++) {
            beltDown.offerFirst(new int[]{Integer.parseInt(input[i]), 0});
        }
        int cnt = 0;

//        배열[1] == 1 이면 로봇 올림 0이면 없음
        while (cnt < K) {

            rotate(); //돌려돌려
//            System.out.println("s : " + beltUp.size());
            move();// 로봇 아장아장


            // 로봇 올림
            if (beltUp.peekFirst()[0] > 0) {
                int[] dummy = beltUp.pollFirst();
                dummy[0] -= 1;
                dummy[1] = 1;
                beltUp.offerFirst(dummy); // 올림
            }
            cnt = checkCnt();
            result++;
        }

        /*
        그니까 벨트는 계속 회전하고 시작지점에서 로봇 올리는데
        올리는 곳의 내구도가 0이면 올리지 않고
        내구도가 0이 K개 이상이면 종료 하고

        그런데 내구도는 벨트의 내구도가 1칸 이상이여야 한다.
        로봇이 ㅁ -> ㅇ 움직이면 ㅇ내구도 감소
         */

        System.out.println(result);
    }

    public static void rotate() {
        beltDown.offerLast(beltUp.pollLast());
        beltUp.offerFirst(beltDown.pollFirst());

        int[] dummy = beltUp.pollLast();
        dummy[1] = 0;
        beltUp.offerLast(dummy);
    }


    //Cnt 개수 체크
    public static int checkCnt() {
        int cnt = 0;

        for (int[] ints : beltUp) {
            if (ints[0] == 0) {
                cnt++;
            }
        }
        for (int[] ints : beltDown) {
            if (ints[0] == 0) {
                cnt++;
            }
        }

        return cnt;
    }

    public static void move() {
        int size = beltUp.size();
        int[][] temp = new int[size][];
        for (int i = 0; i < size; i++) {
            temp[i] = beltUp.pollFirst();
        }

        for (int i = size - 2; i >= 0; i--) {
            if (temp[i][1] == 1 && temp[i + 1][0] != 0 && temp[i + 1][1] == 0) {
                temp[i][1] = 0;
                temp[i + 1][0] -= 1;
                temp[i + 1][1] = 1;
            }
        }

        for (int i = size - 1; i >= 0; i--) {
            beltUp.offerFirst(temp[i]);
        }
        int[] dummy = beltUp.pollLast();
        dummy[1] = 0;
        beltUp.offerLast(dummy);
    }
}
