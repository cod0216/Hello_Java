package lambda.lambda4;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierMain {
    public static void main(String[] args) {
        Supplier<Integer> supplierA = new Supplier<Integer>() {
            @Override
            public Integer get() {
                return new Random().nextInt(10);
            }
        };

        System.out.println("supplierA.get() = " + supplierA.get());

        Supplier<Integer> supplierB = () -> new Random().nextInt(10);
        System.out.println("supplierB.get() = " + supplierB.get());
    }
}
