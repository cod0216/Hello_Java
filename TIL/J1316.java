package TIL;

import java.util.Scanner;



//1316
public class J1316 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();
        String[] str = new String[n];
        char[][] Arr = new char[n][];

        for(int i = 0; i < n; i++) {
            str[i] = scanner.nextLine();
            Arr[i] = str[i].toCharArray();
        }
        int index = 0;
        int[][] word = new int[n][26];
        int[] cnt = new int[n];
        int total_cnt = 0;

        for(int i = 0 ; i < n; i++) {
            for (int j = 0; j < Arr[i].length; j++) {
                if (j >= Arr[i].length - 1) {
                    index = Arr[i][j] - 'a';
                    if (word[i][index] != 0) {
                        cnt[i] = 1;
                    }
                    continue;
                }

                if (Arr[i][j] != Arr[i][j + 1]) {
                    index = Arr[i][j] - 'a';
                    if (word[i][index] != 0) {
                        cnt[i] = 1;
                        continue;
                    }
                    word[i][index]++;
                }
            }
        }


        for(int i = 0; i <n; i++){
            if (cnt[i] > 0)
                continue;
            total_cnt++;
        }
        System.out.println(total_cnt);
    }
}



// for (int i = 0; i < str.length(); i++) {
//            if (i >= str.length()-1) {
//                index = Arr[i] - 'a';
//                if (word[index] != 0) {
//                    cnt = 1;
//                }
//                break;
//            }
//            if (Arr[i] != Arr[i + 1]) {
//                index = Arr[i] - 'a';
//                System.out.println(index);
//                if (word[index] != 0) {
//                    cnt = 1;
//                    break;
//                }
//                word[index]++;
//            }
//        }

