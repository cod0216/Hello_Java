package lang.string.test;

public class TestString9 {
    public static void main(String[] args) {
        String email = "hello@example.com";

        String[] input = email.split("@");

        System.out.println("ID : " + input[0]);
        System.out.println("Domain : " + input[1]);

    }
}
