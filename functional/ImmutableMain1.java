package functional;

/*
    불변성(Immutable State) 지향
    데이터는 생성된 후 가능한 한 변경하지 않고, 변경이 필요한 경우 새로운 값을 생성해서 사용한다.
    가변 데이터 구조에서 발생할 수 있는 오류를 줄이고, 프로그램 예측 가능성을 높여준다.
    불변성은 데이터를 변경하지 않기 때문에 부수 효과와도 관련이 있다.
 */
public class ImmutableMain1 {
    public static void main(String[] args) {
        MutablePerson m1 = new MutablePerson("Kim", 10);
        MutablePerson m2 = m1;
        m2.setAge(11);
        System.out.println("m1 = " + m1);
        System.out.println("m2 = " + m2);

        ImmutablePerson i1 = new ImmutablePerson("Lee", 20);
        ImmutablePerson i2 = i1.withAge(21); // i2는 새로운 객체
        System.out.println("i1 = " + i1); // 20
        System.out.println("i2 = " + i2); // 21
    }
}
