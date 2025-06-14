# 패키지

## 패키지 사용

패키지를 먼저 만들고 그 다음에 클래스를 만들어야 한다.

**패키지 위치에 주의하자**

```java
package  pack;

public class Data{
    public Data() {
        System.out.println("패키지 pack Data 생성");
    }
}
```
* **패키지를 사용하는 경우 항상 코드 첫줄에 package pack과 같이 패키지 이름을 적어주어야 한다.**
* 여기서는 pack 패키지에 Data 클래스를 만들었다.
* 이후에 Data 인스턴스가 생성되면 생성자를 통해 정보를 출력한다.

#### pack.a.User
```java
package pack.a;

public class User{
    public User() {
        System.out.println("패키지 pack.a 회원 생성");
    }
}
```
* pack 하위에 a라는 패키지를 먼저 만들자.
* pack.a 패키지에 User 클래스를 만들었다.
* 이후에 User 인스턴스가 생성되면 생성자를 통해 정보를 출력한다.

>> **참고** : 생성자에 public을 사용했다. 다른 패키지에서 이 클래스의 생성자를 호출하려면 public을 사용해야 한다.

#### pack.PackageMain1
```java
package  pack;

public class PackageMain1{
    public static void main(String[] args) {
        Data age = new Data();
        pack.a.User user = new pack.a.User();
    }
}
```
* **사용자와 같은 위치** : PackageMain1과 Data는 같은 pack이라는 패키지에 소속되어 있다. 이렇게 같은 패킵지에 있는 경우에는 패키지 경로를 생략해도 된다.
* **사용자와 다른 위치** : PackageMain1과 User는 서로 다른 패키지다. 이렇게 패키지가 다르면 pack.a.User와 같이 패키지 전체 경로를 포함해서 클래스를 적어주어야 한다.

## import
이전에 본 코드와 같이 패키지가 다르다고 pack.a.User와 같이 항상 전체 경로를 적어주는 것은 불편하다. 이떄는 import를 사용하면 된다.

```java
package pack;
import pack.a.User1;
public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data();
        User user = new User(); //import 사용으로 패키지 명 생략 가능
    }
} 
```

>> **참고** : 특정 패키지에 포함된 모든 클래스를 포함해서 사용하고 싶으면 import 시점에서 *을 사용하면 된다.

```java
package pack; 
import pack.a.*; //pack.a의 모든 클래스 사용 하위까진 가져오지는 않는다!
public class PackageMain2 {
    public static void main(String[] args) {
        Data data = new Data();
        User user = new User(); //import 사용으로 패키지 명 생략 가능
    }
} 
```
이렇게 하면 pack.a패키지에 있는 모든 클래스를 패키지 명을 생략하고 사용할 수 있다.

## 클래스 이름 중복

```java
public static void main(String[] args) {
        User1 userA = new User1();
        pack.b.User1 UserB = new pack.b.User1();
    }
```
같은 이름의 클래스가 있다면 import는 둘중 하나만 선택할 수 있다. 이때는 자주 사용하는 클래스를 import하고 나머지를 패키지를 포함한 전체 경로를 적어주면 된다. 물론 둘다 전체 경로를 적어준다면 import를 사용하지 않아도 된다.

## 패키지 규칙
* 패키지의 이름과 위치는 폴더(디렉토리) 위치와 같아야 한다. (**필수**)
* 패키지 이름은 모두 소문자를 사용한다. (**관례**) -> os가 구분하지 못하는게 있을 수 있기 떄문!
* 패키지 일므의 앞 부분에는 일반적으로 회사의 도메인 일므을 거꾸로 사용한다.
   * `com.company.myapp`과 같이 사용한다(**관례**)
   * 이 부분은 필수는 아니다. 하지만 수 많은 외부 라이브러리가 함께 사용되면 같은 패키지에 같은 클래스 이름이 존재할 수도 있다. 이렇게 도메인 이름을 거꾸로 사용하면 이런 문제를 방지할 수 있다.
   * 내가 오픈소스나 라이브러리를 만들어서 외부에 제공한다면 꼭 지키는 것이 좋다.
   * 내가 만든 에플리케이션을 다른 곳에 공유하지 않고, 직접 배포한다면 보통 문제가 되지 않는다.

#### 패키지와 계증 구조
패키지는 보통 다음과같이 계층 구조를 이룬다.
> * a
>    * b
>    * c

이렇게 하면 다음과 같이 총 3개의 패키지가 존재한다.
> a, a.b, a.c

계층 구조상 a 패키지 하위에 a.b 패키지와 a.c 패키지가 있다.
그런데 이것은 우리 눈에 보기에 계층 구조를 이룰 뿐이다. a 패키지와 a.b, a.c패키지는 서로 오나전히 다른 패키지이다.
따라서 a패키지의 클래스에서 a.b 패키지의 클래스가 필요하면 import 해서 사용해야 한다. 반대도 물론 마찬가지이다.

정리하면 패키지가 계층 구조를 이루더라도 모든 패키지는 서로 다른 패키지이다.
물론 사람이 이해하기 쉽게 계층 구조를 잘 활용해서 패키지를 분류하는 것은 좋다.
참고로 카테고리는 보통 큰 분류에서 세세한 분류로 점점 나누어진다. 패키지도 마찬가지이다.

패키지를 구성할 떄 서로 관련된 클래스는 하나의 패키지에 모으고, 관련이 적은 클래스는 다른 패키지로 분리하는 것이 좋다.
