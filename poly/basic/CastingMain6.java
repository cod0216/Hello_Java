package poly.basic;

public class CastingMain6 {

    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);
        Parent parent2 = new Child();
        call(parent2);
    }
    private static void call(Parent parent) {
        parent.parentMethod();
        //Child 인스턴스인 경우 ChildMethod()실행
        if(parent instanceof Child child) {
            System.out.println("Child 인스턴스 맞음");
            child.childMethod();
        } else {
            System.out.println("Child 인스턴스 아님");
        }
    }
}
