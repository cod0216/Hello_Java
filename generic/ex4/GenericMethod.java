package generic.ex4;

import java.sql.SQLOutput;

public class GenericMethod {

    public static Object objectMethod(Object ob) {
        System.out.println("object print : " + ob);
        return ob;
    }

    public static <T> T genericMethod(T t){
        System.out.println("generic print : " + t);
        return t;
    }

    public static <T extends Number> T numberMethod(T t){
        System.out.println("bound print : " + t);
        return t;
    }
}
