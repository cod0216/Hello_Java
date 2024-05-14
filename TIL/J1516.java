package TIL;

import java.util.*;
import java.io.*;

public class J1516 {
    static LinkedList<Integer>[] A;
    static int[][] array;
    static int num;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        num = scanner.nextInt();
        A = new LinkedList[num+1];
        array = new int[3][num+1];
        check = new boolean[num+1];

        for(int i = 0; i <= num; i++){
            A[i] = new LinkedList<Integer>();
        }

        for(int i = 1; i <= num; i++){
            int n = scanner.nextInt();
            array[0][i] = n;
            while(true){
                n = scanner.nextInt();
                if(n == -1) break;
                A[n].add(i);
                array[1][i]++;
            }
        }

        topologicalSort();
        for (int i = 1; i <= num; i++) {
            System.out.println(array[2][i]);
        }
    }

    public static void topologicalSort () {
        int now = 0;
        Queue<Integer> queue = new LinkedList<Integer>();

        for (int i = 1; i <= num; i++) {
            if (array[1][i] == 0 && !check[i]) {
                now = i;
                check[i] = true;
                array[2][now] += array[0][now];
//                System.out.println(array[2][now]);
                break;
            }
        }
        int j = 0;
        while (j != num) {
            for (int i : A[now]) {
                array[1][i]--;
                array[2][i] = Math.max(array[2][i] , array[2][now]);
            }

            for (int i = 1; i <= num; i++) {
                if (array[1][i] == 0 && !check[i]) {
                    now = i;
                    check[i] = true;
                    array[2][now] += array[0][now];

                    break;
                }
            }
            j++;
        }
    }
}

// 연습장 2장, 핸, 신분증 등

// 1시간 이후부터 1회 한번 가능

// 손을 들어서 감독관 확인 이후 가능

// 응시 종료 또한 1시간 이후 가능 임의로 응시 종료하지 않기




