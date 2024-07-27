package ssafy.ws_10_3;


/**
 * <pre>
 * 잡지 클래스
 * - 도메인 클래스, 상속
 * - 멤버변수
 * - 메서드
 * - data type
 * - encapsulation
 * - 직렬화객체
 * - constructor, default constructor, construtor overloading
 * - this, this()
 * - java.lang.Object
 * - toString()
 * </pre>
 *
 * @author 최은창
 */

public class Magazine extends Book{
    /**도서 출판 년도*/
    private int year;
    /**도서 출판 월*/
    private int Month;

    public Magazine() {

    }

    /**
     * 모든 데이터 초기화 생성자
     * @param isbn 국제 도서 번호
     * @param title 제목
     * @param author 작가
     * @param publisher 출판사
     * @param price 가격
     * @param desc 책 요약
     * @param quantity 수량
     * @param year 출판 년도
     * @param month 출판 월
     */
    public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity, int year, int month) {
        super(isbn, title, author, publisher, price, desc, quantity);
        this.year = year;
        this.Month = month;
    }


    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }
    /**
     * @param year the year to set
     */
    public void setYear(int year) {
        this.year = year;
    }
    /**
     * @return the isbn
     */
    public int getMonth() {
        return Month;
    }
    /**
     * @param month the month to set
     */
    public void setMonth(int month) {
        Month = month;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(super.toString());
        builder.append(String.format("\t %-8d |\t %-8d ", year, Month));
        return builder.toString();
    }
}
