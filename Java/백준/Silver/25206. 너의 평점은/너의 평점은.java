import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double sum = 0.0;
        double total = 0.0;

        for (int i = 0; i < 20; i++) {
            String subject = sc.next();
            double credit = sc.nextDouble();
            String grade = sc.next();

            if (grade.equals("P")) continue;

            double point = 0.0;
            switch (grade) {
                case "A+": point = 4.5; break;
                case "A0": point = 4.0; break;
                case "B+": point = 3.5; break;
                case "B0": point = 3.0; break;
                case "C+": point = 2.5; break;
                case "C0": point = 2.0; break;
                case "D+": point = 1.5; break;
                case "D0": point = 1.0; break;
                case "F":  point = 0.0; break;
            }

            sum += credit * point;
            total += credit;
        }

        System.out.printf("%.6f\n", sum / total);
    }
}
