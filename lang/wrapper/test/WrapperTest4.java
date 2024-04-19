package lang.wrapper.test;

public class WrapperTest4 {
    public static void main(String[] args) {
        String str = "100";

        Integer strInteger = Integer.valueOf(str);

        System.out.println("strInteger = " + strInteger);

        int strInt = strInteger;
        System.out.println("strInt = " + strInt);

        strInteger = strInt;
        System.out.println("strInteger = " + strInteger);





    }

}
