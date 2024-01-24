package TIL;

import java.util.Scanner;

public class J25206 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            String str;

            char[][] subject = new char[20][50];
            int[][] score = new int[20][1];
            char[][] grade = new char[20][2];
            int end;
            double var = 0.0;
            double sum = 0.0;
            char[] token = new char[60];
            int handle = 0;
            int endLine = 20;
            double total = 0.0;
            for (int i = 0; i < 20; i++) {
                str = scanner.nextLine();
                token = str.toCharArray();
                end = str.length();
                if(token[end-1] == 'P') {
                    endLine--;
                    continue;
                }
                for (int j = 0; j < 60; j++) {
                    if (token[j] == ' ') {
                        handle++;
                        break;
                    }
                    subject[i][j] = token[handle++];
                }

                for (int j = 0; j < 60; j++) {
                    if (token[handle] == ' ') {
                        handle++;
                        break;
                    }
                    score[i][0] = Character.getNumericValue(token[handle++]);
                    handle++;
                    handle++;
                }

                for (int j = 0; j < 60; j++) {
                    if (handle == end) {
                        break;
                    }
                    grade[i][j] = token[handle++];
                }
                handle = 0;
            }

            for (int i = 0; i < endLine; i++) {
                if (new String(grade[i]).equals("P")) {
                    continue;
                }

                switch (new String(grade[i])) {
                    case "A+":
                        var = 4.5;
                        break;
                    case "A0":
                        var = 4.0;
                        break;
                    case "B+":
                        var = 3.5;
                        break;
                    case "B0":
                        var = 3.0;
                        break;
                    case "C+":
                        var = 2.5;
                        break;
                    case "C0":
                        var = 2.0;
                        break;
                    case "D+":
                        var = 1.5;
                        break;
                    case "D0":
                        var = 1.0;
                        break;
                    case "F":
                        var = 0.0;
                        break;
                }
                sum = sum + (var * score[i][0]);
                total += score[i][0];
            }


            System.out.printf("%.6f\n", sum/total);
        }

}
