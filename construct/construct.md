# 생성자

객체를 제대로 사용하기 위해서는 객체를 생성하자 마자 이런 초기값을 설정해야 한다. 이떄 생성자를 사용한다.
## this

```java
public class MemberInit {
    String name;
    int age;
    int grade;
    void initMember( String name, int age, int grade){
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```
멤버 변수와 메서드의 매개변수의 이름이 같으면 둘을 어떻게 구분해야 할까?
* 이 경우 멤버 변수보다 매개변수가 코드 블럭의 더 안쪽에 있기 떄문에 매개변수가 우선순위를 가진다. 따라서 initMember(String name, ...)메서드 안에서 name 이라고 적으면 매개변수에 접근하게 된다.
* 멤버 변수에 접근하려면 앞에 this.이라고 해주면 된다. 여기서 this는 인스턴스 자신의 참조값을 가리킨다.

#### this 제거
만약 this를 제거하게 되면

`name = name` 둘다 매개변수를 뜻하게 된다. 따라서 맴버변수의 값이 변경되지 않는다.

* 매개변수의 이름과 맴버 변수의 이름이 같은 경우 this를 사용해서 둘을 명확하게 구분해야 한다.
* this는 인스턴스 자신을 가리킨다. 

#### this 생략
this는 생략할 수 있다. 이 경우 변수를 찾을 때 가까운 지역변수(매개변수도 지역변수다)를 먼저 찾고 없으면 그 다음으로 맴버 변수를 찾는다. 맴버 변수도 없으면 오류가 발생한다.
```java
public class MemberThis {
    String nameField;
    void initMember(String nameParameter) {
        nameField = nameParameter;
    }
}
```
예를 들어서 nameField는 앞에 this가 없어도 멤버 변수에 접근한다.
* nameField는 먼저 지역변수(매개변수)에서 같은 이름이 있는지 찾는다. 이 경우 없으므로 멤버 변수에서는 찾는다.
* nameParameter는 먼저 지역변수(매개변수)에서 같은 이름이 있는지 찾는다. 이 경우 매개변수가 있으므로 매개변수를 사용한다.

#### this와 코딩 스타일
다음과 같이 멤버 변수에 접근하는 경우에 항상 this를 사용하는 코딩 스타일도 있다.
```java
public class MemberThis {
    String nameField;
    void initMember(String nameParameter) {
        this.nameField = nameParameter;
    }
}
```
this.nameField를 보면 this를 생략할 수 있지만, 생략하지 않고 사용해도 된다. 이렇게 this를 사용하면 이 코드가 멤버 변수를 사용한다는 것을 눈으로 쉽게 확인할 수 있다.
그래서 과거에 이런 스타일을 많이 사용하기도 했다. 쉽게 이야기해서 this를 강제로 사용해서, 지역변수(매개변수)와 멤버 변수를 눈에 보이도록 구분하는 것이다.

하지만 최근에 IDE가 발전하면서 IDE가 멤버 변수와 지역 변수를 색상으로 구분해준다.

## 생성자

프로그래밍을 하다보면 객체를 생성하고 이후에 바로 초기값을 할당해야 하는 경우가 많다. 
대부분의 객체 지향 언어는 객체를 생성하자마자 즉시 필요한 기능을 좀 더 편리하게 수행할 수 있도록 생성자라는 기능을 제공한다. 
**생성자를 사용하면 객체를 생성하는 시점에 즉시 필요한 기능을 수행할 수 있다.**
```java
    public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name = " + name + ", age = " + age + ", grade = " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

생성자는 메서드와 비슷하지만 다음과 같은 차이가 있다.
* 생성자의 이름은 클래스 이름과 같아야 한다. 따라서 첫 글자도 대문자로 시작한다.
* 생성자는 반환 타입이 없다. 비워두어야 한다.
* 나머지는 메서드와 같다.

#### 생성자 호출
생성자는 인스턴스를 생성하고 나서 즉시 호출된다. 생성자를 호출하는 방법은 다음 코드와 같이 new 명령어 당므에 생성자 이름과 매개변수에 맞추어 인수를 전달하면 된다.
> new 생성자이름(생성자에 맞는 인수 목록)
>
> new 클래스 이름(생성자에 맞는 인수 목록)

`new MemberConstruct("user1", 15, 90)`

이렇게 하면 인스턴스를 생성하고 즉시 해당 생성자를 호출한다. 여기서는 Member 인스턴스를 생성하고 바로 `MemberConstruct(String name, int age, int grade)` 생성자를 호출한다.

**참고로 new 키워드를 사용해서 객체를 생성할 떄 마지막에 괄호 ()도 포함해야 하는 이유가 바로 생성자 떄문이다. 객체를 생성하면서 동시에 생성자를 호출한다는 의미를 포함한다.**

#### 생성자 장점
* 중복 호출 제거

생성자가 없던 시절에는 생성 직후에 어떤 작업을 수행하기 위해 다음과 같이 메서드를 직접한번 더 호출해야 했다. 생성자 덕분에 객체를 생성하면서 동시에 생성 직후에 필요한 작업을 한번에 처리할 수 있게 되었다.
```java
//생성자 등장 전
MemberInit member = new MemberInit();
member.InitMember("user1", 15, 90);

//생성자 등장 후
MemberConstruct member = new MemberConstruct("user1", 15, 90);
```
* 제약 - 생성자 호출 필수

실수로 생성자를 호출하지 않으면 어떻게 될까? 이 메서드를 실수로 호출하지 않아도 프로그램은 작동한다. 하지만 회원의 이름, 나이, 성적 데이터가 없는 상태로 프로그램이 동작하게 된다. 만약 이 값들을 필수로 반드시 입력해야 한다면, 시스템에 큰 문제가 발생할 수 있다. 결국 아무 정보가 없는 유령 회원이 시스템 내부에 등장하게 된다.

#### 생성자의 진짜 장점은 객체를 생성할 때 직접 정의한 생성자가 있따면 직접 정의한 생성자를 반드시 호출해야 한다는 점이다. 참고로 생성자를 메서드 오버로딩 처럼 여러개 정의할 수 있는데, 이 경우에는 하나만 호출하면 된다.

MemberConstruct 클래스의 경우 다음 생성자를 직접 정의했기 떄문에 직접 정의한 생성자를 반드시 호출해야 한다.

```java
MemberConstruct(String name, int age, int grade){ ... };
```
다음과 같이 직접 정의한 생성자를 호출하지 않으면 컴파일 오류가 발생한다.
```java
MemberConstruct member3 = new MemberConstruct(); // 컴파일 오류
member3.name = "user1";
```
이 경우 개발자는 객체를 생성할 떄, 직접 정의한 생성자를 필수로 호출해야 한다는 것을 바로 알 수 있다. 그래서 필요한 생성자를 찾아서 다음과 같이 호출할 것이다.
```java
MemeberConstruct member = new MemberConstruct("user1", 15, 90);
```
생성자 덕분에 회원의 이름, 나이, 성적은 항상 필수로 입력하게 된다. 따라서 아무 정보가 없는 유령 회원이 시스템 내부에 등장할 가능성을 원천 차단한다.

#### 생성자를 사용하면 필수값 입력을 보장할 수 있다.
>> **참고** : 좋은 프로그램은 무한한 자유도가 주어지는 프로그램이 아니라 적절한 제약이 있는 프로그램이다.

## 기본 생성자
* 매개변수가 없는 생성자를 기본 생성자라 한다.
* 클래스에 생성자가 하나도 업승면 자바 컴파일러는 매개변수가 없고, 작동하는 코드가 없는 기본 생성자를 자동으로 만들어준다.
* **생성자가 하나라도 있으면 자바는 기본 생성자를 만들지 않는다.**

#### 기본 생성자를 왜 자동으로 만들어줄까?

만약 자바에서 기본 생성자를 만들어주지 않는다면 생성자는 기능이 필요하지 않은 경우에도 모든 클래스에 개발자가 직접 기본 생성자를 정의해야 한다. 생성자 기능을 사용하지 않는 경우도 많기 때문에 이런 편의 기능을 제공한다.

* 생성자는 반드시 호출되어야 한다.
* 생성자가 없으면 기본 생성자가 제공된다.
* **생성자가 하나라도 있으면 기본 생성자가 제공되지 않는다.** 이 경우 개발자가 정의한 생성자를 직접 호출해야 한다.

## 오버로딩과 this()
```java
public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age) {
        this(name, age, 50);
    }

    MemberConstruct(String name, int age, int grade) {
        System.out.println("생성자 호출 name = " + name + ", age = " + age + ", grade = " + grade);
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}
```

this()를 사용하면 생성자 내부에서 다른 생성자를 호출할 수 있다. 이 부분을 잘 활용하면 지금과 같이 중복을 제거 할 수 있다.

#### this() 규칙
* this()는 생성자 코드의 첫줄에만 작성할 수 있다.
```java
public MemberConstruct(String name, int age) {
    System.out.println("go");
    this(name, age, 50); // this()가 생성자 코드의 첫줄에 사용되지 않아 컴파일 오류 발생
}
```
## 정리
생성자는 객체 생성 직후 객체를 초기화 하기 위한 특별한 메서드로 생각할 수 있다.