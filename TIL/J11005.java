package TIL;

import java.util.Scanner;

public class J11005 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        int largeNumber = scanner.nextInt();
        int result = largeNumber;
        char[] lastResult;
        int keyNumber = scanner.nextInt();
        int keyInt;
        char keyChar;
        for(int i = 0 ; i < 99; i++) {
            result = result/keyNumber;
            cnt++;
            if(result == 0) {
                break;
            }

        }
        lastResult = new char[cnt];
        int result1 = largeNumber;
        for(int i = 0; i <cnt; i++) {
            keyInt= result1%keyNumber;
            result1 = result1/keyNumber;

            if(keyInt> 9) {
                keyChar = changeChar(keyInt);
                lastResult[cnt-i-1] = keyChar;
            }
            if(keyInt<10) {
                lastResult[cnt - i - 1] = (char) (keyInt + 48);
            }
        }

        for(int i = 0 ; i < lastResult.length; i++) {
            System.out.print(lastResult[i]);
        }
    }


    public static char changeChar(int x){
        char keyChar;
            int intTemp = x;
            keyChar = (char) ((x - 10) + 'A');
        return keyChar;
    }

    public static int findPositionNumber(int x, int y){
        int result = x;

        for(int i = 2; i <y; i ++){
            result *= result;
        }
    return result;
    }
}
