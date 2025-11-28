package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamLoopMain {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<String> result = MyStreamV3.of(students)
                .filter(n -> n.getScore() >= 80)
                .map(s -> s.getName())
                .toList();

        // 외부 반복
        for (String s : result) {
            System.out.println("name : " + s);
        }
        MyStreamV3.of(students)
                .filter(n -> n.getScore() >= 80)
                .map(s -> s.getName().toUpperCase())
                .forEach(s-> System.out.println("name : " + s));

    }

    private static List<String> ex2(List<Student> students) {
        return MyStreamV3.of(students)
                .filter(n -> n.getScore() >= 80)
                .map(s -> s.getName().toUpperCase())
                .toList();
    }

    private static List<String> ex1(List<Student> students) {
        return MyStreamV3.of(students)
                .filter(student -> student.getScore() >= 80)
                .map( s-> s.getName())
                .toList();
    }




}
