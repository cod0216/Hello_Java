package TIL.review;

import java.util.*;
import java.io.*;

public class J12891 {
    static int cnt = 0;
    static int numA;
    static int numC;
    static int numG;
    static int numT;
    static int strLength;
    static int partLength;
    static int[] smallBox= new int[4];


    public static void main(String[] args)throws IOException {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input= buffer.readLine().split(" ");

        strLength = Integer.parseInt(input[0]);
        partLength = Integer.parseInt(input[1]);

        String str = buffer.readLine();
        char[] box = str.toCharArray();
        char[] miniBox = new char[partLength];
//
//        -------------------- 글자를 배열에 옮기기 -------------------
//


        input= buffer.readLine().split(" ");

        numA = Integer.parseInt(input[0]);
        numC = Integer.parseInt(input[1]);
        numG = Integer.parseInt(input[2]);
        numT = Integer.parseInt(input[3]);

        int[] checkBox = new int[]{numA, numC, numG, numT};

//        ------------조건 잘 분리했고 이걸 checkBox 에 넣었음 ----------

        for(int i =0; i< partLength; i++){
            miniBox[i] = box[i];
        }

//        ----- miniBox에 Box 값을 넣었음 (윈도우) -----


        for(int i =0; i< partLength; i++){
            find(miniBox[i]);
        }

        check(checkBox);
        int start = 0;
        int end = partLength;
        while(end != strLength){
            delete(box[start++]);
            find(box[end++]);
            check(checkBox);
        }
        System.out.println(cnt);
    }
    public static void delete(char val){
        switch (val){
            case 'A':
                smallBox[0]--;
                break;
            case 'C':
                smallBox[1]--;
                break;
            case 'G':
                smallBox[2]--;
                break;
            case 'T':
                smallBox[3]--;
                break;
            default:
                break;
        }
    }
    public static void find(char val){
        switch (val){
            case 'A':
                smallBox[0]++;
                break;
            case 'C':
                smallBox[1]++;
                break;
            case 'G':
                smallBox[2]++;
                break;
            case 'T':
                smallBox[3]++;
                break;
            default:
                break;
        }
    }
    public static void check(int[] tiniBox){

        if(smallBox[0] >= tiniBox[0])
            if(smallBox[1] >= tiniBox[1])
                if(smallBox[2] >= tiniBox[2])
                    if(smallBox[3] >= tiniBox[3]) {
                        cnt++;
                    }
    }
}
