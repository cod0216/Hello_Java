package TIL;

import java.util.Scanner;

public class J1784 {
    public static boolean chk(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        while (chk(sb.toString())) {
            int i = 0, j = 0;
            for (i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == sb.charAt(i + 1)) {
                    while (i - j >= 0 && i + 1 + j < sb.length() && sb.charAt(i - j) == sb.charAt(i + 1 + j)) {
                        j++;
                    }
                    j -= 1;
                    break;
                }
            }
            sb.delete(i - j, i + 1);
        }

        System.out.println(sb.length());
    }
}
