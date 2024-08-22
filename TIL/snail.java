package TIL;

public class snail {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15, 16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48, 49, 50},
                {51, 52, 53, 54, 55, 56, 57, 58, 59, 60},
                {61, 62, 63, 64, 65, 66, 67, 68, 69, 70},
                {71, 72, 73, 74, 75, 76, 77, 78, 79, 80},
                {81, 82, 83, 84, 85, 86, 87, 88, 89, 90},
                {91, 92, 93, 94, 95, 96, 97, 98, 99, 100}, };

        int print = 10;
        int bottom = 0;
        int right = -1;
        int top = 1;
        int k = 1;
        int n = 0;


        for(int i = 0; i < 10; i ++){
            for(int j = 0; j<print; j++){
                right += top;
                System.out.print(arr[bottom][right] + " ");
                k++;
            }
            System.out.println();
            print--;
            for(int j = 0; j<print; j++){
                bottom += top;
                System.out.print(arr[bottom][right] + " ");
                k++;
            }
            top *= -1;
            System.out.println();
        }


        for (int i = 0 ; i < 10; i++){
            for(int j = 0 ; j <10; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
