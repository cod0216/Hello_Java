package ssafy.step6;

public interface IBookManager {

    void add(Book book);
    void remove(String isbn)throws ISBNNotFoundException;
    Book[] getList();
    Book searchByIsbn(String isbn) throws ISBNNotFoundException;
    Book[] searchByTitle(String title);
    Magazine[] getMagazines();
    Book[] getBook();
    int getTotalPrice();
    double getPriceAvg();

    void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
    void buy(String isbn, int quantity) throws ISBNNotFoundException;


}
