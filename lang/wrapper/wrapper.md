# 레퍼 클래스

## 기본형의 한계

자바는 객체 지향 언어이다. 그런데 자바 안에 객체가 아닌 것이 있는데 바로 `int`, `double` 같은 기본형(Primitive Type)이다. 

기본형은객체가 아니기 떄문에 다음과 같은 한계가 있다.
* **객체가 아님** : 기본형 데이터는 객체가 아니기 때문에, 객체 지향의 장점을 살릴 수 없다.
* **null값을 가질 수 없음** : 기본형 데이터 타입은 `null`값을 가질 수 없다.

<img width="1193" alt="스크린샷 2024-04-19 오후 9 12 07" src="https://github.com/cod0216/Hello_Java/assets/83526046/106433c9-e1f7-455f-b9fb-27ea01c3958b">


## 레퍼 클래스 - 기본형의 한계 극복

레퍼 클래스를 사용하게 되면 기본형 변수를 편리하게 사용하도록 다양한 메서드를 만들 수 있다. 또한 외부 메서드를 레퍼 클래스의 내부 클래스로 캡슐화가 가능하다. **덕분에 데이터 조각에 불과한 `int`를 레퍼 클래스를 통해 객체로 다룰 수 있게 되었다.**

<img width="1264" alt="스크린샷 2024-04-19 오후 9 12 33" src="https://github.com/cod0216/Hello_Java/assets/83526046/adcedb0a-3a4b-487c-ac3b-6c9fda9e4df5">


Wrapper형 클래스는 다음과 같은 클래스들을 제공한다.
* byte -> Byte
* short -> Short
* int - > Integer
* long -> Long
* float -> Float
* double -> Double
* char -> Character
* boolean -> Boolean

대부분 기본형의 앞글자를 대문자로 바꾸면 레퍼형 클래스가 된다.

## 레퍼 클래스 -오토 박싱, 언박싱 
레퍼형은 오토박싱과 언박싱 기능을 제공한다.

* **박싱(boxing)**
  * 기본형을 레퍼 클래스로 변경하는 것을 마치 박스에 물건을 넣은 것 가탇고 해서 박싱(boxing)이라 한다.
  * `new Integer(숫자)` 이런 생성자를 사용하면 안된다 -> 향후 없어질 계획
  * 대신 `Integer.valueOf(숫자)` 이렇게 사용해야 된다. (이게 박싱)
  * `Integer.valueOf(숫자)`는 성능 최적화를 위해 -128 ~ 127 범위의 Integer 클래스를 미리 생성하고 풀 안에 넣어 두었다.
  * 그래서 == 를 사용할 경우 참조 값이 같아 `true`가 나온다.
  * 원래 객체끼리 비교는 `equals()`를 사용해야 된다. `==`는 참조값만 비교하기 때문
* **언박싱(unBoxing)**
  * 레퍼 클래스에 들어있는 기본형 값을 다시 꺼내는 메서드
  * 박스에 들어 있는 물건을 꺼내는 것 같다고 해서 언박싱
  * `객체.intValue`를 통해 사용

**참고** : 레퍼 클래스는 객체를 그대로 출력해도 내부에 있는 값을 문자로 출력하도록 `toString()`을 재정의했다.

**오토박싱 오토 언박싱 하는방법**
```java
    int value = 7;
    
    // Integer boxedValue = Integer.valueOf(value); -> 박싱(Auto-boxing
    Integer boxedValue = value; // 오토 박싱(Auto-boxing)

    // int unboxedValue = boxedValue.intValue(); -> 언박싱(Auto-Unboxing)    
    int unboxedValue = boxedValue; // 오토 언박싱(Auto-Unboxing)
```

<img width="1360" alt="스크린샷 2024-04-19 오후 9 13 25" src="https://github.com/cod0216/Hello_Java/assets/83526046/c8454678-c879-4901-be7e-1514787c13a0">

자바 레퍼형과 기본형을 사용했을 경우 연산 속도에서 약 5배 정도 차이가 난다.
<img width="890" alt="스크린샷 2024-04-19 오후 9 13 45" src="https://github.com/cod0216/Hello_Java/assets/83526046/cec681a5-a069-46db-9791-d7f42276fae4">


**유지보수 vs 최적화**
유지보수와 최적화를 고려해야 하는 상황이라면 유지보수하기 좋은 코드를 먼저 고민해야 한다. 특히 최신 컴퓨터는 매우 빠르기 때문에 메모리 사엥서 발생하는 연산을 몇 번 줄인다고해도 실ㅈ리적인 도움이 되지 않는 경우가 매우 많다.
* 코드 변경 없이 성능 최적화를 하면 가장 좋겠지만, 성능 최적화는 대부분 단순함 보다는 복잡함을 요구하고, 더 많은 코드들을 추가로 만들어야 한다. 최적화를 위해 유지보수를 해야하는 코드가 더 늘어나는 것이다. 그런데 진짜 문제는 최적화를 한다고 했지만 전체 애플리케이션의 성능 관점에서 보면 불필요한 최적화를 할 가능성이 있다.
* 특히 휍 에플리케이션의 경우 메모리 안에서 발생하는 연산 하나보다 네트워크 호출 한 번이 많게는 수십만배 더 오래 걸린다. 자바 메모리 내부에서 발생하는 연산을 수천번에서 한 번을 ㅗ줄이는 것 보다, 네트워크 호출 한번 을 줄이는 것이 더 효과적인 경우가 많다.
* 권장하는 방법은 개발 이후에 성능 테스트를 해보고 정발 문제가 되는 부분을 찾아서 최적화 하는 것이 좋다.

<img width="1061" alt="스크린샷 2024-04-19 오후 9 14 02" src="https://github.com/cod0216/Hello_Java/assets/83526046/c5e9e518-a716-42c8-865c-2786ab699840">

## class 클래스

자바에서 `Class` 클래스는 클래스의 정보(메타데이터)를 다루는데 사용된다. Class 클래스를 통해 개발자는 실행중인 자바 애플리에키션 내에서 필요한 클래스의 속성과 메서드에 대한 정보를 조회하고 조작할 수 있다.

* `Class`의 주요 정보
  * **타입 정보 얻기** : 클래스의 이름, 슈퍼클래스, 인터페이스, 접근 제한자 등과 같은 정보를 조회활 수 있다.
  * **리플렉션** : 클래스에 정의도니 메서드, 필드, 생성자 등을 조회하고, 이들을 통해 객체 인스턴스를 생성하거나 메서드를 호출하는 등의 작업을 할 수 있다.
  * **동적 로딩과 생성** : `Class.ForName()` 메서드를 사용하여 클래스를 동적으로 로드하고, `newInstance()`메서드를 통해 새로운 인스턴스를 생성할 수 있다.
  * **애노테이션 처리** : 클래스에 적용된 애노테이션(annotation)을 조회하고 처리하는 기능을 제공한다.

```java
import java.io.IOException;

public class ClassMetaMain {
  public static void main(String[] args) throws IOException {
      // 예외 처리(throws IOException) 꼭 필요!
      
    // Class 조회, Class는 예약어이기 떄문에 관례상 Clazz라고 한다.
    1. Class clazz = String.class; // 1. 클래스에서 조회
    2. Class clazz = new String().getClass(); // 2. 인스턴스에서 조회
    3, Class clazz = Class.forName("java.lang.String"); // 3. 문자열로 조회
//      -> forName("패키지 위치 입력") 이렇게 하면 외부에서 입력받아 사용 가능하다.       
//          타입.class -> 클래스에 대한 정보들을 얻어 올 수 있다.

    // 모든 필드 출력
    Field[] fields = clazz.getDeclaredFields();
    for (Field Field : fields) {
      System.out.println("Field: " + field.getType() + " " + field.getName());
    }

    // 모든 메서드 출력
    Method[] methods = clazz.getDeclaredMethods();
    for (Method method : methods) {
      System.out.println("Method: " + method);
    }

    System.out.println("Superclass : " + clazz.getSuperclass().getName());
  }
}

```

**활용**

```java
import java.sql.SQLOutput;

public class ClassCreatMain {
  public static void main(String[] args) {
    1. Class helloClass = Hello.class;
    2. Class HelloClass = Class.forName("lang.clazz.Hello");

    Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();
        // Object로 생성되기 떄문에 캐스팅 (Hello)를 해야된다.
    
    String result = hello.hello();
    System.out.println("result = " + result);
  }
}
```

* **getDeclaredConstructor().newInstance()**
  * getDeclaredConstructor() : 생성자를 선택한다.
  * newInstance() : 선택된 생성자를 기반으로 인스턴스를 생성한다.

* **리플렉션 - reflection**
  * `Class`를 사용하면 클래스의 메타 정보를 기반으로 클래스에 정의된 메서드, 필드, 생성자 등을 조회하고, 이들을 통해 객체 인스턴스를 생성하거나 메서드를 호출하는 작업을 할 수 있다. 이런 작업을 리플렉션이라 한다.
  * 추가로 애노테이션 정보를 읽어서 특별한 기능을 수행할 수 도 있다. 최신, 프레임워크들을 이런 기능을 적극 활용한다.

## Random 클래스
랜덤의 경우 `Math.random()`을 사용해도 되지만 Random 클래스를 사용하면 더욱 다양한 랜덤값을 구할 수 있다.

```java 
public class RandomMain {
  public static void main(String[] args) {
    Random random = new Random();
    //random random = new Random(1); -> seed가 같으면 Random의 결과가 같다
    
    int randomInt = random.nextInt(); // 랜덤 int 값을 반환한다.
    
    double randomDouble = random.nextDouble(); // 0.0d ~ 1.0d 사이의 랜덤 double값을 반환한다.
    
    boolean randomBoolean = random.nextBoolean(); // 랜덤 boolean 값을 반환한다.
    
    
    // 범위 조회, nextInt(int bound) : 0 ~ bound 미만의 숫자를 랜덤으로 반환한다.
    int randomRange1 = random.nextInt(10); //0 ~ 9까지 출력
    
    int randomRange2 = random.nextInt(10)+1; //1 ~ 10까지 출력
  }
}
```

* new Random() : 생성자를 비워두면 내부에서 `System.nanoTime()`에 여러가지 복잡한 알고리즘을 섞어서 씨드값을 생성한다.
* new Random(int seed) : 생성자에 씨드 값을 직접 전달할 수 있다. 씨드 값이 같으면 실행 결과가 같아진다.






