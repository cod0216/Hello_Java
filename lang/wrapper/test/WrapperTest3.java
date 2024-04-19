package lang.wrapper.test;

public class WrapperTest3 {
    public static void main(String[] args) {
        String str = "100";

        Integer strInteger = Integer.valueOf(str);
        System.out.println("strInteger = " + strInteger);

        int strInt = strInteger.intValue();
        System.out.println("strInt = " + strInt);

        Integer strInteger1 = Integer.valueOf(strInt);
        System.out.println("strInteger1 = " + strInteger1);




    }

}
