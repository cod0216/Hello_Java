package ssafy.step3;

public class BookManagerImpl implements IBookManager {
    static int MAX_SIZE= 100;
    Book[] books = new Book[MAX_SIZE];
    int size;
    static IBookManager instance = new BookManagerImpl();

    public BookManagerImpl() {
    }

    public BookManagerImpl(Book[] books, int size) {
        this.books = books;
        this.size = size;
    }

    public static IBookManager getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) {
        books[size++] = book;
        System.out.println(book.getTitle()+"책이 등록되었습니다");
    }

    @Override
    public void remove(String isbn) {
        int index = 0;
        for(int i = 0; i < size; i++){
            if(books[i].getIsbn().equals(isbn)){
                books[i] = null;
                index=i;
            }
        }
        for(int i = index; i <size-1; i++){
            books[i] = books[i+1];
        }
        size--;
    }

    @Override
    public Book[] getList() {
        Book[] dummy = new Book[size];
        int index = 0;
        for(int i = 0 ; i< size; i++){
            dummy[i] = books[i];
            index++;
        }
        Book[] result = new Book[index];
        for(int i = 0 ; i<index; i++){
            result[i]= dummy[i];
        }

        return result;
    }

    @Override
    public Book searchByIsbn(String isbn) {
        for(int i = 0; i < size; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        System.out.println(isbn+"정보의 책을 찾지 못했습니다.");
        return null;
    }

    @Override
    public Book[] searchByTitle(String title) {
        Book[] dummy = new Book[size];
        int index=0;
        for(int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(title)) {
                dummy[i] = books[i];
                index++;
            }
        }
        Book[] result = new Book[index];
        if(index != 0){
            for(int i = 0; i < index; i++){
                result[i] = dummy[i];
            }
            return result;
        }
        else {
            System.out.println(title + "책을 찾지 못했습니다.");
            return null;
        }
    }

    @Override
    public Magazine[] getMagazines() {
        Magazine[] magazines = new Magazine[size];
        int index = 0;
        for(int i = 0; i < size; i++) {
            if (books[i] instanceof Magazine){
                magazines[index++] = (Magazine) books[i];
            }
        }
        Magazine[] result = new Magazine[index];
        for(int i = 0; i < index; i++){
            result[i] = magazines[i];
        }
        return result;
    }

    @Override
    public Book[] getBook() {

        Book[] books1 = new Book[size];
        int index = 0;
        for(int i = 0; i < size; i++) {
            if (books[i] instanceof Magazine) {
            }else if( books[i] instanceof Book){
                books1[i] = books[i];
                index++;
            }
        }
        Book[] result = new Book[index];
        for(int i = 0; i < index; i++){
            result[i] = books1[i];
        }
        return result;
    }

    @Override
    public int getTotalPrice() {
        int totalPrice = 0;
        for(int i = 0; i < size; i ++){
            totalPrice += books[i].getPrice();
        }

        return totalPrice;
    }

    @Override
    public double getPriceAvg() {
        int totalPrice = 0;
        for(int i = 0; i < size; i ++){
            totalPrice += books[i].getPrice();
        }

        return (double) totalPrice/size;
    }
}
