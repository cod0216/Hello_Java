package ssafy.ws_10_3;

/**
 * <pre>
 * 테스트 클래스
 * - 자바 어플리케이션 시작 메서드
 * - static
 * </pre>
 *
 * @author 최은창
 */
public class BookTest {
    public static void main(String[] args) {
        IBookManager manager = BookManagerImpl.getInstance();

        try {
            manager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10));
            manager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20));
            manager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 30));
            manager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1));
        }catch (DuplicateException e){
            System.out.println(e);
        }

        manager.saveDate();

    }
}
