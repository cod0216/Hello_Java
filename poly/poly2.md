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

### 다형성과 for문 활용

```java
public class AnimalPolyMain2 {
    public static void main(String[] args) {
        Animal[] animalArr = new Animal[] {new Dog(), new Cat(), new Caw(), new Pig()};

        for (Animal animal : animalArr) {
            soundAnimal(animal);
        }
    }

    private static void soundAnimal(Animal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
    }
}
```
배열은 같은 타입의 데이터를 나열할 수 있다.
`Dog`, `Cat`, `Caw`는 모두 `Animal의 자식이므로 Animal타입이다.

Animal 타입의 배열을 만들고 다형적 참조를 사용하면 된다.
```java
//둘은 같은 코드이다.
Animal[] animalArr = new Animal[](dog, cat, caw);
Animal[] animalArr = {dog, cat, caw}
```
다형적 참조 덕분에 `Dog`, `Cat`, `Caw`의 부모 타입인 Animal 타입으로 배열을 만들고, 각각을 배열에 포함했다.

이제 배열을 for문을 사용해서 반복하면 된다.
```java
for(Animal animal : animalArr) {
    System.out.println("동물 소리 테스트 시작");
    animal.sound();
    System.out.println("동물 소리 테스트 시작");
}
```
`animal.sound()`를 호출했지만 배열에는 Dog, Cat, Caw의 인스턴스가 들어있다. 
메서드 오버라이딩에 의해 각 인스턴스의 오버라이딩 된 sound() 메서드가 호출된다.

* `Animal[] animalArr를 통해서 배열을 사용한다.`
* `soundAnimal(Animal animal)`
  * 하나의 동몰을 받아서 로직을 처리한다.

새로운 동물이 추가되어도 soundAnimal(...) 메서드는 코드 변경 없이 유지할 수 있다. 이렇게 할 수 있는 이유는 이 메서드는
`dog`, `Cat`, `Caw`같은 구체적인 클래스를 참조하는 것이 아니라 Animal이라는 추상적인 부모를 참조하기 떄문이다.
따라서 `Animal`을 상속 받은 새로운 동물이 춫가되어도 이 메서드의 코드는 변경 없이 유지할 수 있다.

여기서 잘 보면 새로운 동물이 추가되었을떄 코드가 변하는 부분과 변하지 않는 부분이 있다. 
* `main()`은 코드가 변하는 부분이다. 새로운 동물을 생성하고 필요한 메서드를 호출한다.
* `soundAnimal(...)`는 코드가 변하지 않는 부분이다.

새로운 기능이 추가되었을 떄 변하는 부분을 최소화 하는 것이 잘 작성된 코드이다. 이렇게 하기 위해서는 코드에서 변하는 부분과 변하지 않는 부분을 명확하게 구분하는 것이 좋다.

#### 남은 문제
지금까지 설명한 코드에서는 사실 2가지 문제가 잇다.
* Animal 클래스를 생성할 수 있는 문제
* Animal 클래스를 상속 받는 곳에서 sound() 메서드 오버라이딩을 하지 않을 가능성

#### Animal 클래스를 생성할 수 있는 문제
Animal 클래스는 동물이라는 클래스이다. 이 클래스는 다음과 같이 직접 생성해서 사용할 일이 있을까?
```java 
Animal animal = new Animal();
```
개, 고양이, 소가 실제 존재한느 것은 당연하지만, 동물이라는 추상적인 개념이 실제로 존재하는 것은 이상하다. 사실 이 클래스는 다형성을 위해서 필요한 것이지 직접 인스턴스를 
생성해서 사용할 일은 없다.
하지만 `Animal`도 클래스 이기 떄문에 인스턴스를 생성하고 사용하는데 아무런 제약이 없다. 누군가 실수로 `new Animal()`을 사용해서 `Animal`의 인스턴스를 생성할 수 있다는 것이다. 
이렇게 생성된 인스턴스는 작동은 하지만 제대로된 기능을 수행하지는 않는다.

#### Animal 클래스를 상속받는 곳에서 sound() 메서드 오버라이딩을 하지 않을 가능성
예를 들어서 Animal을 상속 받은 Pig 클래스를 만든다고 가정해보자, 
우리가 기대하는 것은 Pig 클래스가 sound() 메서드를 오버라이딩 해서 "꿀꿀"이라는 소리가 나도록 하는 것이다.
그런데 개발자가 실수로 sound()메서드를 오버라이딩 하는 것을 빠트릴 수 있다. 이렇게 되면 부모의 기능을 상속 받는다.
따라서 코드상 아무런 문제가 발생하지 않는다. 물론 프로그램을 실행하면 기대와 다르게 "꿀꿀"이 아니라 부모 클래스에 있는 Animal.sound()가 호출될 것이다.

>> 좋은 프로그램은 제약이 있는 프로그램이다. 추상 클래스와 추상 메서드를 사용하면 이런 문제를 한번에 해결할 수 있다.

## 추상 클래스1
#### 추상 클래스
동물(Animal)과 같이 부모 클래스는 제공하지만, 실제 생성되면 안되는 클래스를 추상 클래스라 한다.
추상 클래스는 이름 그대로 추상적인 개념을 제공하는 클래스이다. 따라서 실체인 인스턴스가 존재하지 않는다.
대신에 상속을 목적으로 사용되고, 부모 클래스 역할을 담당한다.

```java
abstract class AbstractAnimal{...}
```
* 추상 클래스는 클래스를 선언할 때 앞에 추상이라는 의미의 abstract 키워드를 붙여주면 된다.
* 추상 클래스는 기존 클래스와 완전히 같다. 다만 new AbstractAnimal()와 같이 직접 인스턴스를 생성하지 못하는 제약이 추가된 것이다.

#### 추상 메서드
부모 클래스를 상속 받는 자식 클래스가 반드시 오버라이딩 해야 하는 메서드를 부모 클래스에 정의할 수 있다. 이것을 추상 메서드라 한다. 
추상 메서드는 이름 그대로 추상적인 개념을 제공하는 메서드이다. 
따라서 실체가 존재하지 않고, 메서드 바디가 없다.

```java
public avstract void sound();
```
* 추상 메서드는 선언할 떄 메서드 앞에 추상이라는 의미의 abstract 키워드를 붙여주면 된다.
* **추상 메서드가 하나라도 있는 클래스는 추상 클래스로 선언해야 한다.**
  * 그렇지 않으면 컴파일 오류가 발생한다.
  * 추상 메서드는 메서드 바디가 없다. 따라서 작동하지 않는 메서드를 가진 불완전한 클래스로 볼 수 있다. 따라서 직접 생성하지 못하도록 추상 클래스로 선언해야 한다.
  
* **추상 메서드는 상속 받는 자식 클래스가 반드시 오버라이딩 해서 사용해야 한다.
  * 그렇지 않으면 컴파일 오류가 발생한다.
  * 추상 메서드는 자식 클래스가 반드시 오버라이딩 해야 하기 떄문에 메서드 바디 부분이 없다. 바디 부분을 만들면 컴파일 오류가 발생한다.
  * 오버라이딩 하지 않으면 자식도 추상 클래스가 되어야 한다.
* 추상 메서드는 기존 메서드와 완전히 같다. 다만 메서드 바디가 없고, 자식 클래스가 해당 메서드를 반드시 오버라이딩 해야 한다는 제약이 추가된 것이다.

```java
public abstract class AbstractAnimal {
  public abstract void sound();
}
```
* AbstractAnimal은 abstract가 붙은 추상 클래스이다. 이 클래스는 직접 인스턴스를 생성할 수 없다.
* sound()는 abstract가 붙은 추상 메서드이다. 이 메서드는 자식이 반드시 오버라이딩 해야 한다.

```java
public class Cat extends AbstractAnimal{
    @Override
    public void sound() {
        System.out.println("야옹");
    }
}

public class Caw extends AbstractAnimal {
  @Override
  public void sound() {
    System.out.println("음메");
  }
}

public class Dog extends AbstractAnimal{

  @Override
  public void sound() {
    System.out.println("멍멍");
  }
}
```
```java
public class AbstractMain {
    public static void main(String[] args) {
        //추상 클래스 생성 불가
        //AbstractAnimal animal = new AbstractAnimal();

        Dog dog = new Dog();
        Cat cat = new Cat();
        Caw caw = new Caw();

        animalSound(dog);
        animalSound(cat);
        animalSound(caw);
    }
    
    private static void animalSound(AbstractAnimal animal) {
        System.out.println("동물 소리 테스트 시작");
        animal.sound();
        System.out.println("동물 소리 테스트 종료");
        System.out.println();
    }
}
```
추상 클래스는 생성이 불가능하다. 다음 코드의 주석을 풀고 실행하면 컴파일 오류가 발생한다.

```java
//추상 클래스 생성 불가
AbstractAnimal animal = new AbstractAnimal();
```
추상 메서드는 반드시 오버라이딩 해야 한다. 만약 자식에서 오버라이딩 메서드를 만들지 않으면 컴파일 오류가 발생한다.

#### 간단한 정리

* 추상 클래스 덕분에 실수로 Animal 인스턴스를 생성할 문제를 근본적으로 방지해준다.
* 추상 메서드 덕분에 새로운 동물의 자식 클래스를 마들때 실수로 sound()를 오버라이딩 하지 않을 문제를 근본적으로 방지해준다.

## 순수 추상 클래스
모든 메서드가 추상 메서드인 순수 추상 클래스는 코드를 실행할 바디 부분이 전혀 없다.
```java
public abstract class AbstractAnimal {
    public abstract void sound();
    public abstract void move();
}
```
이러한 순수 추상 클래스는 실행 로직을 전혀 가지고 있지 않다. 단지 다형성을 위한 부모 타입으로써 껍데기 역할만 제공할 뿐이다.

순수 추상 클래스는 다음과 같은 특징을 가진다.
* 인스턴스를 생성할 수 없다.
* 상속시 자식은 모든 메서드를 오버라이딩 해야 한다.
* 주로 다형성을 위해 사용된다.

#### 상속하는 클래스는 모든 메서드를 구현해야 한다.
"상속시 자식은 모든 메서드를 오버라이딩 해야 한다."라는 특징은 상속 받는 클래스 입장에서 보면 부모의 모든 메서드를 구현해야 하는 것이다.
이런 특징을 잘 생각해보면 순수 추상 클래슨느 마치 어떤 규격을 지켜서 구현해야 하는 것 처럼 느껴진다.
`AbstractAnimal`의 경우 `sound()`, `move()`라는 규격에 맞추어 구현을 해야 한다.

이것은 우리가 일반적으로 이야기하는 인터페이스와 같이 느껴진다. 예를 들어 USB 인터페이스를 새악해보자. USB 인터페이스는 분명한 규격이 있다.
이 규격에 맞추어 제품을 개발해야 연결이 된다. 순수 추상 클래스가 USB 인터페이스 규격이라고 한다면 USB 인터페이스에 맞추어 마우스, 키보드 같은 연결 장치들을 구현할 수 있다.

이런 순수 추상 클래스의 개념은 프로그래밍에서 매우 자주 사용된다. 자바는 순수 추상 클래스를 더 편리하게 사용할 수 있도록 인터 페이스라는 개념을 제공한다.


## 인터페이스
자바는 순수 추상 클래스를 더 편리하게 사용할 수 있는 인터페이스라는 기능을 제공한다

```java
public interface InterfaceAnimal {
    public abstract void sound();
    public abstract void move();
}
```

**인터페이스 - `public abstract`키워드 생략 가능**
```java
public interface InterfaceAnimal {
    void sound();
    void move();
}
```
순수 추상 클래스는 다음과 같은 특징을 가진다.
* 인스턴스를 생성할 수 없다.
* 상속시 모든 메서드를 오버라이딩 해야 한다.
* 주로 다형성을 위해 사용된다.

인터페이스는 앞서 설명한 순수 추상 클래스와 같다. 여기에 약간의 편의 기능이 추가된다.
* 인터페이스의 메서드는 모두 `public`, `abstract`이다.
* 메서드에 `public abstract`를 생략할 수 있다. 참고로 생략이 권장된다.
* 인터페이스는 다중 구현(다중 상속)을 지원한다.

#### 인터페이스와 멤버 변수
```java
public interface InterfaceAnimal {
    public static final int MY_PI = 3.14;
}
```
인터페이스에서 멤버 변수는 `public`, `static`, `final` 이 모두 포함되었다고 간주된다. `final`은 변수의 값을 한번 설정하면 수정할 수 없다는 뜻이다.
자바에서 `static final`을 사용해 정적이면서 고칠 수 없는 변수를 상수라 하고, 관례상 상수는 대문제에 언더스코어(_)로 구분한다.

```java
public interface InterfaceAnimal1{
    int MY_PI = 3.14;
}
```
해당 키워드는 위와 같이 생략 가능(**생략이 권장된다.**)

```java
public interface InterfaceAnimal {
    void sound();// public abstract
    void move(); // public abstract
}
```

```java
public class Cat implements InterfaceAnimal{
    @Override
    public void sound() {
        System.out.println("야옹");
    }

    @Override
    public void move() {
        System.out.println("고양이 이동");
    }
}

public class Caw implements InterfaceAnimal{
  @Override
  public void sound() {
    System.out.println("음메");
  }

  @Override
  public void move() {
    System.out.println("소 이동");
  }
}

public class Dog implements InterfaceAnimal {
  @Override
  public void sound() {
    System.out.println("멍멍");
  }

  @Override
  public void move() {
    System.out.println("개 이동");
  }
}
```
인터페이스를 상속 받을 떄는 extends 댇신에 implements라는 **구현**이라는 키워드를 사용해야 한다. 
인터페이스는 그래서 **상속이라 하지 않고 구현**이라 한다.

#### 클래스, 추상 클래스, 인터페이스는 모두 똑같다.
* 클래스, 추상 클래스, 인터페이스는 프로그램 코드, 메모리 구조상 모두 똑같다. 모두 자바에서는 `.class`로 다루어진다. 인터페이스를 작성할 때도 `.java`에 인터페이스를 정의한다.
* 인터페이스는 순수 추상 클래스와 비슷하다고 생각하면 된다.

#### 상속 vs 구현
부모 클래스의 기능을 자식 클래스가 상속 받을 떄, 클래스는 상속 받는다고 표현하지만, 부모 인터페이스의 기능을 자식이 상속 받을 때는 인터페이스를 구현한다고 표현한다. 
이렇게 서로 다르게 표현하는 이유는 상속은 이름 그대로 부모의 기능을 물려 받는 것이 목적이다. 
하지만 인터페이스는 모든 메서드가 추상 메서드이다. 
따라서 물려받을 수 있는 기능이 없고, 오히려 인터페이스에 정의한 모든 메서드를 자식이 오버라이딩 해서 기능을 구현해야 한다. 
따라서 구현한다고 표현한다. 
인터페이스는 메서드 이름만 있는 설계도이고, 이 설계도가 실제 어떻게 작동하는지는 하위 클래스에서 몯 ㅜ구현해야 한다.
따라서 인터페이스의 경우 상속이 아니라 해당 인터페이스를 구현한다고 표현한다.

상속과 구현은 사람이 표현하는 단어만 다를 분이지 자바 입장에서는 똑같다. 일반 송속 구조와 동일하게 작동한다.

#### 인터페이스를 사용해야 하는 이유
모든 메서드가 추상 메서드인 경우 순수 추상 클래스를 만들어도 되고, 인터페이스를 만들어도 된다. 
그런대 왜 인터페이스를 사용해야 할까? 단순히 편리하다는 이유를 넘어서 다음과 같은 이유가 있다.
* **제약** : 인터페이스를 만드는 이유는 인터페이스를 구현하는 곳에서 인터페이스의 메서드를 반드시 구현해라는 규약(제약)을 주는 것이다. USB 인터페이스를 생각해보자. 
USB 인터페이스에 맞추어 기보드, 마우스를 개발하고 연결해야 한다. 그렇지 않으면 작동하지 않는다. 인터페이스의 규약(제약)은 반드시 구현해야 하는 것이다. 
그런데 순수 추상 클래스의 경우 미래에 누군가 그곳에 실행 가능한 메서드를 끼워 넣을 수 있다.
이렇게 되면 추가된 기능을 자식 클래스에서 구현하지 않을 수도 있고, 또 더는 순수 추상 클래스가 아니게 된다.
인터페이스는 모든 메서드가 추상 메서드이다. 따라서 이런 문제를 원천 차단할 수 있다.
* **다중 구현** : 자바에서 클래스 상속은 부모를 하나만 지정할 수 있다. 반면에 인터페이스는 부모를 여러명 두는 다중 구현(다중 상속)이 가능하다.

#### 참고 
자바8에 등장한 default 메서드를 사용하면 인터페이스도 메서드를 구현할 수 있다. 
하지만 이것은 예외적으로 아주 특별한 경우에만 사용해야 한다.
자바9에서 등장한 인터페이스의 private 메서드도 마찬가지이다.

## 인터페이스 - 다중 구현
#### 자바가 다중 상속을 지원하지 않는 이유 - 복습

자바는 다중 상속을 지원하지 않는다. 그래서 extends 대상은 하나만 선택할 수 있다. 부모를 하나만 선택할 수 있다는 뜻이다. 
물론 부모가 또 부모를 가지는 것은 괜찮다.

만약 비행기와 자동차를 상속 받아서 하늘을 나는 자동차를 만든다고 가정해보자. 만약 그림과 같이 다중 상속을 사용하게 되면 AirplanceCar 입장에서
`move()`를 호출할 때 어떤 부모의 `move()`를 사용해야 할지 애매한 문제가 발생한다. 이것을 다이아몬드 문제라 한다. 
그리고 다중 상속을 사용하면 클래스 계층 구조가 매우 복잡해 질 수 있다. 이런 문제점 떄문에 자바는 클래스의 다중 상속을 허용하지 않는다. 대신에 인터페이스의 다중 구현을 허용하여 이러한 문제를 피한다.

클래스는 앞서 설명한 이유로 다중 상속이 안되는데, 인터페이스의 다중 구현은 허용한 이유는 뭘까?
인터페이스는 모두 추상 메서드로 이루어져 있기 때문이다.

`InterfaceA`, `InterfaceB`는 둘다 같은 `methodCommon()`을 가지고 있다. 그리고 `Child`는 두 인터페이스를 구현했다. 상속 관계의 경우 두 부모 중에 어떤 한 부모의 `methodCommon()`을
사용해야 할지 결정해야 하는 다이아몬드 문제가 발생한다.
하지만 인터페이스 자신은 구현을 가지지 않는다. 대신에 인터페이슬르 구현하는 곳에서 해당 기능을 모두 구현해야 한다. 여기서 `InterfaceA`, `InterfaceB`는 같은 이름의 `methodCommon()`를 제공하지만 
이것의 기능은 `Child`가 구현한다. 그리고 오버라이딩에 의해 어차피 `Child`에 있는 `methodCommon()`이 호출된다. 결과적으로 두 부모 중에 어떤 한 부모의 `methodCommon()`을 선택하는 것이 아니라 
그냥 인터페이스들을 구현한 Child중에 어떤 한 부모의 `methodCommon()`이 사용된다. 이런 이우로 인터페이스는 다이아몬드 문제가 발생하지 않는다. 따라서 인터페이스의 경우 다중 구현을 허용한다.

#### 하나의 클래스 여러 인터페이스 예시
```java
public class Bird extends AbstractAnimal implements Fly, Swim {...}
```

extends를 통한 상속은 하나만 할 수 있고 impelements를 통한 인터페이스는 다중 구현을 할 수 있기 때문에 둘이 함께 나온 경우 extends가 먼저 나와야 한다.

