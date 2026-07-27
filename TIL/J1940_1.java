package TIL;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class J1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        int maxValue = Integer.parseInt(bufferedReader.readLine());
        int[] numArray = new int[num];
        int startPoint = 0;
        int endPoint = num-1;
        int cnt = 0;
        numArray[0] = 0;
        String[] input = bufferedReader.readLine().split(" ");
        for(int i = 0; i<num; i++){
            numArray[i] = Integer.parseInt(input[i]);

        }
        Arrays.sort(numArray);

        while((endPoint > startPoint)){
            if(numArray[startPoint]+numArray[endPoint] <maxValue)
                startPoint++;
            else if (numArray[startPoint] + numArray[endPoint] > maxValue) {
                endPoint--;
            }
            else if (numArray[startPoint] + numArray[endPoint] == maxValue) {
                cnt++;
                startPoint++;
                endPoint--;
            }
        }
        System.out.println(cnt);
    }
}
