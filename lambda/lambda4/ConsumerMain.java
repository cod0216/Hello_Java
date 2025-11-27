package lambda.lambda4;

import java.util.function.Consumer;

public class ConsumerMain {


    public static void main(String[] args) {
        // 익명 클래스
        Consumer<String> consumerA = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        consumerA.accept("Hello World!");

        // 람다 사용
        Consumer<String> consumerB = s -> System.out.println(s);
        consumerB.accept("Hello World!");



    }

    //
}
