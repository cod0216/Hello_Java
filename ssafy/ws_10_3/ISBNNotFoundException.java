package ssafy.ws_10_3;


/**
 * <pre>
 * ISBN 중복 사용자 예외 클래스
 * -exception
 * </pre>
 *
 * @author 최은창
 */

public class ISBNNotFoundException extends Exception{
    /**식별위한 고유 속성 key*/
    private String isbn;

    /**기본 생성자 */
    public ISBNNotFoundException(){
        System.out.println("데이터가 중복되었습니다.");
    }
    /** 고유번호를 받아 생성하는 생성자 */
    public ISBNNotFoundException(String isbn) {
        this.isbn = isbn;
    }

    /**
     * isbn을 반환
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }
}
