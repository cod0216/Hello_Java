package lang.wrapper.test;

public class WrapperTest2 {
    public static void main(String[] args) {
        String[] array = {"1.5", "2.5", "3.0"};

        double value1 = Double.valueOf(array[0]);
        double value2 = Double.valueOf(array[1]);
        double value3 = Double.valueOf(array[2]);

        double sum = value1 + value2 + value3;

        System.out.println("sum = " + sum);

    }

}
