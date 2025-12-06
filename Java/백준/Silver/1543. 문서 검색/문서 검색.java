import java.io.*;
import java.util.*;
public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        
        char [] wordList = br.readLine().toCharArray();
        char [] findWord = br.readLine().toCharArray();
        int pos = 0;
        int answer = 0;
        int range = wordList.length - findWord.length;
        while (pos <= range){
            boolean isFlag = true;
            int curPos = pos;
            for (int j = 0; j < findWord.length; j++) {
                if (wordList[curPos] == findWord[j]){
                    curPos++;
                }else{
                    isFlag = false;
                    break;
                }
            }
            if (isFlag){
                pos = curPos;
                answer++;
            }else{
                pos++;
            }
        }
        System.out.print(answer);
    }
}
