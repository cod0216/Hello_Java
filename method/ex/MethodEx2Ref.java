package method.ex;

public class MethodEx2Ref {
    public static void main(String[] args) {
    String message = "Hello World!";
    printMassage(message, 5);
    }
    public static void printMassage(String messgae, int times){
        for (int i = 0; i < times; i++) {
            System.out.println(messgae);
        }
    }
}
