package lang.string.test;

public class TestString10 {
    public static void main(String[] args) {
        String fruits = "apple, banana, mango";

        String[] input = fruits.split(", ");

        for (String s : input) {
            System.out.println(s);
        }
        String joinedString = "";

        System.out.println("joinedString = " + joinedString.join("->", input));

    }
}
