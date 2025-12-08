package functional;

import java.util.ArrayList;
import java.util.List;

/*
    선언형(Declarative) 접근
    어떻게가 아닌 무어을 계산할지 기술한다.
    복잡한 제어 구조나 상태 관리를 함수의 합성과 함수 호출로 대체하여 간결하고 가독성 높은 코드를 작성한다.
 */
public class DeclarativeMain {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // 명령형: for문과 조건 검사로 처리
        List<Integer> result1 = new ArrayList<>();
        for (Integer number : numbers) {
            if(number % 2 == 0) // 짝수인지 확인
                result1.add(number * number); // 제곱한 값을 추가
        }
        System.out.println("Imperaive Result = " + result1);

        // 선언형: 스트림 API로 처리
        List<Integer> result2 = numbers.stream()
                .filter(n -> n % 2==0) // 짝수 필터링
                .map(n -> n*n)          // 제곱
                .toList();
        System.out.println("Declarative Result = " + result2);
    }
}
