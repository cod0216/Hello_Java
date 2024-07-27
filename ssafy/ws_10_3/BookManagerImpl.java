package ssafy.ws_10_3;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * 사용기술:
 * - singleton pattern,
 * - interface,
 * - collection, generic
 * - collection => to array
 * - exception, user exception, throws, throw new Abc()
 * - instanceof
 * - object type casting
 * - dynamic binding
 * - @Override
 * - Overriding
 * - method overloading
 * -try, catch
 * </pre>
 *
 * @author 최은창
 */

public class BookManagerImpl implements IBookManager {
    /** 인터페이스 타입의 멤버변수 선언 및 객체 생성 할당 초기화 */
    private static final IBookManager instance = new BookManagerImpl();
    /** 책의 정보를 위한 Collection 자료 저장 구조*/
    List<Book> list = new ArrayList<>();


    /** 기본생성자 : 외부에서 객체 생성 불가*/
    private BookManagerImpl() {
        loadData();
    }

    /**
     * 생성된 인스턴스를 반환하는 메서드
     *
     * @return 인터페이스타입 반환
     */
    static public IBookManager getInstance() {
        return instance;
    }

    @Override
    public void add(Book book) throws DuplicateException{
            for(int i = 0 ; i< list.size(); i++) {
                if (list.get(i).getIsbn().equals(book.getIsbn())) {
                    throw new DuplicateException();
                }
            }
            list.add(book);
            System.out.println(book.getTitle()+"책이 등록되었습니다");
    }

    @Override
    public void remove(String isbn)throws ISBNNotFoundException {
        boolean check = false;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getIsbn().equals(isbn)){
                list.remove(i);
                System.out.println(isbn +"번 책이 지워졌습니다.");
                check= true;
            }
        }
        if(!check){
            throw new ISBNNotFoundException(isbn);
        }
    }

    @Override
    public Book[] getList() throws NotFoundException {
        if(list.size()<1){
            throw new NotFoundException();
        }
        return list.toArray(new Book[list.size()]);
    }

    @Override
    public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsbn().equals(isbn)) {
                return list.get(i);
            }
        }
        throw new ISBNNotFoundException(isbn);
    }

    @Override
    public Book[] searchByTitle(String title) throws NotFoundException {
        List<Book> books = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().contains(title)) {
                books.add(list.get(i));
            }
        }
        if(books.size()>0) return books.toArray(new Book[books.size()]);
        else throw new NotFoundException();
    }

    @Override
    public Magazine[] getMagazines() throws NotFoundException{
        List<Magazine> magazines = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Magazine){
                magazines.add((Magazine) list.get(i));
            }
        }
        if(magazines.size()>0) return magazines.toArray(new Magazine[magazines.size()]);
        else throw new NotFoundException();
    }

    @Override
    public Book[] getBook() throws NotFoundException {

        List<Book> books = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Magazine) {
            } else if (list.get(i) instanceof Book) {
                books.add(list.get(i));
            }
        }
        if(books.size() >0) return books.toArray(new Book[books.size()]);
        else throw new NotFoundException();
    }

    @Override
    public int getTotalPrice() {
        int totalPrice = 0;
        for(int i = 0; i < list.size(); i ++){
            totalPrice += list.get(i).getPrice();
        }

        return totalPrice;
    }

    @Override
    public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
        Book book = null;
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i).getIsbn().equals(isbn))
                book= list.get(i);
        }

        if(book == null){
            throw new ISBNNotFoundException(isbn);
        }
        else if(book.getQuantity() < quantity) throw new QuantityException();
        else{
            book.setQuantity((book.getQuantity() - quantity));
        }
    }

    @Override
    public void buy(String isbn, int quantity) throws ISBNNotFoundException {
        int index = -1;
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i).getIsbn().equals(isbn))
                index=i;
            break;
        }

        if(index == -1){
            throw new ISBNNotFoundException(isbn);
        }
        else{
            list.get(index).setQuantity(list.get(index).getQuantity() + quantity);
        }
    }

    @Override
    public void saveDate() {
        try (FileOutputStream fileOut = new FileOutputStream("./book.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
            out.writeObject(list);
            loadData();
        } catch (Exception e) {
            System.out.println("저장하기를 실패하였습니다.");
        }
    }

    /**
     * save()메서드에서 저장된 파일을 불러오는 메서드
     */
    private void loadData() {
        try(FileInputStream fileIn = new FileInputStream("./book.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
        ){
            System.out.println("********************불러온 도서 전체 목록********************");
            List<Book> list = (List<Book>) in.readObject();
            for(Book book : list){
                System.out.println(book.toString());
            }

        }catch (Exception e){
            System.out.println("등록된 도서가 없습니다.");
        }
    }

    //리스트에서 모든 데이터의 가격을 합산하고 리스트의 크기를 나눠 평균값을 계산 후 반환한다.
    @Override
    public double getPriceAvg() {
        int totalPrice = 0;
        for(int i = 0; i < list.size(); i ++){
            totalPrice += list.get(i).getPrice();
        }

        return (double) totalPrice/list.size();
    }
}
