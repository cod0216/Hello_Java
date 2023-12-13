package oop1.ex;

import java.util.Scanner;

public class RectangleOopMain {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        Scanner scanner = new Scanner(System.in);

        System.out.print("가로 길이 입력하세요 : ");
        rectangle.width = scanner.nextInt();
        System.out.print("세로 길이 입력하세요 : ");
        rectangle.height = scanner.nextInt();

        int area = rectangle.calculateArea();
        System.out.println("넓이 : " + area);

        int perimeter = rectangle.calculatePermiter();
        System.out.println("둘레 길이 : " + perimeter);

        boolean square = rectangle.isSquare();
        System.out.println("정사각형 여부 : " + square);
    }

}
