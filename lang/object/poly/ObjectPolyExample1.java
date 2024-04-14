package lang.object.poly;

public class ObjectPolyExample1 {
    public static void main(String[] arg){
        Dog dog = new Dog();
        Car car = new Car();

        action(dog);
        action(car);

    }
    public static void action(Object obj){
        obj.toString();

//        obj.move(); -> 다운 캐스팅 필요      object는 다양한 참조가 가능하지만 하위 메소드 사용시 다운 캐스팅이 필요하다!
//        obj.sound(); -> 다운 캐스팅 필요     object는 다양한 참조가 가능하지만 하위 메소드 사용시 다운 캐스팅이 필요하다!

        if(obj instanceof Dog dog){
            dog.sound();
        }
        if(obj instanceof Car car){
            car.move();
        }
    }
}
