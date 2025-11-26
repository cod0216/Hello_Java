package lambda.ex1;

public class M2After {
    public static void print1(){
        System.out.println("무게 : 10kg" );
    }

    public static void main(String[] args) {
        Print p = (a, str) -> System.out.println("무게 : " + a + str);
        p.call(10,"kg");
        p.call(50,"kg");
        p.call(200,"g");
        p.call(40,"g");
    }

    @FunctionalInterface
    interface Print{
        void call(int a, String str);
    }

}
