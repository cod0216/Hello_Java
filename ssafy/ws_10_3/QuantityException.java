package ssafy.ws_10_3;

/**
 * <pre>
 * 수량체크 사용자 예외 클래스
 * -exception
 * </pre>
 *
 * @author 최은창
 */
public class QuantityException extends Exception{

    /** 기본 생성자*/
    public QuantityException()  {
        super("수량이 부족합니다.");
    }
}
