package lang.object.tostring;

public class Test {
    public static void main(String[] args) {
        MethodTest.push();
        Dog dog = new Dog("dog1", 10);
        MethodTest methodTest = new MethodTest();

        methodTest.pull();

        testLocalMethod();
        ObjectPrinter.print(dog);


    }

    public void testMethod(){
        System.out.println("클래스 내에 메소드 출력");
    }


    private static void testLocalMethod(){
        System.out.println("크래스 내에 정적 메소드 출력");
    }


}

class MethodTest{
    static void push(){
        System.out.println("정적 메소드 출력");
    }

    void pull(){
        System.out.println("지역 메소드 출력");
    }
}
