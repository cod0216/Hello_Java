package TIL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class J12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputFirst = bufferedReader.readLine().split(" ");
        int maxLine = Integer.parseInt(inputFirst[0]);
        int shortLine = Integer.parseInt(inputFirst[1]);
        int startPoint = 0;
        int endPoint = startPoint + shortLine-1;
        int cnt = 0;
        int[] numArray = new int[4];//A C G T

        int cntA = 0;
        int cntC = 0;
        int cntG = 0;
        int cntT = 0;

        String str = bufferedReader.readLine();
        char[] charLine = str.toCharArray();
        String[] input = bufferedReader.readLine().split(" ");
        for (int i = 0; i < 4; i++) {
            numArray[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < shortLine; i++) {
            if ('A' == charLine[i])
                cntA++;
            else if ('C' == charLine[i])
                cntC++;
            else if ('G' == charLine[i])
                cntG++;
            else if ('T' == charLine[i])
                cntT++;
        }
        if (cntA >= numArray[0] && cntC >= numArray[1] && cntG >= numArray[2] && cntT >= numArray[3]) {
            cnt++;
        };
        endPoint++;

        while (endPoint != charLine.length) {
            if ('A' == charLine[startPoint])
                cntA--;
            else if ('C' == charLine[startPoint])
                cntC--;
            else if ('G' == charLine[startPoint])
                cntG--;
            else if ('T' == charLine[startPoint])
                cntT--;

            startPoint++;

            if ('A' == charLine[endPoint])
                cntA++;
            else if ('C' == charLine[endPoint])
                cntC++;
            else if ('G' == charLine[endPoint])
                cntG++;
            else if ('T' == charLine[endPoint])
                cntT++;
            if (cntA >= numArray[0] && cntC >= numArray[1] && cntG >= numArray[2] && cntT >= numArray[3]) {
                cnt++;
            }
            endPoint++;
        }
        System.out.println(cnt);
    }
}
