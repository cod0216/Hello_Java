# 다형성2

```java
public class Cat {
    public void sound() {
        System.out.println("냐옹");
    }

}

public class Caw {
    public void sound(){
        System.out.println("음매");
    }

}

public class Dog {
    public void sound() {
        System.out.println("멍멍");
    }
}
```
```java
public class AnimalSoundMain {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        System.out.println("동물 소리 테스트 시작");
        dog.sound();
        System.out.println("동물 소리 테스트 종료");

        System.out.println("동물 소리 테스트 시작");
        cat.sound();
        System.out.println("동물 소리 테스트 종료");

        soundCaw(caw);
    }

    private static void soundCaw(Caw caw) {
        System.out.println("동물 소리 테스트 시작");
        caw.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
```
#### 중복 제거 시도

* **메서드 중복 제거**

메서드를 사용하면 다음과 같이 매개변수의 클래스의 Caw, Dog, Cat 중에 하나로 정해야한다.
```java
private static void soundCaw(Caw caw) {
    Syste.out.println("동물 소리 테스트 시작")
    caw.sound();
    Syste.out.println("동물 소리 테스트 종료")
}
```
따라서 이 메서드는 Caw 전용 메서드가 되고, Dog, Cat은 인수로 사용할 수 없다.
왜냐하면 클래스(타입)가 서로 다르기 떄문에 soundCaw 메서드를 함께 사용하는 것은 불가능하다.

* **배열과 for문을 통한 중복 제거 시도
```java
Caw[] cawArr = {cat, dog, caw};
System.out.println("동물 소리 테스트 시작");
for (Caw caw : cawArr) {
    caw.sound();
}
Syste.out.println("동물 소리 테스트 종료");
```
배열과 for문을 사용해서 중복을 제거하려고 해도 배열의 타입을 Dog, Cat, Caw 중에 하나로 지정해야 한다. 같은 Caw들을 배열에 담아서 처리하는 것은 가능하지만 
타입이 서로 다른 Dog, Cat, Caw을 하나의 배열에 담는 것은 불가능 하다.
결과적으로 지금 상황에서는 해결 방법이 없다. 새로운 동물이 추가될 때마다 더 많은 중복 코드를 작성해야 한다.

## 다형성과 오버라이딩 활용
다형성을 사용하기 위해 여기서는 상속 관계를 사용한다. Aniaml(동물) 이라는 부모 클래스를 만들도 sound()에 
메서드를 정의한다. 이 메서드는 자식 클래스에서 오버라이딩 할 목적을 만들었다.
Dog, Cat, Caw는 Animal 클래스를 상속 받았다. 그리고 각각 부모의 sound()메서드를 오버라이딩한다.

```java
public class Animal {
    public void sound() {
        System.out.println("동물 울음 소리");
    }
}

public class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}

public class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}

public class Caw extends Animal{
    @Override
    public void sound() {
        System.out.println("음메");
    }
}
```

```java
public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();
        Duck duck = new Duck();

        soundAnimal(dog);
        soundAnimal(cat);
        soundAnimal(caw);
        soundAnimal(duck);
    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }

}
```
#### 코드를 분석해보자
`soundAnimal(dog)`를 호출하면 `soundAnimal(Animal animal)`에 dog 인스턴스가 전달된다.
`Animal animal = dog`로 이해하면 된다. 부모는 자식을 담을 수 있다. Animal은 dog의 부모다.
메서드 안에서 `animal.sound()` 메서드를 호출한다.

animal 변수의 타입은 Animal이므로 Dog 인스턴스에 있는 Animal 클래스 부분을 찾아서 sound() 메서드를 실행한다. 
그런데 하위 클래스인 Dog에서 sound()메서드를 오버라이딩 했다. 따라서 오버라이딩한 메서드가 우선권을 가진다. Dog 클래스에 있는 sound() 메서드를 오버라이딩 했다.
따라서 오버라이딩한 메서드가 우선권을 가진다.
dog 클래스에 있는 sound()메서드가 호출되므로 "멍멍"이 출력된다.

**이 코드의 핵심은 Animal animal 부분이다.**
* **다형적 참조** 덕분에 animal 변수는 자식인 Dog, Cat, Caw의 인스턴스를 참조할 수 있다. (부모는 자식을 담을 수 있다.)
* **메서드 오버라이딩** 덕분에 `animal.sound()`를 호출해도 `Dog.sound()`, `Cat.sound()`, `Caw,sound()`와 같이 각 인스턴스의 메서드를 호출할 수 있다.
만약 자바에 메서드 오버라이딩이 없다면 모두 Animal의 sound()가 호출되었을 것이다.

다형성 덕분에 이후에  새로운 동물을 추가해도 다음 코드를 그대로 **재사용** 할 수 있다. 물론 다형성을 사용하기 위해 새로운 동물은 Animal을 상속 받아야 한다.
```java
private static void soundAnimal(Animal animal) {
    System.out.println("동물 소리 테스트 시작");
    animal.sound();
    System.out.println("동물 소리 테스트 종료");
}
```
