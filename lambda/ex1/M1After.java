package lambda.ex1;

public class M1After {
    public static void greeting(String str) {
        System.out.println("=== 시작 ===");
        System.out.println("Good " + str);
        System.out.println("=== 끝 ===");
    }

    public static void main(String[] args) {
        greeting("Moring");
        greeting("Afternoon");
        greeting("Evening");
    }
}
