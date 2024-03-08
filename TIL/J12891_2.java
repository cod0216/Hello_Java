package TIL;


import java.io.*;

public class J12891_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bufferedReader.readLine().split(" ");
        int e = Integer.parseInt(input[1]);
        char[] charArray = bufferedReader.readLine().toCharArray();
        int[] window = new int[4];
        input = bufferedReader.readLine().split(" ");
        int[] numArray = new int[4];

        numArray[0] = Integer.parseInt(input[0]);
        numArray[1] = Integer.parseInt(input[1]);
        numArray[2] = Integer.parseInt(input[2]);
        numArray[3] = Integer.parseInt(input[3]);



        for(int i = 0; i < e; i++) {
            if (charArray[i] == 'A') {
                window[0] += 1;
            } else if (charArray[i] == 'C') {
                window[1] += 1;
            } else if (charArray[i] == 'G') {
                window[2] += 1;
            } else if (charArray[i] == 'T') {
                window[3] += 1;
            }
        }
        int cnt = 0;
        if((numArray[0] <= window[0]) && (numArray[1] <= window[1]) && (numArray[2] <= window[2]) && (numArray[3] <= window[3]))
            cnt++;

        int num = e;
        int front =0;

        while(num < charArray.length) {
            if (charArray[front] == 'A') {
                window[0] -= 1;
            } else if (charArray[front] == 'C') {
                window[1] -= 1;
            } else if (charArray[front] == 'G') {
                window[2] -= 1;
            } else if (charArray[front] == 'T') {
                window[3] -= 1;
            }
            front++;

            if (charArray[num] == 'A') {
                window[0] += 1;
            } else if (charArray[num] == 'C') {
                window[1] += 1;
            } else if (charArray[num] == 'G') {
                window[2] += 1;
            } else if (charArray[num] == 'T') {
                window[3] += 1;
            }
            num++;
            if(numArray[0] <= window[0] && numArray[1] <= window[1] && numArray[2] <= window[2] && numArray[3] <= window[3])
                cnt++;

        }
        System.out.println(cnt);





    }
}
