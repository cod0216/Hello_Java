package functional;

import java.util.List;

/*
    불변성(Immutable State) 지향
    데이터는 생성된 후 가능한 한 변경하지 않고, 변경이 필요한 경우 새로운 값을 생성해서 사용한다.
    가변 데이터 구조에서 발생할 수 있는 오류를 줄이고, 프로그램 예측 가능성을 높여준다.
    불변성은 데이터를 변경하지 않기 때문에 부수 효과와도 관련이 있다.
 */
public class ImmutableMain3 {
    public static void main(String[] args) {
        ImmutablePerson m1 = new ImmutablePerson("Kim", 10);
        ImmutablePerson m2 = new ImmutablePerson("Lee", 20);
        List<ImmutablePerson> originList = List.of(m1,m2);
        System.out.println("orginList = " + originList);
        List<ImmutablePerson> resultList = originList.stream()
                .map(p -> p.withAge(p.getAge() + 1)).toList();
        System.out.println("=== 실행 후 ===");
        System.out.println("originList = " + originList);
        System.out.println("resultList = " + resultList);
    }
}
