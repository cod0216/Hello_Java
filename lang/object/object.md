# Object 클래스

## java.lang 패키지
자바가 기본으로 제공하는 라이브러리(클래스 모음) 중에 가장 기본이 되는 것이 바로 `java.lang` 패키지이다. 여기서 `lang` 은 Language(언어)의 줄임말이다.
쉽게 이야기해서 자바 언어를 이루는 가장 기본이 되는 클래스들을 보관하는 패키지를 뜻한다.

**java.lang패키지의 대표적인 클래스**
* `Object`: 모든 자바 객체의 부모 클래스
* `string`: 문자열
* `Integer`,`Long`, `Dobule` : 래퍼(Rapper)타입, 기본형 데이터 타입을 객체로 만든 것
* `Class` : 클래스 메타 정보
* `System` : 시스템과 관련된 기본 기능들을 제공

 `java.lang` 패키지는 모든 자바 애플리케이션에 자동으로 임포트된다. 따라서 `import java.lang.*`을 하지 않아도 된다.
 
## Object 클래스

<img width="1129" alt="스크린샷 2024-04-16 오후 3 16 31" src="https://github.com/cod0216/Hello_Java/assets/83526046/5eef4b00-60bd-4f19-bfb9-19651e19d038">

클래스를 상속받기 위해서는 `parent`를 사용하여 상속받을 수 있지만 praent를 사용하지 않을 경우 묵시적으로 `parent Object`를 하게 된다.

>🤔 **묵시적(Implicit) vs 명시적(Explicit)**
> 묵시적 : 개발자가 코드에 직접 기술하지 않아도 시스템 또는 컴파일러에 의해 자동으로 수행되는 것을 의미
> 
> 명시적 : 개발자가 코드에 직접 기술해서 작동하는 것을 의미

상속 받은 클래스의 부모 클래스도 상속을 받았다면 그 클래스의 부모 클래스는 결국 Object를 묵시적으로 상속 받았다.
-> **결과적으로 어떤 경우든 자바에서 클래스의 최상위 클래스는 Obeject다.**

### 자바에서 Object 클래스가 최상위 부모 클래스인 이유
모든 클래스가 `Object` 클래스를 상속 받는 이유는 다음과 같다.
1. 공통 기능 제공
2. 다형성의 기본 구현(OCP 원칙 준수 가능)

**공통 기능 제공**

객체의 정보를 제공하고, 이 객체가 다른 객체와 같은지 비교하고, 객체가 어떤 클래스로 만들어졌는지 확인하는 기능은 모든 객체에 필요한 기본 기능이다. 
이런 기능을 객체를 만들 때 마다 항상 새로운 메서드를 정의해서 만들어야한다면 상당히 번거러울 것이다.

그리고 막상 만든다고 해도 개발자마다 서로 이름이 다른 메서드를 만들어서 **일관성**이 없을 것이다.

즉 Object를 통해 프로그래밍이 단순화되고, 일관성을 가질 수 있다.

**다형성의 기본 구현**
`Object`는 초상위 클래스 이므로 자바 내의 모든 클래스를 담을 수 있다.(**다형적 참조**) 그러므로 타입이 다른 객체들을 어딘가에 보관해야 한다면 바로 `Object`에 보관하면 된다.

## Object 다형성 한계
<img width="1280" alt="스크린샷 2024-04-16 오후 3 15 11" src="https://github.com/cod0216/Hello_Java/assets/83526046/f6b6a70a-023c-4ff3-aeb8-488c4fed2f6c">

Object는 모든 객체를 대상으로 다형적 참조를 할 수 있지만 Object를 통해 전달 받은 객체를 호출하려면 각 객체에 맞는 **다운 캐스팅**이 필요하다.
```java
private static void action(Object obj){
    if(obj instanceof Dog dog) {
        dog.sound();
    }
}
```

## Object를 통한 OCP
Object를 상속받은 클래스의 기능을 호출하려면 다운 캐스팅이 필요하지만 
Object를 상속받은 클래스에서 Obeject의 기능들을 오버라이딩(재정의)를 한다면 
Object의 다형성을 활용하여 상속 받은 클래스의 메서드를 호출할 수 있다. 

**다형적 참조가 된 클래스의 메서드를 호출 할 경우 재정의된 메서드가 우선 순위를 갖는다**

```java
@Override
public String toString() {
        return "Dog {" + " dogName ='" + dogName +  "', age =" + age + "}";
}

// 이후 main에서 이 메소드 호출

        System.out.println(car.toString());  //-> Object 클래스 메서드 호출
        System.out.println(dog1.toString()); //-> 재정의한 Dog 클래스 메서드 호출
```

>💡 **참고**
> 
> `System.out.println()`에서는 `toString()` 함수를 호출한다.
> 그러므로 toString을 재정의 한다면 println 또한 재정의 된 메서드를 호출하게 된다.
> 
> 💡`Integer.toHexstring(System.identityHashCode(dog1)))`**에 관해서**
> <img width="1215" alt="스크린샷 2024-04-16 오후 3 17 00" src="https://github.com/cod0216/Hello_Java/assets/83526046/174998ab-b2ae-43e2-8b63-d298b550104a">


* OPC 원칙
  * **open** : 새로운 클래스를 추가하고, toString()을 오버라이딩해서 기능을 확장할 수 있다.
  * **close** : 새로운 클래스를 추가해도 Object와 toString()을 사용하는 클라이언트 코드인 ObejectPrinter는 변경하지 않아도 된다.

메서드가 구현체인 Car나 Dog에 의존하지 않고 추상적인 Obejct에 의존하면서 OCP를 지킬 수 있다.


* 정적 의존관계
  * 정적 의존 관계는 컴파일 시간에 결정되며, 주로 클래스 간의 관계를 의미한다.
  * 클래스 의존 관계 그림이 정적 의존 관계이며 프로그램을 실행하지 않고 클래스 내에서 사용하는 타입들만 보면 쉽게 의존 관계를 파악할 수 있다.

* 동적 의존관계
  * 동적 의존 관계는 프로그램을 실행하는 런타임에 확인할 수 있는 의존관계다.
  * `ObjectPrinter.print(Object obj)`에 인자로 어떤 객체가 전달 될지는 프로그램을 실행해봐야 알 수 있다. 어떤 경우네는 Car 인스턴스가 넘어오고, 어떤 경우에는 Dog 인스턴스가 넘어온다. 이렇게 런타임에 어떤 인스턴스를 사용하는지를 나타내는 것이 동적 의존 관걔이다.

## equals()
<img width="1309" alt="스크린샷 2024-04-16 오후 3 17 29" src="https://github.com/cod0216/Hello_Java/assets/83526046/4434e8c2-9667-4db7-b3ab-d6d3c8372449">

* **동일성(Identity)** : `==`연산자를 사용하여 두 객체의 **참조**가 동일한 객체를 가리키고 있는지 확인
* **동등성(Equality)** : `equals()`메서드를 사용하여 두 객체가 **논리적**으로 동등한지 확인

동일성은 물리적으로 같은 메모리에 있는 객체 인스턴스인지 참조값을 확인하는 것이고, 동등성은 논리적으로 같은지 확인하는 것이다.

```java
UserV1 userV1 = new UserV1("id-100");
UserV1 userV2 = new UserV1("id-100");


System.out.println("identity = " + (userV1 == userV2));
System.out.println("equals = " + userV1.equals(userV2));
```
자바에서 `equals()`는 `==`로 비교한다. 그렇기에 `equals()`메소드는 사용에 맞게 재정의가 필요하다.

> 💡 **equals() 재정의 하는 방법 ** 
> 
> IDE 기능 이용해서 사용해라

* **equals() 메서드를 구현할 때 지켜야 하는 규칙**
  * **반사성(Reflexivity)** : 객체는 자기 자신과 동등해야 한다. (`x.equals(x)`는 항상 `true`)
  * **대칭성(Symmetry)** : 두 객체가 서로에 대해 동일하다고 판단하면, 이는 양방향으로 동일해야 한다.(`x.equals(x)`가 `true`이면, `y.equals(x)`도 `true`)
  * **추이성(Transitivity)** : 만약 한 객체가 두 번째 객체와 동일하고, 두번째 객체가 세번 째 객체와 동일하다면, 첫번째 객체는 세 번째 객체와도 동일해야 한다.
  * **일관성(Consistency)** : 두 객체의 상태가 변경되지 않는 한, `equals()` 메서드는 항상 동일한 값을 반환해야 한다.
  * **null에 대한 비교** : 모든 객체는 `null`과 비교했을 떄 `false`를 반환해야한다.


# 그 외 Object 메서드
* `clone()` : 객체를 복사할때 사용
* `hashCode()` : `equals()`와 종종 함께 사용된다.
* `getClass()` : 클래스 정보, 메서드 등을 알 수 있다.
* `notify()`, `notifyAll()`, `wait()` : 멀티쓰레드용 메서드



