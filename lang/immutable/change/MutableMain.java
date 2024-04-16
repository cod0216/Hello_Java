package lang.immutable.change;

public class MutableMain {
    public static void main(String[] args) {
        MutableObj Obj = new MutableObj(10);
        Obj.add(20);
        System.out.println("Obj = " + Obj.getValue());
    }
}
