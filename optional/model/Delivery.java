package optional.model;

public class Delivery {
    private String statue;
    private boolean cancled;

    public Delivery(String statue, boolean cancled) {
        this.statue = statue;
        this.cancled = cancled;
    }

    public String getStatue() {
        return statue;
    }

    public boolean isCancled() {
        return cancled;
    }
}
