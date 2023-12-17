# final

## final 변수와 상수
*final* 키워드는 이름 그대로 끝! 이라는 뜻이다.
변수에 *final* 키워드가 붙으면 더는 값을 변경할 수 없다.

참고로 `final`은 `class`, `method`를 포함한 여러 곳에 붙을 수 있다.

```java
public class FinalLocalMain {
    public static void main(String[] args) {
        final int data1;
        data1 = 10; //최초 한번만 할당 가능
        //data1 = 20; // 컴파일 오류

        final int date2 = 10;
        //data2 = 20; // 컴파일 오류
        method(10);
    }
    static void method(final int parameter) {
        //parameter = 20; //컴파일 오류
    }
}
```
* `final`을 지역 변수에 설정할 경우 최초 한번만 할당할 수 있다. 이후에 변수의 값을 변경하려면 컴파일 오류가 발생한다.
* `final`을 지역 변수 선언시 바로 초기화 한 경우 이미 값이 할당되었기 때문에 값을 할당할 수 없다.
* 매개변수에 `final`이 붙으면 메서드 내부에서 매개변수의 값을 변경할 수 없다. 따라서 메서드 호출 시점에 사용된 값이 끝까지 사용된다.

```java
public class ConstructInit {
    final int value;

    public ConstructInit(int value) {
        this.value = value;
    }
}
```
* final을 필드에 사용할 경우 해당 필드는 생성자를 통해서 한번만 초기화 될 수 있다.

```java
public class FieldInit {
    static final int CONST_VALUE = 10;
    final int value = 10;
    public FieldInit(){
        //this.value = value;
    }
}
```
* final 필드를 필드에서 초기화하면 이미 값이 설정되었기 떄문에 생성자를 통해서도 초기화 할 수 없다. value 필드를 참고하자.
* 코드에서 보는 것 처럼 static 변수에도 final을 선언할 수 있다.

```java
public class FinalFieldMain {
    public static void main(String[] args) {
        System.out.println("생성자 초기화");
        ConstructInit constructInit1 = new ConstructInit(10);
        ConstructInit constructInit2 = new ConstructInit(20);
        System.out.println(constructInit1.value);
        System.out.println(constructInit2.value);

        //final 필드 - 필드 초기화
        System.out.println("필드 초기화");
        FieldInit fieldInit1 = new FieldInit();
        FieldInit fieldInit2 = new FieldInit();
        FieldInit fieldInit3 = new FieldInit();
        System.out.println(fieldInit1.value);
        System.out.println(fieldInit2.value);
        System.out.println(fieldInit3.value);

        //실수
        System.out.println("상수");
        System.out.println(FieldInit.CONST_VALUE);
    }
}
``` 
`ConstructInit`과 같이 생성자를 사용해서 final 필드를 초기화 하는 경우, 각 인스턴스마다 final 필드에 다른 값을 할당할 수 있다. 물론 final을 사용했기 떄문에 생성 이후에 이 값을 변경하는 것은 불가능하다.
* `Fieldinit`과 같이 `final필드`를 필드에서 초기화 하는 경우, 모든 인스턴스가 같은 값을 가진다.
* 여기서는 FieldInit 인스턴스의 모든 value 값은 10이 된다.
* 왜냐하면 생성자 초기화와 다르게 필드 초기화는 필드의 코드에 해당 값이 미리 정해져있기 떄문이다.
* 모든 인스턴스가 같은 값은 값을 사용하기 떄문에 결과적으로 메모리를 낭비하게 된다.(물론 JVM에 따라 내부 최전화를 시도할 수 있다.) 
또 메모리 낭비를 떠나서 같은 값이 계속 생성되는 것은 개발자가 보기에 명확한 중복이다. 
이럴 때 사용하면 좋은 것이 바로 static 영역이다.

#### static final
* `FieldInit.MY_VALUE`는 `static` 영역에 존재한다. 그리고 **final** 키워드를 사용해서 초기화 값이 변하지 않는다.
* `static` 영역은 단 하나만 존재하는 영역이다. 
`MY_VALUE` 변수는 JVM 상에서 하나만 존재하므로 앞서 설명한 중복과 메모리 비효율 문제를 모두 해결할 수 있다.

**이런 이유로 필드에 final + 필드 초기화를 사용하는 경우 static을 붙여서 사용하는 것이 효과적이다.**

#### 상수(constant)
상수는 변하지 않고, 항상 일정한 값을 갖는 수를 말한다. 자바에서는 보통 단 하나만 존재하는 변하지 않는 고정된 값을 상수라 한다.

이런 이유로 상수는 static final 키워드를 사용한다.

#### 자바 상수 특징
* static final 키워드를 사용한다.
* 대문자를 사용하고 구분은 _(언더스코어)로 한다. (**관례**)
  * 일반적인 변수와 상수를 구분하기 위해 이렇게 한다.
* 필드를 직접 접근해서 사용한다.
  * 상수는 기능이 아니라 고정된 값 자체를 사용하는 것이 목적이다.
  * 상수는 값을 변경할 수 없다. 따라서 필드에 직접 접근해도 데이터가 변하는 문제가 발생하지 않는다.

## final 변수와 참조
final은 변수의 값을 변경하지 못하게 막는다. 그런데 여기서 변수의 값이라는 것이 뭘까?
* 변수는 크게 기본형 변수와 참조형 변수가 있다.
* 기본형 변수는 10, 20 같은 값을 보관하고, 참조형 변수는 객체의 참조값을 보고나한다.
  * final을 기본형 변수에 사용하면 값을 변경할 수 없다.
  * final을 참조형 변수에 사용하면 참조값을 변경할 수 없다.

```java
public class Data {
    public int value;
}
```

```java
public class FinalRefMain {
    public static void main(String[] args) {
        final Data data = new Data();

        //참조 대상의 값은 병경 가능
        data.value = 10;
        System.out.println(data.value);
        data.value = 20;
        System.out.println(data.value);

    }
}
```

```java
final Data data = new Data();
// data = new Data(); //final 변경 불가 컴파일 오류
```
참조형 변수 data에 final이 붙었다. 변수 선언 시점에 참조값을 할당했으므로 더는 참조값을 변경할 수 없다.

**그런데 참조 대상의 객체 값은 변경할 수 있다.**
* 참조형 변수 data에 final이 붙었다. 
이 경우 참조형 변수에 들어있는 참조값을 다른 값으로 변경하지 못한다. 
쉽게 이야기해서 이제 다른 객체를 참조할 수 없다. 
그런데 이것의 정확한 뜻을 잘 이해해야 한다. 참조형 변수에 들어 있는 참조값만 변경하지 못한다는 뜻이다. 
이 변수 이외에 다른 곳에 영향을 주는 것이 아니다.
* Data.value는 final이 아니다. 따라서 값을 변경할 수 없다.

정리하면 참조형 변수에 final이 붙으면 참조 대상 자체를 다른 대상으로 변경하지 못하는 것이지, 참조하는 대상의 값은 변경할 수 있다.
