package poly.ex4;

public class AbstractMain {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        animalSound(dog);
        animalSound(cat);
        animalSound(caw);

        moveAnimal(dog);
        moveAnimal(cat);
        moveAnimal(caw);


    }
    private static void animalSound(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
        System.out.println();
    }

    private static void moveAnimal(AbstractAnimal animal) {
        System.out.println("동물 이동 테스트 시작");
        animal.move();
        System.out.println("동물 이동 테스트 종료");
        System.out.println();
    }
}
