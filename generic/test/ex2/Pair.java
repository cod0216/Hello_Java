package generic.test.ex2;

public class Pair <T1, T2> {
    private T1 value1;
    private T2 value2;

    public void setFirst(T1 value1){
        this.value1 = value1;
    }

    public void setSecond(T2 value2){
        this.value2 = value2;
    }

    public T1 getFirst(){
        return value1;
    }
    public T2 getSecond(){
        return value2;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "value1=" + value1 +
                ", value2=" + value2 +
                '}';
    }
}
