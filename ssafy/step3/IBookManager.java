package ssafy.step3;

public interface IBookManager {

    void add(Book book);
    void remove(String isbn);
    Book[] getList();
    Book searchByIsbn(String isbn);
    Book[] searchByTitle(String title);
    Magazine[] getMagazines();
    Book[] getBook();
    int getTotalPrice();
    double getPriceAvg();


}
