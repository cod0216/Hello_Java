package ssafy.ws_10_3;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BookManagerImplV2 implements IBookManager {

    List<Book> list = new ArrayList<>();
    private static final IBookManager instance = new BookManagerImplV2(); // static final로 값일 변화 시킬 수 없게 하는 변수를 선언하고 생성자로 인스턴스를 생성한다.

    // 기본생성자
    private BookManagerImplV2() {
        loadData();
    }
    //미리 생성된 인스턴스를 getInstance 메서드를 통해 반환한다
    static public IBookManager getInstance() {
        return instance;
    }

//    파리미터로 book을 받어서 리스트에 저장한다.
    @Override
    public void add(Book book) {
        list.add(book);

        System.out.println(book.getTitle()+"책이 등록되었습니다");
    }

    //isbn 정보를 파라미터로 받아와서 리스트에 isbn이 있으면 해당 값을 지우고 없다면 ISBNNotFoundException을 발생시킨다.
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

//    리스트를 배열로 반한한다.
    @Override
    public Book[] getList() {

        return list.toArray(new Book[list.size()]);
    }

//    isbn값으로 리스트내 book의 isbn값과 일치한 데이터를 찾는다.
    @Override
    public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getIsbn().equals(isbn)) {
                return list.get(i);
            }
        }
        throw new ISBNNotFoundException(isbn);
    }

    // title값으로 리스트내 book의 title과 일치한 데이터를 찾는다.
    @Override
    public Book[] searchByTitle(String title) {
        List<Book> books = new ArrayList<>();
        boolean check = false;
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i).getTitle().contains(title)) {
                books.add(list.get(i));
            }
        }
        if(books.size()>0) return books.toArray(new Book[books.size()]);
        else {
            System.out.println(title + "책을 찾지 못했습니다.");
            return null;
        }
    }

//    리스트에서 Megazine 타입을 찾아서 Magazin타입 배열로 반환한다.
    @Override
    public Magazine[] getMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Magazine){
                magazines.add((Magazine) list.get(i));
            }
        }
        if(magazines.size()>0) return magazines.toArray(new Magazine[magazines.size()]);
        else return null;
    }

    //리스트에서 Book 타입을 찾아서 Book 배열로 반환한다.
    @Override
    public Book[] getBook() {

        List<Book> books = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if (list.get(i) instanceof Magazine) {
            } else if (list.get(i) instanceof Book) {
                books.add(list.get(i));
            }
        }
        if(books.size() >0) return books.toArray(new Book[books.size()]);
        else return null;
    }

//    리스트에서 모든 데이터를 순회해서 price를 합산하여 값을 반환한다.
    @Override
    public int getTotalPrice() {
        int totalPrice = 0;
        for(int i = 0; i < list.size(); i ++){
            totalPrice += list.get(i).getPrice();
        }

        return totalPrice;
    }

    //    리스트에서 isbn을 통해 일치한 데이터를 찾고 찾은 데이터에서 quantity를 얻어와 파라미터로 받은 값과 비교해 데이터 값이 더 크면 파라미터 값을 빼준다.
    //    리스트에서 isbn값이 없다면 예외를 출력한다
    //    데이터 Quantity보다 파라미터 값이 더 크면 QuantityException을 발생한다.
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

    //    리스트에서 isbn을 통해 일치한 데이터를 찾고 찾은 데이터에서 quantity를 얻어와 파라미터로 받은 값을 더해서 setQuantity를 이용해 업데이터 시켜준다.
    //    리스트에서 isbn값이 없다면 예외를 출력한다
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
        try (FileOutputStream fileOut = new FileOutputStream("./tda.dat");
             ObjectOutputStream out = new ObjectOutputStream(fileOut);) {
            for(Book book : list){
                out.writeObject(book);
            }
            loadData();
        } catch (Exception e) {
            System.out.println("저장하기를 실패하였습니다.");
        }
    }

    private void loadData() {
        try{
            System.out.println("********************불러온 도서 전체 목록********************");
            FileInputStream fileIn = new FileInputStream("./tda.dat");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            List<Book> list = new ArrayList<>();
            while(true) {
                try{
                     list.add((Book)in.readObject());
                }catch (Exception e){
                    break;
                }
            }

            for(Book book : list){
                System.out.println(book.toString());

            }

        }catch (Exception e){
            System.out.println("등록된 도서가 없습니다.");
            System.out.println();
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
