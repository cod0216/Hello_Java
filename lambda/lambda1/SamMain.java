package lambda.lambda1;

public class SamMain {
    public static void main(String[] args) {
         SamInterface samInterface = () -> {
            System.out.println("hello sam");
        };

        samInterface.run();

//        NotSamInterface notSamInterface = () -> {
//            System.out.println("hello notSam");
//        };
    }
}
