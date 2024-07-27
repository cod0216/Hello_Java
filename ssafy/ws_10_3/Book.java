package ssafy.ws_10_3;

import java.io.Serializable;

/**
 * <pre>
 * 도서 클래스
 * - 도메인 클래스, 추상화
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


//위에서 this와 this() 쓴 이유 묻기
public class Book implements Serializable {
    /**국제 표준 도서 번호*/
    private String isbn;
    /**도서 제목*/
    private String title;
    /**도서 작가*/
    private String author;
    /**도서 출판사*/
    private String publisher;
    /**도서 가격*/
    private int price;
    /**도서 요약*/
    private String desc;
    /**도서 수량*/
    private int quantity;



    public Book() {
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
     */
    public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
        this.quantity = quantity;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }
    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }
    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }
    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }
    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }
    /**
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }
    /**
     * @param publisher the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    /**
     * @return the price
     */
    public int getPrice() {
        return price;
    }
    /**
     * @param price the price to set
     */
    public void setPrice(int price) {
        this.price = price;
    }
    /**
     * @return the desc
     */
    public String getDesc() {
        return desc;
    }
    /**
     * @param desc the desc to set
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }
    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(String.format("%-8s \t | %-8s \t | %-8s \t | %-8s \t | %-8d \t | %-8s \t | %-8d", isbn, title, author, publisher, price, desc, quantity));
        return builder.toString();
    }
}
