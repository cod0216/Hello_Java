package lambda.lambda1;

public class LambdaSimple4 {

    public static void main(String[] args) {
        MyCall call1 = (int value) -> value*2; // 기본
        MyCall call2 = (value) -> value*2; // 타입 추론
        MyCall call3 = value -> value*2; // 매개 변수가 1개, () 생략 가능
        int call = call3.call(3);
        System.out.println("call = " + call);
    }

    interface MyCall{
        int call(int Value);
    }
}
