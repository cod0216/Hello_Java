import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long f = sc.nextLong();

        double circumference = 2 * Math.PI * Math.sqrt(f / Math.PI);

        double result = Math.ceil(circumference * 10) / 10.0;

        System.out.printf("%.1f\n", result);
    }
}