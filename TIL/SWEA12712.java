package TIL;

import java.io.*;

public class SWEA12712 {
    static int[][] arr;

    static int max = 0;
    public static void main(String[] args) throws IOException{

        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));

        String[] input = buffer.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[n*3][n*3];
        m = m-1;

        for(int i = 0 ; i<n; i++){
            input = buffer.readLine().split(" ");
            for(int j = 0; j<n; j++){
                arr[i+n][j+n] = Integer.parseInt(input[j]);
            }
        }

        for(int i= n; i<= n*2; i++){
            for(int j = n; j<=n*2; j++){
                int num1 = plusSpray(i, j, m);
                int num2 = xSpray(i, j, m);
//                System.out.println("num1 = " + num1 + ", num2 = " + num2);
                if(max < Math.max(num1, num2))
                    max = Math.max(num1, num2);
            }
        }
        System.out.println(max);
    }

    public static int plusSpray(int x, int y, int range){
        int result = 0;

        for(int i = y-range; i <= y+range; i++){
            result += arr[x][i];
        }
        for(int i = x-range; i <= x+range; i++){
            result += arr[i][y];
        }
        return result-arr[x][y];
    }


    public static int xSpray(int x, int y, int range) {
        int result = 0;

        // 왼쪽 위에서 오른쪽 아래 대각선
        for (int i = -range; i <= range; i++) {
            if (x + i >= 0 && x + i < arr.length && y + i >= 0 && y + i < arr.length) {
                result += arr[x + i][y + i];
            }
        }

        // 오른쪽 위에서 왼쪽 아래 대각선
        for (int i = -range; i <= range; i++) {
            if (x + i >= 0 && x + i < arr.length && y - i >= 0 && y - i < arr.length) {
                result += arr[x + i][y - i];
            }
        }

        return result-arr[x][y];
    }
















//    ------------------------------------------
//    public static void main(String[] args) throws IOException {
//        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] input = buffer.readLine().split(" ");
//        int n = Integer.parseInt(input[0]);
//        int m = Integer.parseInt(input[1]);
//
//        int[][] arr = new int[n][n];
//
//        int mid = n / 2;
//
//        for (int i = 0; i < n; i++) {
//            input = buffer.readLine().split(" ");
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = Integer.parseInt(input[j]);
//            }
//        }
//        if (mid < m - 1) {
//            m = mid + 1;
//        }
//        int num1 = plusSpray(arr, mid, m);
//        int num2 = xSpray(arr, mid, m);
//
//        int max = Math.max(num1, num2);
//        System.out.println(max);
//    }
//
//    private static int xSpray(int[][] arr, int mid, int range) {
//        range -=1;
//        int result = 0;
//        for(int i = mid-range; i<= mid +range; i++){
//            result +=arr[i][i];
//        }
//        for(int i = mid-range; i<= mid +range; i++){
//            result +=arr[arr.length-1-i][i];
//        }
//        result-=arr[mid][mid];
//        return result;
//    }
//
//
//    public static int plusSpray(int[][] arr, int mid, int range){
//        range -=1;
//
//        int result = 0;
//        for(int i = mid-range; i<= mid +range; i++){
//            result +=arr[mid][i];
//        }
//        for(int i = mid-range; i<= mid +range; i++) {
//            result +=arr[i][mid];
//        }
//        result-=arr[mid][mid];
//        return result;
//    }

}
