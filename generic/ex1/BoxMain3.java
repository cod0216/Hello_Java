package generic.ex1;

public class BoxMain3 {

    public static void main(String[] args) {

        GenericBox<Integer> integerBox = new GenericBox<Integer>();
//        GenericBox<Integer> integerBox = new GenericBox<>(); -> 타입 추론
        integerBox.set(10);
        Integer integer = integerBox.get();
        System.out.println("integer = " + integer);

        GenericBox<String> stringBox = new GenericBox<String>();
//        GenericBox<String> stringBox = new GenericBox<>() -> 타입 추론
        stringBox.set("hello");
        String string = stringBox.get();
        System.out.println("string = " + string);

        GenericBox<Double> doubleBox = new GenericBox<Double>();
//        GenericBox<Double> doubleBox = new GenericBox<>() -> 타입 추론
        doubleBox.set(10.5);
        Double doubleValue = doubleBox.get();
        System.out.println("doubleValue = " + doubleValue);
    }
}
