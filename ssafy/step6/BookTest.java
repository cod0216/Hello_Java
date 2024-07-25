package ssafy.step6;

public class BookTest {
    public static void main(String[] args){
        IBookManager manager = BookManagerImpl.getInstance();
        // 값 할당
        manager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 10));
        manager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 20));
        manager.add(new Book("35355", "분석설계", "소나무", "jean.kr", 30000, "SW 모델링", 30));
        manager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1));


        printSeparator("도서 전체 조회");
        print(manager.getList());
        printSeparator("일반 도서 조회");
        print(manager.getBook());
        printSeparator("잡지 목록");
        print(manager.getMagazines());
        printSeparator("도서 목록포함 검색 : Java");
        print(manager.searchByTitle("Java"));
        System.out.println("도서 가격 총합 : " + manager.getTotalPrice());
        System.out.println("도서 가격 평군 : " + manager.getPriceAvg());
        printSeparator("도서판매 :21424, 11개");
        try{
            manager.sell("21424",11); // 예외 발생시
            manager.searchByIsbn("21424"); // 이 로직은 실행되지 않는다.
        }catch (ISBNNotFoundException e){
            System.out.println(e.getIsbn() + "는 없습니다. ");// ISBN예외 발생시 이 로직이 실행된다.
        }catch (QuantityException e){
            System.out.println("수량이 부족합니다."); // Quantity예외 발생시 이 로직이 실행된다.
        }

        printSeparator("도서구매 :21424, 10개");

        try{
            manager.buy("21424",10); //buy메서드 호출 예외 발생한다면
            print(manager.searchByIsbn("21424")); // 호출 안되고 바로 catch 문이 실행된다.
        }catch (ISBNNotFoundException e){
            System.out.println(e.getIsbn() + "는 없습니다. "); //예외 발생시 이 로직 실행된다.
        }

        printSeparator("도서판매 :21424, 11개");
        try{
            manager.sell("21424",11); // sell 메서드 호출시 예외 발생한다면
            print(manager.searchByIsbn("21424")); // 이 메서드는 호출되지 않는다.
        }catch (ISBNNotFoundException e){
            System.out.println(e.getIsbn() + "는 없습니다. "); //예와애 따라 ISBN예외 발생시 이 로직이 실행되고
        }catch (QuantityException e){
            System.out.println("수량이 부족합니다.");  // Quantity예외가 발생하면 이 로직이 실행된다.
        }



    }


    static public void print(Book[] book){
        for(int i=0; i< book.length; i++){
            if(book[i] != null){
                if(book[i] instanceof Magazine){
                    System.out.println(String.format("%-15s \t| %-15s \t| %-15s \t| %-15s \t| %-15d \t| %-15s \t| %-15d \t| %-15d \t|%-15d", book[i].getIsbn(), book[i].getTitle(), book[i].getAuthor(), book[i].getPublisher(), book[i].getPrice(), book[i].getDesc(), book[i].getQuantity(), ((Magazine) book[i]).getYear(), ((Magazine) book[i]).getMonth()));
                }else if(book[i] instanceof Book) {
                    System.out.println(String.format("%-15s \t| %-15s \t| %-15s \t| %-15s \t| %-15d \t| %-15s \t| %-15d", book[i].getIsbn(), book[i].getTitle(), book[i].getAuthor(), book[i].getPublisher(), book[i].getPrice(), book[i].getDesc(), book[i].getQuantity()));
                }
            }
        }

    }
    static public void print(Book book){
            if(book != null){
                if(book instanceof Magazine){
                    System.out.println(String.format("%-15s \t| %-15s \t| %-15s \t| %-15s \t| %-15d \t| %-15s \t| %-15d \t| %-15d \t|%-15d", book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPrice(), book.getDesc(), book.getQuantity(),((Magazine) book).getYear(), ((Magazine) book).getMonth()));
                }else if(book instanceof Book) {
                    System.out.println(String.format("%-15s \t| %-15s \t| %-15s \t| %-15s \t| %-15d \t| %-15s \t| %-15d", book.getIsbn(), book.getTitle(), book.getAuthor(), book.getPublisher(), book.getPrice(), book.getDesc(), book.getQuantity()));
                }
            }
    }


    static public void printSeparator(String str){
        printSeparator('*', 20, str);
    }
    static public void printSeparator(char a, int n,String str){
        for(int i = 0 ; i < n; i ++){
            System.out.print(a);
        }
        System.out.print(str);
        for(int i = 0 ; i < n; i ++){
            System.out.print(a);
        }
        System.out.println();

    }
}
