package methodref;

public class Person {
    String name;

    public Person() {
        this("unkown");
    }

    public Person(String name) {
        this.name = name;
    }

    // 정적 매서드
    public static String greeting() {
        return "hello";
    }

    // 정적 매서드 + 매개변수
    public static String greetingWithName(String name) {
        return "hello " + name;
    }

    public String getName() {
        return name;
    }

    // 인스턴스 메서드
    public String introduce(){
        return "I am " + name;
    }

    // 인스턴스 메서드, 매개변수
    public String introduceWithNumber(int number){
        return "I am " + name + ", my number is " + number;
    }

}
