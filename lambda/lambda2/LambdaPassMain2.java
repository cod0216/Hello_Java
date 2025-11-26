package lambda.lambda2;


import lambda.MyFunction;

// 1. 람다를 메서드(함수)에 전달하기
public class LambdaPassMain2 {
    public static void main(String[] args) {

        System.out.println("변수를 통해 전달");
        calculate((a,b) -> a+b);
        calculate((a,b) -> a-b);

    }

    static void calculate(MyFunction function) {
        int a = 1;
        int b = 2;

        System.out.println("계산 시작");
        int result = function.apply(a,b);
        System.out.println("계산 결과: = " + result);

    }



}
