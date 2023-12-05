package scanner;

import java.util.Scanner; //java 라이브러리

public class Scanner1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("문자명을 입력하세요.");
        String str = scanner.nextLine(); // 입력을String으로 가져온다.
        System.out.println("입력한 문자열 : " + str );

        System.out.print("정수를 입력하세요. : ");
        int intValue = scanner.nextInt();
        System.out.println("입력한 정수 : " + intValue );

        System.out.print("실수를 입력하세요 : ");
        double doubleValue = scanner.nextDouble();
        System.out.println("입력한 실수 : " + doubleValue );
    }
}
