package TIL;

import java.util.Scanner;

public class J2566 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = new int[9][9];
        int maxNumber = -1;
        int rowIndex = 0;
        int colIndex = 0;

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr[i][j] = scanner.nextInt();
                if(arr[i][j] < 0 || arr[i][j] > 100)
                    return;
                if(maxNumber < arr[i][j]) {
                    maxNumber = arr[i][j];
                    rowIndex = i+1;
                    colIndex = j+1;
                }
            }
        }
        System.out.println(maxNumber);
        System.out.println(rowIndex + " " + colIndex);
    }
}