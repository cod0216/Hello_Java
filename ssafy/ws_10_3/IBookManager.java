package ssafy.ws_10_3;

/**
 * <pre>
 * 도서 관리 기능에 일반화 인터페이스
 * - method overloading
 * </pre>
 *
 * @author 최은창
 */
public interface IBookManager {
    /**
     * 회원 등록
     * @param book 도서
     * @throws DuplicateException 아이디 중복시 예외
     */
    void add(Book book) throws DuplicateException;
    /**
     * 회원 삭제
     * @param isbn 국제 도서 번호
     * @throws ISBNNotFoundException isbn 미존재시 예외
     */
    void remove(String isbn)throws ISBNNotFoundException;
    /**
     * 전체 도서
     * @return 도서 배열
     * @throws NotFoundException 미존재시 예외
     */
    Book[] getList() throws NotFoundException;

    /**
     * 도서 번호와 일치한 책 조회
     * @param isbn 국제 도서 번호
     * @return isbn이 일치한 책
     * @throws ISBNNotFoundException isbn 미존재시 예외
     */
    Book searchByIsbn(String isbn) throws ISBNNotFoundException;
    /**
     * 제목이 포함하는 해당 도서 전체 조회
     * @param title 제목
     * @return 제목 포함하는 도서 Array
     * @throws NotFoundException 미존재시 예외
     */
    Book[] searchByTitle(String title) throws NotFoundException;
    /**
     * 전체 도서 중 잡지만 조회
     * @return 잡지 Array
     * @throws NotFoundException 미존재시 예외
     */
    Magazine[] getMagazines() throws NotFoundException;
    /**
     * 전체 도서 중 도서만 조회
     * @return 도서 Array
     * @throws NotFoundException 미존재시 예외
     */
    Book[] getBook()throws NotFoundException;
    /**
     * 전체 가격 합산
     * @return 전체 가격
     */
    int getTotalPrice();

     /** 평균값 계산
     * @return 평균 가격
     */
    double getPriceAvg();

    /**
     * 국제 도서 번화에서 입력한 수량에 맞게 도서 판매
     * @param isbn 국제 도서 번호
     * @param quantity 수량
     * @throws QuantityException 가지고 있는 수량보다 많을 시 예외
     * @throws ISBNNotFoundException ISBN 미존재시 예외
     */
    void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;

    /**
     * 국제 도서 번화에서 입력한 수량에 맞게 도서 구매
     * @param isbn 국제 도서 번호
     * @param quantity 수량
     * @throws ISBNNotFoundException ISBN 미존재시 예외
     */
    void buy(String isbn, int quantity) throws ISBNNotFoundException;

    /**
     * 입력한 도서 리스트를 파일로 저장
     */
    void saveDate();


}
