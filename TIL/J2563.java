package TIL;

import java.util.Scanner;

public class J2563 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int figureCount = scanner.nextInt();
            int width = 0;
            int lethal = 0;
            int sum = 0;


            int[][] totalFigure = new int[101][101];
            for(int t = 0; t < figureCount; t++){
                width = scanner.nextInt();
                lethal = scanner.nextInt();
                for(int i = width; i < width + 10; i++)
                    for(int j = lethal; j < lethal+10; j++)
                        totalFigure[i][j] = 1;
            }
            System.out.println(sum);
        }
    /*
package TIL_2563;

import java.util.Scanner;

public class FigureMain {
    public static void main(String[] args) {
        Calculate calculate = new Calculate();
        Scanner scanner = new Scanner(System.in);
        int figureCount = scanner.nextInt();
        scanner.nextLine();
        int result = 100*figureCount;
        Figure[] figures = new Figure[figureCount];
        for (int i = 0; i < figureCount; i++) {
            figures[i] = new Figure();
            int valueA = scanner.nextInt();
            int valueB = scanner.nextInt();
            if (valueA >= 90 || valueB >= 90)
                return;
            figures[i].setFigure(valueA, valueB);
        }
        for (int i = 0; i < figureCount; i++) {
            if(i == figureCount-1) {
                calculate.whatBig(figures[i],figures[0]);
                System.out.println( i + "번 째 figure_callA : " + calculate.callA() + ", figure_callB : " + calculate.callB());
                result -= calculate.callA()*calculate.callB();
                System.out.println(result);
                break;
            }

            calculate.whatBig(figures[i], figures[i+1]);
            System.out.println( i + "번 째 figure_callA : " + calculate.callA() + ", figure_callB : " + calculate.callB());
            result -= calculate.callA()*calculate.callB();
            System.out.println(result);
        }

        System.out.println(result);
    }
}
*/
}
