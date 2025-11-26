package lambda.ex1;

import lambda.MyFunction;

public class M5Return {

    public static void main(String[] args) {
        MyFunction add = getOperation("add");
        MyFunction sub = getOperation("sub");
        MyFunction xxx = getOperation("xxx");

        System.out.println("add(1,3) = " + add.apply(1,3));
        System.out.println("sub(1,3) = " + sub.apply(1,3));
        System.out.println("xxx(1,3) = " + xxx.apply(1,3));

    }
    static MyFunction getOperation(String operator){

        switch (operator){
            case "add":
                return (a,b) -> a+b;
            case "sub":
                return (a,b) -> a-b;
            default:
                return (a,b)->0;
        }
    }
}
