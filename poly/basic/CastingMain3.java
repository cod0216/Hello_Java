package poly.basic;

public class CastingMain3 {
    //upcasting vs downcasting
    public static void main(String[] args) {

        Child child = new Child();
        Parent parent1 = (Parent) child; //업캐스팅은 (Parent)생략 가능
        Parent parent2 = child; //업 캐스팅 생략 가능

        parent1.parentMethod();
        parent2.parentMethod();
    }
}
