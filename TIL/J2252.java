package TIL;

import java.util.*;
import java.io.*;
public class J2252 {
    static LinkedList<Integer>[] A;
    static int[] answerArray;
    static int student;
    static int[] cntArray;
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = bufferedReader.readLine().split(" ");
         student = Integer.parseInt(input[0]);
        int compareNum = Integer.parseInt(input[1]);

        cntArray = new int[student+1];
        answerArray = new int[student+1];

        A = new LinkedList[student+1];
        for(int i = 0; i <= student; i++){
            A[i] = new LinkedList<Integer>();
        }

        for(int i = 0; i < compareNum; i++){
            input = bufferedReader.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            A[start].add(end);
            cntArray[end]++;
        }
        int baseValue = 0;

        for(int i = 1; i <= student; i ++){
            if(cntArray[i] == 0){
                baseValue = i;
                cntArray[i] = -1;
                break;
            }
        }

        topology(baseValue);
    }
    private static void topology(int value) {
        System.out.print(value + " ");
        for (int i : A[value]) {
            cntArray[i]--;
        }

        for (int i = 1; i <= student; i++) {
            if (cntArray[i] == -1) {
                continue;
            } else if (cntArray[i] == 0) {
                cntArray[i] = -1;
                topology(i);
            }
        }
    }
}
