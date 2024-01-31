package TIL;

import java.util.Scanner;

public class J10809 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        for(int i = 0; i < 27; i++){
            char var = (char)(97+i);
            System.out.print(str.indexOf(var) + " ");
        }
    }
}
