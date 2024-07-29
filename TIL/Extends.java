package TIL;

public class Extends {
    public static void main(String[] args) {
        Super s = new child();
        s.sayA();
        s.sayB();
    }
}

class Super{
    public  void sayA() {
        System.out.println("A");
        sayB();
    }

    public void sayB(){
        System.out.println("B");
        this.sayB();

    }
}

class child extends Super{
    public void sayA(){
        super.sayB();
        System.out.println("a");

    }

    public void sayB(){
        System.out.println("b");
    }
}
