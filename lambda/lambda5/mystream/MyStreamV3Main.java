package lambda.lambda5.mystream;

import java.util.List;

public class MyStreamV3Main {
    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Apple", 100),
                new Student("Banana", 80),
                new Student("Berry", 50),
                new Student("Tomato", 40)
        );

        List<String> result1 = ex1(students);
        System.out.println("result = " + result1);

        List<String> result2 = ex2(students);
        System.out.println("result2 = " + result2);
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
