# 열거형 -ENUM


## 문자열과 타입 안정성1 (문자열)

등급에 따라 할인된 가격으로 제품을 구매하는 엡을 만들때 일반 `String`만 사용하면 어떻게 될까?

**등급에 따라 할인 가격을 반환하는 메소드**

```java
public int discount(String grade, int price){
        int discountPercent = 0;

        if(grade.equals("BASIC")){
            discountPercent = 10;
        } else if (grade.equals("GOLD")) {
            discountPercent = 20;
        } else if (grade.equals("DIAMOND")) {
            discountPercent = 30;
        } else{
            System.out.println();
            System.out.println(grade + ": 할인 X");
        }
        return price * discountPercent / 100;
    }
```

**메인 코드**

```java 
public static void main(String[] args) {
        int price = 10000;

        DiscountService discountService = new DiscountService();
        int vip = discountService.discount("VIP", price);
        System.out.println("VIP 등급의 할인 금액 : " + vip );

        int gold = discountService.discount("gold", price);
        System.out.println("GOLD 등급의 할인 금액 : " + gold );

        int diamondd = discountService.discount("DIAMONDD", price);
        System.out.println("DIAMONDD 등급의 할인 금액 : " + diamondd );
    }
```

현제 계발자가 직접 `GOLD`, `BASIC` 등 등급을 직접 타이핑해서 할인 가격을 책정하고 있다.
하지만 이러한 방법을 사용할 경우 **컴파일 단계에서 오류 검출 하기가 어렵다.** 최악의 경우 서비스를 운영하는 중에
런타임 오류가 발생할 수 있다.

정리하자면 다음과 같다.
* **타입 안정성 부족** : 문자열은 오타가 발생하기 쉽고, 유효하지 안은 값이 입력될 수 있다.
* **데이터 일관성** : `GOLD`, `gold`, `Gold`등 다양한 형식으로 문자열을 입력할 수 있어 일관성이 떨어진다.
* **String 사용 시 타입 안정성 부족 문제**
  * **값의 제한 부족** : `String`으로 상태나 카테고리를 표현하면, 잘못된 문자열을 실수로 입력할 가능성이 있다. 예를 들어, `Monday`, `Tuesday`등을 나타내는 데 `String`을 사용하면, 오타(`Munday`)나 잘못된 값(`Funday)`이 입력될 위험이 있다.
  * **컴파일 시 오류 감지 불가** : 이러한 잘못된 값은 컴파일 시에는 감지되지 않고, 런타임에서만 문제가 발견되기 떄문에 디버깅이 어려워질 수 있다.

## 문자열과 타입 안정성2 (상수)

`String`이 아닌 `상수`를 사용하면 어떻게 될까?

**클래스 선언**

```java
public class StringGrade {
    public static final String BASIC = "BASIC";
    public static final String GOLD = "GOLD";
    public static final String DIAMOND = "DIAMOND";
}
```
**등급에 따라 할인 가격을 반환하는 메소드**

```java
public int discount(String grade, int price){
        int discountPercent = 0;

        if(grade.equals(StringGrade.BASIC)){
            discountPercent = 10;
        } else if(grade.equals(StringGrade.GOLD)){
            discountPercent = 20;
        } else if(grade.equals(StringGrade.DIAMOND)){
            discountPercent = 30;
        } else {
            System.out.println(grade + " : 할인 X");
        }
        return price * discountPercent / 100;
    }
```

문자열 상수를 사용한 덕분에 전체적으로 코드가 더 명확해졌다. 
또한 **실수로 상수의 이름을 잘못 입력하면 컴파일 시점에 오류가 발생한다.** 따라서 오류를 쉽고 빠르게 찾을 수 있다.

하지만 메소드는 `String`타입이기 때문에 해당 상수를 사용하지 않고 문자열을 사용한다면 컴파일 오류를 막을 수는 없다.
즉 소문자, 문자열, 오타 등 실수 하더라도 **근본적 설계 단계에서 에러가 발생하도록 해야한다.**

혹은 누군가 주석을 남겨서 사용에 대한 방법을 적어 놓더라도 주석을 잃지 않고 사용할 경우도 생각해서 이러한 문제를 예방해야된다. 즉 제약을 걸어놔야 된다.

## 타입 안전 열겨형 패턴, Type-Safe Enum Pattern

지금까지 설명한 문제를 해결하기 위해 나온 결과가 바로 **타입 안전 열겨형 패턴**이다. 
타입 안전 열겨형 패턴을 사용하면 나열한 항목만 사용할 수 있다.(**핵심**), `String`처럼 아무런 문자열이나 다 사용할 수 있는 것이 아니라, 우리가 나열한 항목인 `BASIC`, `GOLD`, `DIAMOND`만 안전하게 사용할 수 있다.

**타입 안전 열거형 패턴 클래스**

```java
public class ClassGrade {
    public static final ClassGrade BASIC = new ClassGrade();
    public static final ClassGrade GOLD = new ClassGrade();
    public static final ClassGrade DIAMOND = new ClassGrade();

    private ClassGrade(){}
}
```
* `static`을 사용해서 상수를 메서드 영역에 선언한다. 이렇게 되면 메모리 영역에 선언한 상수가 올라가게 된다.
* `final`을 ㅅ용해서 인스턴스(참조값)를 변경할 수 없게 한다.
  * 각 상수는 모두 서로 다른 `ClassGrade` 인스턴스를 참조하기 때문에 참좌값이 다르게 출력된다. 
* `private 생성자()`를 활용하여 외부에서 해당 클래스 생성을 막는다.

**열겨형 패턴 클래스를 다루는 메소드**
```java
public int discount(ClassGrade classGrade, int price) {
        int discountPercent = 0;

        if(classGrade == ClassGrade.BASIC){
            discountPercent = 10;
        } else if(classGrade == ClassGrade.GOLD){
            discountPercent = 20;
        } else if(classGrade == ClassGrade.DIAMOND){
            discountPercent = 30;
        } else {
            System.out.println("할인 X");
        }

        return price * discountPercent / 100;
    }
```
* 메서드 파라미터 타입만 사용이 가능하므로 `String`이나 임의 클래스 타입은 사용 불가
* 상수로 정의된 것만 사용가능
* 또한 이 값을 비교하기 위해서는 `==`참조값 비교를 사용하면 된다.(**메모리 static 영역**)

이를 통해 컴파일 과정에서 오류를 발견할 수 있다.

* **타입 안전 열겨형 패턴 장점**
  * **타입 안전성 향상** : 정해진 객체만 사용할 수 있기 때문에, 잘못된 값을 입력하는 문제를 근복적으로 방지할 수 있다. (오타 방지)
  * **데이터 일관성** : 정해진 객체만 사용하므로 데이터의 일관성이 보장된다. (정해진 값만 사용)

### 조금 더 자세히
* 장점
  * 제한된 인스턴스 생성 : 클래스는 사전에 정의된 몇 개의 인스턴스만 생성하고, 외부에서는 이 인스턴스들만 사용할 수 있다록 한다. 이를 통해 미리 정의된 값들만 사용하도록 보장된다.
    * 사전에 인스턴스 정의 -> 이것만 사용 가능(`컴파일이 보장`)
  * 타입 안정성 : 이 패턴을 사용하면, 잘못된 값이 할당되거나 사용되는 것을 컴파일 시점에 방지할 수 있다. 예를 들어, 특정 메서드가 특정 열거형 타입의 값을 요구한다면, 오직 그 타입의 인스턴스만 전달할 수 있다. 여기서는 메서드의 매개변수로 ClassGrade를 사용하는 경우, 앞서 열거한 `BASIC`, `GOLD`, `DIAMOND`만 사용할 수 있다.

* 단점
  * 이 패턴을 구현하려면 많은 코드를 작성해야한다. 그리고 private 생성자를 추가하는 등 유의해야 하는 부분들도 있다. 

# 열거형 - Enum Type

자바는 타입 안전 열거형 패턴(Type-Safe Enum Pattern)을 매우 편리하게 사용할 수 있는 열거형(Enum Type)을 제공한다.




**열거형 클래스**

```java
public enum Grade {
    BASIC, GOLD, DIAMOND
  
  /* 
        열거형 값만 있는 경우 세미콜론(;)이 필요없지만 
        그렇지 않은 경우(다른 로직이 들어가는 경우)에는 반드시 넣어줘야된다. 
  */
}
```
**ENUM 특징**
* `enum`은 자동으로 `Enum`을 상속 받는다.
* enum은 제약이 있는 클래스다.
  * 전에 제작한 "타입 안전 열거형 패턴" 코드와 똑같은 기능을 한다.
  * private 생성ㄹ자로 막혀있다.
  * 코드 가독성이 높다.
  * 미리 정의한 값들의 집합
* 열거형은 `switch`문에 사용할 수 있다.

**열거형도 클래스이다. 열거형을 제공하기 위해 제약이 추가된 클래스라 생각하면 된다.**

**enum을 사용한 메서드**

```java
public int discount(Grade grade, int price){
        int discountPercent = 0;

        if(grade == Grade.BASIC){
            discountPercent = 10;
        } else if(grade == Grade.GOLD){
            discountPercent = 20;
        } else if(grade == Grade.DIAMOND){
            discountPercent = 30;
        } else System.out.println("할인 X");

        return price * discountPercent / 100;
    }
```

**열거형(ENUM)의 장점**
* **타입 안전성 향상** : 열거형은 사전에 정의된 상수들로만 구성되므로, 유효하지 않은 값이 입력될 가능성이 없다. 이런 경우 컴파일 오류가 발생한다.
* **간결성 및 일관성** : 열거형을 사용하면 코드가 더 간결하고 명확해지며, 데이터의 일관성이 보장된다.
* **확장성** : 새로운 회원 등급을 추가하고 싶을 때, ENUM에 새로운 상수를 추가하기만 하면 된다.

**참고** : 열거형을 사용하는 경우 `static import`를 적절하게 사용하면 더 읽기 좋은 코드를 만들 수 있다.

## ENUM 메서드
* values() : 모든 ENUM 상수를 포함하는 배열을 반환한다.
* valueOf(String name): 주어진 이름과 일치하는 ENUM 상수를 반환한다.
* name() : ENUM 상수의 이름을 문자열로 반환한다
* ordinal() : ENUM 상수의 선언 순서(0부터 시작)를 반환한다. -> 가급적 사용하지 말기
* toString() : ENUM 상수의 일므을 문자열로 반환한다. name()메서드와 유사하지만, toString()은 직접 오버라이드 할 수 있다.

> **중요❗️** : ENUM도 클래스 이기 떄문에 메서드 추가가 가능하다!


* **열거형 정리**
  * 열거형은 `java.lang.Enum`을 자동(강제)으로 상속 받는다.
  * 열거형은 이미 `java.lang.Enum`을 상속 받았기 때문에 추가로 다른 클래스를 상속을 받을 수 없다.
  * 열거형은 인터페이스를 구현할 수 있다.
  * 열거형에 추상 메서드를 선언하고, 구현할 수 있다.
    * 이 경우 익명 클래스와 같은 방식을 사용한다. 


# 정리
* 실무에서 `ENUM`을 활용하는 것은 매우 중요하다.
* 개발할 때 중요한 것은 "문제가 근본적으로 발생하기 않게 어떻게 할 것이냐"다. -> **이게 중요**
* "우리가 조심해야 된다." 이런거는 매우 위험하다. -> **사람이이게 실수할 수 가 있댜.**
* **주용한 것은 문제가 생길 것들을 원천 차단하는 것이다.**
  * String 타입에 숫자를 못넣는것
  * 더 나아가서 우리가 나열한 것만 넣을 수 있게 제약하는것
    * 훨씬 좋은 개발 방법 : 컴파일 시점에서 오류를 잡는것 -> **타입 안정성**
* 좋은 프로그래밍은 제약이 있는 프로그래밍이다. 그중 하나가 "**열거형**"이다.
ㅎ
**사람은 누구나 실수하기 떄문에 원천적으로 이런걸 방지할 수 있는 것들을 잘 배워서 활용하는 것이 더 중요하다.**



