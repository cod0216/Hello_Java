package ssafy.step3;

import ssafy.step2.SeriesMovie;

public class BookTest {
    public static void main(String[] args){
        IBookManager manager = BookManagerImpl.getInstance();

        manager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
        manager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
        manager.add(new Book("35355", "분석설계", "소나무", "jean.kr", 30000, "SW 모델링"));
        manager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1));


        printSeparator("도서 전체 조회");
        print(manager.getList());
        printSeparator("일반 도서 조회");
        print(manager.getBook());
        printSeparator("잡지 목록");
        print(manager.getMagazines());
        printSeparator("도서 목록포함 검색 : Java");
        print(manager.searchByTitle("Java"));


    }


    static public void print(Book[] book){
        for(int i=0; i< book.length; i++){
            if(book[i] != null){
                if(book[i] instanceof Magazine){
                    System.out.println(String.format("%-15s \t| %-15s \t| %-15s \t| %-15s \t| %-15d \t| %-15s \t| %-15d \t|%-15d", book[i].getIsbn(), book[i].getTitle(), book[i].getAuthor(), book[i].getPublisher(), book[i].getPrice(), book[i].getDesc(), ((Magazine) book[i]).getYear(), ((Magazine) book[i]).getMonth()));
                }else if(book[i] instanceof Book) {
                    System.out.println(String.format("%-15s \t| %-15s \t| %-15s \t| %-15s \t| %-15d \t| %-15s", book[i].getIsbn(), book[i].getTitle(), book[i].getAuthor(), book[i].getPublisher(), book[i].getPrice(), book[i].getDesc()));
                }
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
