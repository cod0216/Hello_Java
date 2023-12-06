package array.ex;

import java.util.Scanner;

public class ArrayEx8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("학생의 수를 입력하세요 : ");
        int student = scanner.nextInt();

        int[][] score = new int[student][3];
        int[] total = new int[4];

        String[] subjects = {"국어", "영어", "수학"};

        for (int i = 0 ; i < score.length; i++) {
            System.out.println((i+1) + "번 학생의 성적을 입력하세요");
            for (int j = 0; j < 3; j++) {
                System.out.print(subjects[j] + "점수 : ");
                score[i][j] = scanner.nextInt();
            }
            System.out.println();
        }

        for(int i = 0; i < score.length; i++) {
            System.out.println((i+1) + "번 학생 점수");
            for (int j = 0; j < 3; j++) {
                System.out.print(subjects[j] + "점수 : " + score[i][j] + " ");
                total[i] += score[i][j];
            }
            System.out.println();
            System.out.print("총점 : " + total[i] + " 평균 : " + (double)total[i] / subjects.length);
            System.out.println();
            System.out.println();
        }
    }
}
