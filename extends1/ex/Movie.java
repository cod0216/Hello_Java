package extends1.ex;

public class Movie extends Item{
    private String dircetor;
    private String actor;

    public Movie(String name, int price, String dircetor, String actor) {
        super(name, price);
        this.dircetor = dircetor;
        this.actor = actor;
    }

    @Override
    public void print() {
        super.print();
        System.out.println("- 감독 : " + dircetor + "배우 : " + actor);
    }
}
