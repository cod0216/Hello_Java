package TIL;

import java.util.Scanner;

public class J10988 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int check = 1;
        String[] arr = str.split("");
        String[] arrRev = new String[str.length()];

        for(int i = 0; i < arr.length; i++) {
            arrRev[i] = arr[arr.length - 1 - i];
        }

        for(int i = 0; i < arr.length; i++) {
            if (!arrRev[i].equals(arr[i])){
                check = 0;
                break;
            }
        }

        System.out.println(check);

    }
}
