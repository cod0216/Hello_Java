package memory.static2;

public class DecoData {
    private int instanceValue;
    private static int staticValue;

    public static void staticCall(){
        // instanceValue++; 인스턴스 변수 접근, 컴파일 에러
        // instanceMethod(); 인스턴스 메서드 접근, 컴파일 에러
        staticValue++; //정적 변수 접근
        staticMethod(); // 정적 메서드 접근

    }
    public void  instanceCall() {
        instanceValue++;//인스턴스 변수
        instanceMethod();
        staticValue++;
        staticMethod();
    }
    private void instanceMethod() {
        System.out.println("instancValue = " + instanceValue);
    }
    private static void staticMethod(){
        System.out.println("staticValue = " + staticValue);
    }
}
