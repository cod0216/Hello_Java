package enumeration.ex3;
import java.util.*;
public class EnumMethodMain {
    public static void main(String[] args) {
        Grade[] values = Grade.values();
        System.out.println("values = " + Arrays.toString(values));

        System.out.println();

        for(Grade value : values){
            System.out.println("name = " + value.name() + ", ordinal = " + value.ordinal());
        }

        System.out.println();

        String input = "GOLD";
        Grade gold = Grade.valueOf(input);
        System.out.println("gold = " + gold);
    }
}
