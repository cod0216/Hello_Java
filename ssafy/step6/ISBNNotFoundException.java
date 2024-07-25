package ssafy.step6;


// Exception을 상속받은 체크드 예외

public class ISBNNotFoundException extends Exception{
    private String isbn;

    public ISBNNotFoundException(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}
