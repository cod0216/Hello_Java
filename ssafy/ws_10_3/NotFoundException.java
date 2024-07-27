package ssafy.ws_10_3;


/**
 * <pre>
 * 데이터 없는경우 사용자 예외 클래스
 * -exception
 * </pre>
 *
 * @author 최은창
 */

public class NotFoundException extends Exception{
    /**기본 생성자 */
    public NotFoundException() {
        super("데이터가 존재하지 않습니다.");
    }
}
