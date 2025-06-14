package generic.test.ex3.unit;

import generic.test.ex3.unit.BioUnit;

public class Shuttle <T extends BioUnit>{
    T t;
    public Shuttle() {

    }
    public void in(T t){
        this.t = t;
    }

    public T out(){
        return t;
    }
    public void showInfo(){
        System.out.println("이름 : " + t.getName() + " HP : " + t.getHp());
    }
}
