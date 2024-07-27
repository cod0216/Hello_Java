package ssafy.ws_10_3;

/**
 * <pre>
 * 중복 사용자 예외 클래스
 * -exception
 * </pre>
 *
 * @author 최은창
 */
public class DuplicateException extends Exception{

    /**식별위한 고유 속성 key*/
    private String key; // 질문하기

    /**기본 생성자 */
    public DuplicateException(){
        this("데이터가 중복되었습니다.");
    }
    public DuplicateException(String key){
        super(key + " 해당 데이터는 사용할 수 없습니다.");
        this.key = key;
    }

    /**
     * 고유 속성을 반환
     * @return 고유 속성
     */
    public String getKey(){
        return key;
    }
}
