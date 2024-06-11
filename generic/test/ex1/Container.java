package generic.test.ex1;

public class Container <T>{
    private T value;
    public boolean isEmpty(){
        if (this.value == null)
            return true;
        return false;
    }

    public void setItem(T value){
        this.value = value;
    }
    public T getItem(){
        return value;
    }


}
