package poly.ex6;

public class SoundFlyMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Bird bird = new Bird();
        Chicken chicken = new Chicken();

        animalSound(dog);
        animalSound(bird);
        animalSound(chicken);

        moveAnimal(dog);
        moveAnimal(bird);
        moveAnimal(chicken);

        //flyAnimal(dog);  fly 상속 받지 않음
        flyAnimal(bird);
        flyAnimal(chicken);
    }

    //AbstractAnimal 사용 가능
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
    //Fly 인터페이스가 있으면 가용 가능
    private static void flyAnimal(Fly fly) {
        System.out.println("날기테스트 시작");
        fly.fly();
        System.out.println("날기 이동 테스트 종료");
        System.out.println();
    }
}
