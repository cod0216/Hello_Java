package ssafy.step6;


// Magazine 타입의 클래스
// Book 클래스를 상속받음
// 멤버변수: year, month
public class Magazine extends Book {
    private int year;
    private int month;

    //    기본 생성자
    public Magazine() {
    }

    // 오버로드된 생성자
    //isbn, 제목, 작가, 출판사, 가격, 설명, 수량 값을 super에 넘기고 year, month는 Magazin 멤버 변수에 값을 넣는다.
    public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity, int year, int month) {
        super(isbn, title, author, publisher, price, desc, quantity);
        this.year = year;
        this.month = month;
    }

    //getter setter
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
