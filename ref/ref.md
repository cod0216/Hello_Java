# 기본형과 참조형

변수의 데이터 타입을 가장 크게 보면 기본형과 참조형으로 분류할 수 있다. 사용하는 값을 변수에 직접 넣을 수 있는 기본형, 그리고 이전에 본 `Student student1`과 같이 객체가 저장된 메모리의 위츨르 가리키는 참조값을 넣을 수 있는 참조형으로 분류할 수 있다.
* 기본형(Primitive Type) : int, long, double, boolean 처럼 변수에 사용할 값을 직접 넣을 수 있는 데이터 타입을 기본형이라 한다.
* 참조형(Reference Type) : `Student student1`, `int[] students`와 같이 데이터에 접근하기 위한 참조(주소)를 저장하는 데이터 타입을 참조형이라 한다. 참조형은 객체 또는 배열에 사용된다.

쉽게 이야기해서 기본형 변수에는 직접 사용할 수 있는 값이 들어있지만 참조형 변수에는 위치(참조값)가 들어가 있다. 참조형 변수를 통해서 뭔가 하려면 결국 참조값을 통해 해당 위치로 이동해야 한다.
 
## 💡 쉽게 이해하는 팁 
기본형을 제외한 나머지는 모두 참조형이다.
* 기본형은 소문자로 시작한다. `int`, `long`, `double`, `boolean` 모두 소문자로 시작한다.
  * 기본형은 자바가 기본으로 제공하는 데이터 타입이다. 이러한 기본형은 개발자가 새로 정의할 수 없다. 개발자는 참조형인 클래스만 직접 정의할 수 있다.
* 클래스는 대문자로 시작한다. `Student`
   * 클래스는 모두 참조형이다.

#### 참고 - String
자바에서 String은 특별하다. String은 사실 클래스다. 따라서 참조형이다. 그런데 기본형처럼 문자 값을 바로 대입할 수 있다. 문자는 매우 자주 다루기 때문에 자바에서 특별하게 편의 기능을 제공한다.

## 변수 대입
#### 대원칙 : 자바는 항상 변수의 값을 복사해서 대입한다.
자바에서 변수에 값을 대입하는 것은 변수에 들어 있는 값을 복사해서 대입하는 것이다.
기본형, 참조형 모두 항상 변수에 있는 값을 복사해서 대입한다. 기본형이면 변수에 들어 있는 실제 사용하는 값을 복사해서 대입하고, 참조형이면 변수에 들어 있는 참조값을 복사해서 대입힌다.

## 메서드 호출

자바에서 메서드의 매개변수(파라미터)는 항상 값에 의해 전달된다. 그러나 이 값이 실제 값이나, 참조(메모리 주소)값이냐에 따라 동작이 달라진다.
* 기본형 : 메서드로 기본형 데이터를 전달하면, 해당 값이 복사되어 전달된다. 이 경우, 메서드 내부에서 매개변수(파라미터)의 값을 변경해도, 호출자의 변수 값에는 영향이 없다.
* 참조형 : 메서드로 참조형 데이터를 전달하면, 참조값이 복사되어 전달된다. 이 경우, 메서드 내부에서 매개변수(파라미터)로 전달된 객체의 멤버 변수를 변경하면, 호출자의 객체도 변경된다.

## 변수와 초기화
변수의 종류
* 맴버변수(필드) : 클래스에 선언
* 지역 변수 : 메서드에 선언, 매개변수도 지역 변수의 한 종류이다.

**맴버변수, 필드 예시**
```java
public class Student{
    String name;
    int age;
    int grade;
}
```
name, age, grade는 멤버 변수이다.

**지역변수 예시**

```java
public class MethodChange1{
  public static void main(String[] args) {
    int a = 10;
    System.out.println("메서드 호출 전 : a = " + a);
    changePrimitive(a);
    System.out.println("메서드 호출 후 : a = " + a);
  }
  public static void changePrimitive(int x) {
      x = 20;
  }
}
```
a, x(매개변수)는 지역 변수이다.
지역 변수느 ㄴ이름 그대ㅗㄹ 특정 지역에서만 사용되는 변수라는 뜻이다. 예를 들어서 변수 x는 changePrimitive()메서드의 블록에서만 사용된다. changePrimitive()메서드가 끝나면 제거된다. a 변수도 마찬가지다. main() 메서드가 끝나면 제거된다.

#### 변수의 값 초기화
* 멤버 변수 : 자동 초기화
  * 인스턴스의 멤버 변수는 인스턴스를 생성할 때 자동으로 초기화된다.
  * 숫자(int) = 0, boolean = false, 참조형 = null (null 값은 참조할 대상이 없다는 뜻으로 사용된다.)
  * 개발자가 초기값을 직접 지정할 수 있다.
* 지역 변수 : 수동 초기화
  * 지역 변수는 항상 직접 초기화해야 한다.

```java
Init Data

package ref;

public class InitData {
    int value1;
    int value2 = 10;
}
```
value1은 초기값을 지정하지 않았고, value2는 초기값을 10으로 지정했다.
```java
package ref;

public class InitMain {
  public static void main(String[] args) {
    InitData data = new InitData();
    System.out.println("value1 = " + data.value1);
    System.out.println("value2 = " + data.value2);
  }
}
```

>value1 = 0
> 
> value2 = 10

value1은 초기값을 지정하지 않았지만 멤버변수는 자동으로 초기화 된다. 숫자는 0으로 초기화된다.

value2는 10으로 초기값을 지정해두었기 때문에 객체를 생성할 떄 10으로 초기화된다.

## null
참조형 변수는 항상 객체가 있는 위치를 가리키는 참조값이 들어간다. 그런데 아직 가리키는 대상이 없거나, 가리키는 대상을 나중에 입력하고 싶다면 어떻게 해야할까?
참조형 변수에 아직 가리키는 대상이 없다면 null이라는 특별한 값을 넣어둘 수 있다. null은 값이 존재하지 않는, 없다는 뜻이다.

#### null 값 할당
```java
pakage ref;

public class Data{
    int value;
}
```
```java
package ref;
public class NullMain1 {
  public static void main(String[] args) {
    Data data = null;
    System.out.println("1. data = " + data);
    data = new Data();
    System.out.println("2. data = " + data);
    data = null;
    System.out.println("3. data = " + data);
  }
}
```
**실행 결과**
>1. data = null
>
> 2. data = ref.data0x001
> 
> 3. data = null

## GC - 아무도 참조하지 않는 인스턴스의 최후
data에 sunll을 할당했다. 따라서 생성한 x001 Data 인스턴스를 더는 아무도 참조하지 않는다. 이렇게 아무도 참조하지 않게 되면 x001 이라는 참좆값을 다시 구할 방법이 없다. 따라서 해당 인스턴스에 다시 접근할 방법이 없다.
이렇게 아무도 참조하지 않는 인스턴스는 사용되지 않고 메모리 용량만 차지할 뿐이다.
C와 같은 과거 프로그래밍 언어는 개발자가 지겆ㅂ 명령어를 사용해서 인스턴스를 메모리에서 제거해야 한다. 만약 실수로 인스턴스 삭제를 누락하면 메모리에 사용하지 않는 객체가 가득해져서 메모리 부족 오류가 발생하게 도니다.
자바는 이런 과정을 자동으로 처리해준다. 아무도 참조하지 않는 인스턴스가 있으면 JVM의 GC(가비지 컬렉션)가 더 이상 사용하지 않는 인스턴스라 판단하고 해당 인스턴스를 자동으로 메모리에서 제거해준다.

객체는 해당 객체를 참조하는 곳이 있으면, JVM이 종료할 떄 까지 계속 생존한다. 그런데 중간에 해당 객체를 참조하는 곳이 모두 사라지면 그떄 JVM은 필요 없는 객체로 판단하고 GC(가비지 컬렉션)를 사용해서 제거한다.

## NullPointerException
NullPointerException은 이름 그대로 null을 가리키다(Pointer)인데, 이떄 발생하는 예외(Exception)다.
null은 없다는 뜻이므로 결국 주소가 없는 곳을 찾아갈 떄 발생하는 예외이다.

객체를 참조할 떄는 .(dot)을 사용한다. 이렇게 하면 참조값을 사용해서 해당 객체를 찾아갈 수 있다. 그런데 참조값이 null 이라면 값이 없다는 뜻이므로, 찾아갈 수 있는 객체(인스턴스)가 없다. NullPointerException은 이처럼 null에 .(dot)을 찍었을 떄 발생한다.

```java
package ref;

public class NullMain2 {
  public static void main(String[] args) {
    Data data = null;
    data.value = 10; // NullPointerException 예외 발생
    System.out.println("data = " + data.value);
  }
}
```

> data.value = 10
> 
> null.value = 10 // data에는 null 값이 들어있다.

=======================================================

```java
package ref;

public class Data {
    int value;
}
```
```java
package ref;

public class BigData {
    Data data;
    int count;
}
```

```java
package  ref;

public class NullMain3 {
    public static void main(String[]args){
        BigData bigData = new BigData();
        System.out.println("bigData.count =" + bigData.count);
        System.out.println("bigData.data = " + bigData.data);
        
        //NullPointerException
      System.out.println("bigData.data.value=" + bigData.data.value);
    }
}

```

BigData를 생성하면 BigData의 인스턴스가 생성된다. 이때 BigData 인스턴스의 멤버 변수에 초기화가 일어나는데, BigData의 data 멤버 변수는 참조형이므로 null로 초기화 된다. count 멤버 변수는 숫자이므로 0으로 초기화 된다.
* bigData.count를 출력하면 0이 출력된다.
* bigData.data를 출력하면 참조값인 null이 출력된다. 이 변수는 아직 아무것도 참조하고 있지 않다.
* bigData.data.value를 출력하면 data의 값이 null 이므로 null에 .(dot)을 찍게 되고, 따라서 참조할 곳이 없으므로 NullPointerException 예외가 발생한다.

#### 해결 방법
이 문제를 해결하려면 Data 인스턴스를 만들고 BigData.data 멤버 변수에 참조값을 할당하면 된다.

```java
package ref;

public class NullMain4 {
  public static void main(String[] args) {
    BigData bigData = new BigData();
    bigData.data = new Data();
    System.out.println("bigData.count = " + bigData.count);
    System.out.println("bigData.data = " + bigData.data);
    System.out.println("bigData.data.value = " + bigData.data.value);
  }
}
```

## 정리

#### 대원칙 : 자바는 항상 변수의 값을 복사해서 대입한다.
자바에서 변수에 값을 대입하는 것은 변수에 들어 있는 값을 복사해서 대입하는 것이다.
기본형, 참조형, 모두 항상 변수에 있는 값을 복사해서 대입한다. 기본형이면 변수에 들어 있는 실제 사용하는 값을 복사해서 대입하고, 참조형이면 변수에 들어 있는 참조값을 복사해서 대입한다.

#### 기본형 vs 참조형 - 기본
* 자바의 데이터 타입을 가장 크게 보면 기본형과 참조형으로 나눌 수 있다.
* 기본형을 제외한 나머지 변수는 모두 참조형이다. 클래스와 배열을 다루는 변수는, 참조형이다.
* 기본형 변수는 값을 직접 저장하지만, 참조형 변수는 참조(주소)를 저장한다.
* 기본형 변수는 산술 연산을 수행할 수 있지만, 참조형 변수는 산술 연산을 수행할 수 없다.
* 기본형 변수는 null을 할당할 수 없지만, 참조형 변수는 null을 할당할 수 있다.

#### 기본형 vs 참조형 - 대입
* 기본형과 참조형 모두 대입시 변수 안에 있는 값을 읽고 복사해서 전달한다.
* 기본형은 사용한는 값을 복사해서 전달하고, 참조형은 참조값을 복사해서 전달하는것이다. 따라서 하나의 인스턴스를 여러곳에서 참조할 수 있다.
* 헷갈리면 그냥 변수 안에 들어간 값을 떠올려보자. 기본형은 사용하는 값이 참조형은 참조값이 들어있다. 변수에 어떤 값이 들어있든간에 그 값을 그대로 복사해서 전달한다.

#### 기본형 vs 참조형 - 메서드 호출
* 메서드 호출시 기본형은 메서드 내부에서 매개변수(파라미터)의 값을 변경해도 호출자의 변수 값에는 영향이 없다.
* 메서드 호출시 참조형은 메서드 내부에서 매개변수(파라미터)로 전달된 객채의 멤버 변수를 변경하면 호출자의 객체도 변경된다.