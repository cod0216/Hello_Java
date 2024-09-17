package TIL;


import java.io.*;
import java.nio.Buffer;
import java.util.*;

/*
선영이 주말에 할 짓 없어서 새로운 언어 AC를 만듦
AC는 정수 배열에 연산을 하기 위한 언어

R: 뒤집기
D: 버리기 ->첫번째 수 버림( 배열이 비어있으면 에러)

[입력]
T 수
함수
배열에 들어있는 개수n
배열에 들어 잇는 정수

아 큐 항상 까먹네;

 */
public class J5430 {
    static int idx;
    static LinkedList<Integer> list;

    static char[] commend;
    static boolean reverse, isError;

    public static void main(String[] args) throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(buffer.readLine());
        int t = 0;

        while (T > t) {
            StringBuilder sb = new StringBuilder();
            String str = buffer.readLine();
            commend = str.toCharArray();
            idx = Integer.parseInt(buffer.readLine());
            list = new LinkedList<>();
            reverse = false;
            isError = false;

            str = buffer.readLine().replaceAll("[\\[\\] ]", "");
            String[] input = str.split(",");

            for (int i = 0; i < input.length; i++) {
                if (idx == 0){
                    break;
                }
                list.offerLast(Integer.parseInt(input[i]));
            }// input complete


            for (int i = 0; i < commend.length; i++) {
                if (commend[i] == 'R') {
                    reverse = !reverse;
                } else if (commend[i] == 'D') {
                    if (list.size() == 0) {
                        isError = true;
                        break;
                    }

                    if (reverse) list.pollLast();
                    else list.pollFirst();
                }
            }

            t++;
            if (isError) {
                System.out.println("error");
            } else {
                sb.append("[");
                if (!reverse) {
                    if (list.size() > 0) sb.append(list.pollFirst());
                    while (!list.isEmpty()) {
                        sb.append("," + list.pollFirst());
                    }
                } else {
                    if (list.size() > 0) sb.append(list.pollLast());
                    while (!list.isEmpty()) {
                        sb.append("," + list.pollLast());
                    }
                }
                sb.append("]");
                System.out.println(sb);
            } //print


        }// t end

    }
}
