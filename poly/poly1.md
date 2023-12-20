# 다형성

다형성(polymorphism)은 그대로 "다양한 형태", "여러 형태"를 뜻한다. 프로그래밍에서 다형성은 한 객체가 여러 타입의 객체로 취급될 수 있는 능력을 뜻한다.
보통 하나의 객체는 하나의 타입으로 고정되어 있다. 그런데 다형성을 사용하면 하나의 객체가 다른 타입으로 사용될 수 있다는 뜻이다. 

다형성을 이해하기 위해서는 크게 2가지 핵심 이론을 알아야 한다.
* 다형적 참조
* 메서드 오버라이딩

## 다형적 참조

```java
public class Parent {
    public void parentMethod() {
        System.out.println("Parent.parentMethod");
    }
}
```
```java
public class Child extends Parent{
    public void childMethod(){
        System.out.println("chlid.childMethod");
    }
}
```
```java
public class PolyMain {
    public static void main(String[] args) {
        //부모 변수가 부모 인스턴스 참조
        System.out.println("Parent -> Parent");
        Parent parent = new Parent();
        parent.parentMethod();
        
        //자식 변수가 자식 인스턴스 참조
        System.out.println("Child -> Child");
        Child child = new Child();
        child.parentMethod();
        child.childMethod();
        
        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        System.out.println("Parent -> Child");
        Parent poly = new Child();
        poly.parentMethod();
    }
}
```

#### 부모 타입의 변수가 부모 인스턴스 참조
`Parent -> Parent: parent.parentMethod()`
* 부모 타입의 변수가 부모 인스턴스를 참조한다.
* `Parent parent = new Parent()`
* Parent 인스턴스를 만들었다. 이 경우 부모 타입인 Parent를 생성했기 떄문에 메모리 상에 Parent만 생성된다.(자식은 생성되지 않는다.)
* 생성된 참조값을 Parent 타입의 변수인 parent에 담아둔다.
* `parent.parentMethod()`를 호출하면 인스턴스의 Parent 클래스에 있는 `parentMethod()`가 호출된다.

#### 자식 타입의 변수가 자식 인스턴스 참조
`Child -> Child: child.childmethod()`
* 자식 타입의 변수가 자식 인스턴스를 참조한다.
* `Child child = new Child()`
* Child 인스턴스를 만들었다. 
이 경우 자식 타입인 Child를 생성했기 때문에 메모리 상에 Child와 Parent가 모두 생성된다.
* 생성된 참조값을 Child 타입의 변수인 child에 담아둔다.
* `child.childMethod()`를 호출하면 인스턴스의 Child 클래스에 있는 `childMethod()`가 호출된다.

#### 다형적 참조 : 부모 타입의 변수가 자식 인승턴스 참조
`Parent -> Child : poly.parentMethod()`
* 부모 타입의 변수가 자식 인스턴스를 참조한다.
* `Parent poly = new Child()`
* Child 인스턴스를 만들었다. 이 경우 자식 타입인 Child를 생성했기 떄문에 메모리 상에 Child와 Parent가 모두 생성된다.
* 생성된 참조값을 Parent 타입의 변수인 poly에 담아둔다.

**부모는 자식을 담을 수 있다.**
* 부모 타입은 자식 타입을 담을 수 있다.
* Parent poly는 부모 타입이다. new Child()를 통해 생성된 결과는 Child 타입이다. 자바에서 부모 타입은 자식 타입을 담을 수 있다
  * `Parent poly = new Child()` : 성공
* 반대로 자식타입은 부모 타입을 담을 수 없다.
  * `Child chlid1 = new Parent()` : 컴파일 오류 발생

#### 다형적 참조
* `Parent parent - new Parent()`
* `Child child - new Child()`

그런데 Parent 차입의 변수는 다음과 같이 자신인 Parent는 물론이고, 자식 타입까지 참조할 수 있다. 
만약 손자가 있다면 손자도 그 하위 타입도 참조할 수 있다.
* `Parent poly - new Parent()`
* `Parent poly - new Child()`
* `Parent poly - new Grandson()` : Child 하위에 자손이 있다면 가능

**자바에서 부모 타입은 자신은 물론이고, 자신을 기준으로 모든 자식 타입을 참조할 수 있다. 이것이 바로 다양한 형태를 참조할 수 있다고 해서 다형적 참조라 한다.**

#### 다형적 참조와 인스턴스 실행
poly.parentMethod()를 호출하면 먼저 참조값을 사용해서 인스턴스를 찾는다. 그리고 다음으로 인스턴스 안에서 실행할 타입도 찾아야한다. poly는 Parent 타입이다. 
따라서 Parent 클래스부터 시작해서 필요한 기능을 찾는다. 
인스턴스의 Parent 클래스에 parentMethod()가 있다. 
따라서 해당 메서드가 호출된다.

#### 다형적 참조의 한계
**Parent -> Child:poly.childMethod()**

`Parent Poly = new Child()` 이렇게 자식을 참조한 상황에서 poly가 자식 타입인 Child에 있는 childMethod()를 호출하면 어떻게 될까?
poly.childMethod()를 실행하면 먼저 참조 값을 통해 인스턴스를 찾는다. 그리고 다음으로 인스턴스 안에서 실행할 타입을 찾아야한다. 호출자인 poly는 Parent타입이다. 
따라서 Parent 클래스부터 시작해서 필요한 기능을 찾는다. 그런데 상혹 관계는 부모 방향으로 찾아 올라갈 수 있지만 자식 방향으로 찾아 내려갈 수는 없다. Parent는 부모 타입이고
상위에 부모가 없다. 따라서 childMethod()를 찾을 수 없으므로 컴파일 오류가 난다.

이런 경우 childMethod()를 호출하고 싶으면 어떻게 해야할까? 바로 캐스팅이 필요하다.

**다형적 참조의 핵심은, 부모는 자시글 품을 수 있다는 것이다.**

## 다형성과 캐스팅

`Parent poly = new Child()`와 같이 부모 타입의 변수를 사용하게 되면 `poly.childMethod()`와 같이 자식 타입에 있는 기능은 호출할 수 없다.
```java
public class CastingMain1 {
    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조 (다형적 참조)
        Parent poly = new Child();
        
        //단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
        poly.childMethod();

        //다운캐스팅(부모 타입 -> 자식 타입)
        Child child = (Child) poly;
        child.childMethod();
    }
}
```
* poly.childMEthod()를 호출하면 먼저 참조값을 사용해서 인스턴스를 찾는다.
* 인스턴스 안에서 사용할 타입을 찾아야 한다. poly는 Parent타입이다.
* Parent는 최상위 보무이다. 상속 관계를 부모로만 찾아서 올라갈 수 있다. childMethod()는 자식 타입에 있으므로 호출할 수 없다. 따라서 컴파일 오류가 발생한다.

#### 다운캐스팅
**부모는 자식을 담을 수 있지만 자식은 부모를 담을 수 없다.**
* `Parent parent = new Child()` : 부모는 자식을 담을 수 있다.
* `Parent parent = child // Child child 변수` : 부모는 자식을 담을 수 있다.

반면에 다음과 같이 자식은 부모를 담을 수 없다.
```java
Child child = poly //Parent poly 변수
```
(타입)처럼 괄호와 그 사이에 타입을 지정하면 참조 대상을 특정 타입으로 변경할 수 있다. 이렇게 특정 타입으로 변경하는 것을 캐스팅이라 한다.
오른쪽에 있는 (Child) poly 코드를 먼저 보자. poly는 Parent 타입이다. 
이 타입을 (Child)를 사용해서 일시적으로 자식 타입인 Child 타입으로 변경한다. 
그리고 나서 왼쪽에 있는 Child child에 대입한다.

```java
Child child = (Child) poly // 다운캐스팅을 통해 부모타입을 자식 타입으로 변환한 다음에 대입 시도
Child child = (Child) x001 // 참조값을 읽은 다음 자식 타입으로 지정 
Child child = x001 //최종 결과
```
참고로 캐스팅을 한다고 해서 Parent poly의 타입이 변하는 것이 아니다.
해당 참조값을 꺼내고 꺼낸 참조값이 Child 타입이 되는 것이다.
따라서 poly의 타입은 Parent로 기존과 같이 유지된다.


#### 캐스팅

* **업캐스팅(upcasting)** : 부모 타입으로 변경
* **다운캐스팅(downcasting)** : 자식 타입으로 변경

#### 캐스팅 용어
"캐스팅"은 영어 단어 "cast"에서 유래되었다. "cast"는 금속이나 다른 물질을 녹여서 특정한 형태나 모양으로 만드는 과정을 의미한다.
`Child child = (Child) poly` 경우 Parent poly라는 부모 타입을 Child라는 자식 타입으로 변경했다. 
부모 타입을 자식 타입으로 변경하는 것을 다운캐스팅이라 한다. 
반대로 부모 타입으로 변경하는 것은 업캐스팅이라 한다.

**다운캐스팅과 실행**
```java
//다운캐스팅(부모 타입 -> 자식 타입)
Child child = (Child) poly;
cihld.childMethod();
```
다운캐스팅 덕분에 `child.childMethod()`를 호출할 수 있게 되었다. 
`childMethod()`를 호출하기 위해 해당 인스턴스를 찾아간 다음 Child 타입을 찾는다. 
Child 타입에는 childMethod()가 있으므로 해당 기능을 호출할 수 있다

```java
public class CastingMain2 {
    public static void main(String[] args) {
        //부모 변수가 자식 인스턴스 참조 (다형적 참조)
        Parent poly = new Child();
        //단 자식의 기능은 호출할 수 없다. 컴파일 오류 발생
        //poly.childMethod();

        //다운캐스팅(부모 타입 -> 자식 타입)
        //Child child = (Child) poly;
        //child.childMethod();

        //일시적 다운캐스팅 - 해당 메서드를 호출하는 순간만 다운캐스팅
        ((Child) poly).childMethod();
    }
}
```

poly는 Parent 타입이다. 그런데 이 코드르 싱행하면 Parent타입을 임시로 Child로 변경한다 그리고 메서드를 호출할 때 Child 타입에서 찾아서 실행한다.
정확히는 poly가 child타입으로 바뀌는 것은 아니다.
```java
((Child)) poly).childMethod()//다운캐스팅을 통해 부모타입을 자식 타입으로 변환 후 기능 호출
((Child)) poly).childMethod()//참조값을 읽은 다음 자식 타입으로 다운 캐스팅
```
참고로 캐스팅을 한다고 해서 Parent poly의 타입이 변하는 것은 아니다. 
해당 참조값을 꺼내고 꺼낸 참조값이 Child 타입이 되는 것이다. 
따라서 poly의 타입은 Parent로 그대로 유지된다.

#### 업캐스팅
다운캐스팅과 반대로 현재 타입을 부모 타입으로 변경하는 것을 업캐스팅이라 한다.
```java
public class CastingMain3 {
    //upcasting vs downcasting
    public static void main(String[] args) {
        
        Child child = new Child();
        Parent parent1 = (Parent) child; //업캐스팅은 (Parent)생략 가능
        Parent parent2 = child; //업 캐스팅 생략 가능

        parent1.parentMethod();
        parent2.parentMethod();
    }
}
```
`Parent parent1 = (Parent) Child;` child타입을 Parent 타입에 대입해야 한다. 
따라서 타입을 변환하는 캐스팅이 필요하다

그런데 부모 타입으로 변환하는 경우네느 다음과 같이 캐스팅 코드인 (타입)을 생략 할 수 있다.
```java
Parent parent2 = child
Parent paretn2 = new Child()
```
**업캐스팅은 생략할 수 있다. 다운캐스팅은 생략할 수 없다. 참고로 업캐스팅은 매우 자주 사용하기 때문에 생략을 권장한다.**

## 다운캐스팅과 주의점
다운캐스팅은 잘못하면 심각한 런타임 오류가 발생할 수 있다.
```java
public class CastingMain4 {
    public static void main(String[] args) {
        Parent parent1 = new Child();
        Child child1 = (Child) parent1; //문제 없음
        child1.childMethod();

        Parent parent2 = new Parent();
        Child child2 = (Child) parent2;
        child2.childMethod();
    }
}
```
위 코드의 경우 런타임오류가 발생한다.

`parent2`를 다운캐스팅하면 ClassCastExceoption이라는 심각한 런타임 오류가 발생한다.
```java
Parent parent2 = new Parent()
```
먼저 new Parent()로 부모 타입으로 객체를 생성한다. 따라서 메모리 상에 자식 타입은 전혀 존재하지 않는다. 
생성 결과를 parent2에 담아둔다. 
이 경우 같은 타입이므로 여기서는 문제가 발생하지 않는다.

```java
Child child2 = (Child) parent2
```
다음으로 parent2를 Child 타입으로 다운캐스팅한다. 그런데 parent2는 parent로 생성이 되었다. 
따라서 메모리 상에 Child자체가 존재하지 않는다. Child 자체를 사용할 수 없는 것이다.

자바에서 이렇게 사용할 수 없는 타입으로 다운캐스팅하는 경우에 ClassCastExceoption이라는 예외를 발생시킨다.
예외가 발생하면 다음 동작이 실행되지 않고, 프로그램이 종료된다. 따라서 Child.childMethod()코드 자체가 실행되지 않는다.

#### 업캐스팅이 안전하고 다운캐스팅이 위험한 이유
업캐스팅의 경우 이런 문제가 절대로 발생하지 않는다. 왜냐하면 객체를 생성하면 해당 타입의 상위 부모 타입은 모두 함꼐 생성된다.
따라서 위로만 타입을 변경하는 업캐스팅은 메모리 상에 인스턴스가 모두 존재하기 때문에 항상 안전하다.
따라서 캐스팅을 생략할 수 있다.

반면에 다운캐스팅의 경우 인스턴스에 존재하지 않는 하위 타입으로 캐스팅하는 문제가 발생할 수 있따. 왜냐하면 객체를 생성하면 부모 타입은 모두 함께 생성되지만 자식 타입은 새성되지 않는다. 
따라서 개발자가 이런 문제를 인지하고 사용해야 한다는 의미로 명시적으로 캐스팅을 해주어야 한다.

#### 컴파일 오류 vs 런타임 오류
컴파일 오류는 변수명 오타, 잘못된 클래스 이름 사용등 자바 프로그램을 실행하기 전에 발생하는 오류이다. 이런 오류는 IDE에서 즉시 확인할 수 있기 때문에 안전하고 좋은ㅇ ㅗ류이다.

반면에 런타임 오류는 이름 그대로 프로그램이 실행되고 있는 시점에 발생하는 오류이다. 런타임 오류는 매우 안좋은 오류이다. 왜냐하면 보통 고객이 해당 프로그램을 실행하는 도중에 발생하기 때문이다.

## instanceof
다형성에서 참조형 변수는 이름 그대로 다양한 자식을 대상으로 참조할 수 있다. 그런데 참조하는 대상이 다양하기 떄문에 어떤 인스턴스를 참조하고 있는지 확인하려면 다음과 같이 할 수 있다.

```java
public class CastingMain5 {

    public static void main(String[] args) {
        Parent parent1 = new Parent();
        call(parent1);
        Parent parent2 = new Child();
        call(parent2);
    }
    private static void call(Parent parent) {
        parent.parentMethod();

        if(parent instanceof Child) {
            System.out.println("Child 인스턴스 맞음");
            Child child = (Child) parent;
            child.childMethod();
        } else {
            System.out.println("Child 인스턴스 아님");
        }
    }
}
```
위 코드처럼 인스턴스 타입을 확인하고 싶다면 `instanceof`키워드를 사용하면 된다.

자바 16부터는 `(대상) instanceof (확인) (변수)` 이런식으로 사용할 수 있다.
```java
parent instanceof Child child
```

## 다형성과 메서드 오버라이딩
다형성을 이루는 또 하나의 중요한 핵심 이론은 바로 메서드오버라이딩이다. 메스드 오버라이딩에서 꼭 기억해야 할 점은
**오버라이딩 된 메서드가 항상 우선권을 가진다**는 점이다.
그래서 이름도 기존 기능을 덮어 새로운 기능을 재정의 한다는 뜻의 오버라이딩이다.

```java
public class Parent {
    public String value = "parent";

    public void method() {
        System.out.println("Parent.method()");
    }
}
```

```java
public class Child extends Parent{
    public String value = "Child";

    @Override
    public void method() {
        System.out.println("Child.method");
    }
}
```
* Child에서 Parent의 method()를 재정의(오버라이딩)했다.
```java
public class OverridingMain {
    public static void main(String[] args) {
        //자식 변수가 자식 인스턴스 참조
        Child child = new Child();
        System.out.println("Child -> Child");
        System.out.println("value = " + child.value);
        child.method();
        //부모 변수가 부모 인스턴스 참조
        Parent parent = new Parent();
        System.out.println("Parent -> Parent");
        System.out.println("value = " + parent.value);
        parent.method();

        //부모 변수가 자식 인스턴스 참조(다형적 참조)
        Parent poly = new Child();
        System.out.println("Parent -> Child");
        System.out.println("value = " + poly.value); // 변수는 오버라이딩X
        poly.method(); //메서드 오버라이딩!
    }
} 
```
#### Chlid->Child
* child 변수는 Child 타입이다. 따라서 `child.value`, `child.method()`를 호출하면 인스턴스의 Child 타입에서 기능을 찾아서 실행한다.

#### Parent -> Parent
* Parent 변수는 Parent타입이다. 따라서 `parent.value`, `parent.method()`를 호출하면 인스턴스의 Parent타입에서 기능을 찾아서 실행한다.

#### Parent -> Child
* **이 부분이 중요하다**
* poly변수는 Parent 타입이다. 따라서 `poly.Value`, `poly.method()`를 호출하면 인스턴스의 Parent 타입에서 기능을 찾아서 실행한다.
  * `poly.value` : Parent 타입에 있는 value 값을 읽는다.
  * `poly.method()` : Parent 타입에 있는 method()를 실행하려고 한다. 그런데 하위 타입인 `child.method()`가 오버라이딩 되어있다. **오버라이딩 된 메서드는 항상 우선권**을 가진다. 따라서 `Parent.method()`가 아니라 `Child.method()`가 실행된다.

**오버라이딩 된 메서드는 항상 우선권을 가진다.** 오버라이딩은 부모 타입에서 정의한 기능을 자식 타입에서 재정의하는 것이다. 만약 자식에서도 오버라이딩 하고 손자에서도 같은 메서드를 오버라이딩을 하면 손자의 오버라이딩 메서드가 우선권을 가진다. 더 하위 자식의 오버라이딩 된 메서드가 우선권을 가지는 것이다.

## 정리
* **다형적 참조** : 하나의 변수 타입으로 다양한 자식 인스턴스를 참조할 수 있는 기능
* **메서드 오버라이딩** : 기존 기능을 하위 타입에서 새로운 기능으로 재정의

