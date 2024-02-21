package TIL;
import java.util.Scanner;

public class J11659 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = scanner.nextInt();
        int n = scanner.nextInt();
        int[] array = new int[index];
        int[] array2 = new int[index+1];
        int sum = 0;
        int result = 0;
        for(int i = 0; i <array.length; i++) {
            array[i] = scanner.nextInt();
            sum += array[i];
            array2[i+1] = sum;
        }

        for(int i = 0; i < n; i++){
            int startNum = scanner.nextInt();
            int endNum = scanner.nextInt();
            result = array2[endNum] - array2[startNum-1];
            System.out.println(result);
            result = 0;
        }

    }
}

