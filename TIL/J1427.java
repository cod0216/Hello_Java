package TIL;

import java.util.Scanner;

public class J1427 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        char[] charArray = str.toCharArray();

        for(int i = 0; i < str.length()-1; i++){
            for(int j = i+1; j < str.length(); j++)
            if(charArray[j] > charArray[i]){
                char tmp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = tmp;
            }
        }
        for(int i = 0; i < charArray.length; i++){
            System.out.print(charArray[i]);
        }
    }
}
