package lambda.ex2;

public class BuildGreeterExample {

    // 고차 함수, greeting 문자열을 받아. "새로운 함수를 "반환
    public static StringFunction buildGreeter(String greeting){
        // 코드 작성
        return name -> greeting + ", " +name;
    }

    public static void main(String[] args) {
        StringFunction stringFunction = buildGreeter("hello");
        System.out.println(stringFunction.apply("java"));
        stringFunction = buildGreeter("hi");
        System.out.println(stringFunction.apply("lambda"));
    }
}
