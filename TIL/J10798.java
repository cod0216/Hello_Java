package TIL;

import java.util.Scanner;

public class J10798 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] arr = new char[5][15];
        for (int i = 0; i < 5; i++) {
            String str = scanner.nextLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j][i] == '\0')
                    continue;
                System.out.print(arr[j][i]);
            }
        }
    }

}

