package TIL;

import java.util.*;
import java.io.*;



/*
순열을 만들고 모두 만들고 조합으로 확인하기

 */
public class S3234 {
    static int cnt;
    static int n;
    static int[] chu;
    static boolean[] visited;
    static int[] dummy;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(buffer.readLine());
        StringTokenizer st;
        int k = 0;


        while(K>k){
            n = Integer.parseInt(buffer.readLine());
            visited = new boolean[n];
//            st = new StringTokenizer(buffer.readLine());

            chu = new int[n]; //추
            String[] input = buffer.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                chu[i] = Integer.parseInt(input[i]);
            }
            cnt = 0;
            dummy = new int[n];

            perm(0);
            k++;
            System.out.println("#" + k + " " + cnt);
        }


    }

    static public void perm(int cnt) {
        if (cnt == n) {
            comb(0, 0, 0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dummy[cnt] = chu[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    static public void comb(int idxCnt, int right, int left) {
        if (right > left) {
            return;
        }
        if (idxCnt == n) { // 기저조건
            cnt++;
            return;
        }

        //왼쪽 올리기
        comb(idxCnt + 1, right, left + dummy[idxCnt]);
        // 지금 오른쪽값에 추 추가로 올리고 왼쪽보다 작거나 적으면 이경영
        comb(idxCnt + 1, right + dummy[idxCnt], left);
    }
}
