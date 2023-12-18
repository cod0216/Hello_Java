package extends1.ex;

public class Book extends Item{
    private String author;
    private String price;

    public Book(String name, int price1, String author, String price2) {
        super(name, price1);
        this.author = author;
        this.price = price2;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 저자 : " + author + ", isbn : " + price);
    }
}
