# 객체 지향 프로그래밍

## 절차 지향 프로그래밍

#### 절차 지향 프로그래밍 vs 객체 지향 프로그래밍
프로그래밍 방식은 크게 절차 지향 프로그래밍과 객체 지향 프로그래밍으로 나눌 수 있다.

#### 절차 지향 프로그래밍
* 절차 지향 프로그래밍은 이름 그대로 절차를 지향한다. 쉽게 이야기해서 실행 순서를 중요하게 생각하는 방식이다.
* 절차 지향 프로그래밍은 프로그램의 흐름을 순차적으로 따르며 처리하는 방식이다. 즉 **어떻게**를 중심으로 프로그래밍 한다.

#### 객체 지향 프로그래밍
* 객체 지향 프로그래밍은 이름 그대로 객체를 지향한다. 쉽게 이야기해서 객체를 중요하게 생각하는 방식이다.
* 객체 지향 프로그래밍은 실제 세계의 사물이나 사건을 객체로 보고, 이러한 객체들 간의 상호작용을 중심으로 프로그래밍하는 방식이다. 즉, **무엇을** 중심으로 프로그래밍 한다.


#### 둘의 중요한 차이
* 절차 지향은 데이터와 해당 데이터에 대한 처리 방식이 분리되어 있다. 반면 객체 지향에서는 데이터와 그 데이터에 대한 행동(메서드)이 하나의 **객체**안에 함께 포함되어 있다. 


```java
 public static void main(String[] args) {
        int volume = 0;
        boolean isOn = false;

        //음악 플레이어 켜기
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");

        //볼륨 증가
        volume++;
        System.out.println("음악 플레이어 볼륨 : " + volume);
        //볼륨 증가
        volume++;
        System.out.println("음악 플레이어 볼륨 : " + volume);
        //볼륨 감소
        volume--;
        System.out.println("음악 플레이어 볼륨 : " + volume);

        //음악 플레이어 상태
        System.out.println("음악 플레이어 상태 확인");
        if(isOn) {
            System.out.println("음악 플레이어 On, 볼륨 : " + volume);
        }
        else {
            System.out.println("음악 플레이어 OFF");
        }

        //음악 플레이어 끄기
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
```

위 코드를 다음과 같이 수정한다. 

```java
public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;
    void on() {
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }
    void off() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
    void volumeUp () {
        volume++;
        System.out.println("음악 플레이어 볼륨 : " + volume);
    }
    void volumeDown () {
        volume--;
        System.out.println("음악 플레이어 볼륨 : " + volume);
    }
    void volumeStatus () {
        System.out.println("음악 플레이어 상태 확인");
        if(isOn) {
            System.out.println("음악 플레이어 On, 볼륨 : " + volume);
        }
        else {
            System.out.println("음악 플레이어 OFF");
        }
    }
```

```java
public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.on();
        player.volumeUp();
        player.volumeUp();
        player.volumeDown();
        player.volumeStatus();
        player.off();
    }
```

각각의 기능을 메서드로 만든 덕분에 각각의 기능이 모듈화 되었다. 덕분에 다음과 같은 장점이 생겼다.
* **중복제거** : 로직 중복이 제거되었다. 같은 로직이 필요하면 해당 메서드를 여러번 호출하면 된다.
* **변경 영향 범위** : 기능을 수정할 떄 해당 메서드 내부만 변경하면 된다.
* **메서드 이름 추가** : 메서드 이름을 통해 코드를 더 쉽게 이해할 수 있다.

> **모듈화** : 쉽게 이야기해서 레고 블럭을 생각하면 된다. 필요한 블럭을 가져다 꼽아서 사용할 수 있다, 여기서는 음악 플레이어의 기능이 필요하면 해당 기능을 메서드 호출 만으로 손쉽게 사용할 수 있다. 이제 음악 플레이어와 관련된 메서드를 조립해서 프로그램을 작성할 수 있다.

## 절차 지향 프로그래밍의 한계

객체 지향 프로그래밍이 나오기 전까지는 데이터와 기능이 분리되어 있었다. 하지만 객체 지향 프로그래밍이 나오면서 데이터와 기능을 온전히 하나로 묶어서 사용할 수 있게 되었다.
즉, 유지보수 고나점에서 관리포인트가 2곳에서 1곳으로 줄어든것이다.

## 클래스와 메서드
클래스는 데이터인 멤버 변수 뿐 아니라 기능 역할을 하는 메서드도 포함할 수 있다.

```java
public class ValueData {
    int value;

    void add() {
        value++;
        System.out.println("숫자 증가 value = " + value);
    }
```
클래스에서 데이터인 value와 해당 데이터를 사용하는 기능인 add() 메서드를 함께 정의했다.
이 클래스를 아래와 같이 사용할 수 있다.
```java
public class ValueDataMain {
    public static void main(String[] args) {
        ValueData valueData = new ValueData();
        valueData.add();
        valueData.add();
        valueData.add();
        System.out.println("최종 숫자 = " + valueData.value);
    }
}
```
#### 참고 : 여기서 만드는 add()메서드는 `static`키워드를 사용하지 않는다.
메서드는 객체를 생성해야 호출할 수 있다. 그런데 `static`이 붙으면 객체를 생성하지 않고도 메서드를 호출할 수 있다.

#### 인스턴스의 메서드 호출
인스턴스의 메서드를 호출하는 방법은 멤버 변수를 사용하는 방법과 동일하다. .(dot)을 찍어서 객체 접근한 다음에 원하는 메서드를 호출하면 된다.
```java
valueObject.add(); //1
x002.add(); //2 x002 ValueObject 인스턴스에 있는 add() 메서드를 호출한다.
```

* 클래스는 속성(데이터, 멤버 변수)과 기능(메서드)을 정의할 수 있다.
* 객체는 자신의 메서드를 통해 자신의 멤버 변수에 접근할 수 있다.
   * 객체의 메서드 내부에서 접근하는 멤버 변수는 객체 자신의 멤버 변수이다.

## 객체 지향 프로그래밍

```java
public class MusicPlayer {
    int volume = 0;
    boolean isOn = false;
    void on() {
        isOn = true;
        System.out.println("음악 플레이어를 시작합니다.");
    }
    void off() {
        isOn = false;
        System.out.println("음악 플레이어를 종료합니다.");
    }
    void volumeUp () {
        volume++;
        System.out.println("음악 플레이어 볼륨 : " + volume);
    }
    void volumeDown () {
        volume--;
        System.out.println("음악 플레이어 볼륨 : " + volume);
    }
    void volumeStatus () {
        System.out.println("음악 플레이어 상태 확인");
        if(isOn) {
            System.out.println("음악 플레이어 On, 볼륨 : " + volume);
        }
        else {
            System.out.println("음악 플레이어 OFF");
        }
    }
```

```java
public static void main(String[] args) {
        MusicPlayer player = new MusicPlayer();

        player.on();
        player.volumeUp();
        player.volumeUp();
        player.volumeDown();
        player.volumeStatus();
        player.off();
    }
```

위 코드를 보자, MusicPlater 객체를 생성하고 필요한 기능(메서드)을 호출하기만 하면 된다. 필요한 모든 것은 MusicPlayer 안에 들어있다.
* MusicPlayer를 사용하는 입장에서는 MusicPlayer의 데이터인 volume, isOn 같은 데이터는 전혀 사용하지 않는다.
* MusicPlayer를 사용하는 입장에서는 이제 MusicPlayer 내부에 어떤 속성(데이터)이 있는지 전혀 몰라도 된다. MusicPlayer를 사용하는 입장에서는 단순하게 MusicPlayer가 제공하는 기능 중에 필요한 기능을 호출해서 사용하기만 하면 된다.

#### 캡슐화
MusicPlayer를 보면 음악 플레이어를 구성하기 위한 속성과 기능이 마치 하나의 캡슐에 쌓여있는 것 같다. 이렇게 속성과 기능을 하나로 묶어서 필요한 기능을 메서드를 통해 외부에 제공하는 것을 캡슐화라 한다.

## 정리
#### 객체 지향 프로그래밍 vs 절차 지향 프로그래밍
객체 지향 프로그래밍과 절차 지향 프로그래밍은 서로 대치되는 개념이 아니다. 객체 지향이라도 프로그램의 작동 순서는 중요하다. 다만 어디에 더 초점을 맞추는가ㄴ에 둘의 차이가 있다. 객체 지향의 경우 객체의 설계와 관계를 중시한다.
반면 절차 지향의 경우 데이터와 기능이 분리되어 있고, 프로그램이 어떻게 작동하는지 그 순서에 초점을 맞춘다.

#### 절차 지향 프로그래밍
* 절차 지향 프로그래밍은 이름 그대로 절차를 지향한다. 쉽게 이야기해서 실행 순서를 중요하게 생각하는 방식이다.
* 절차 지향 프로그래밍은 프로그램의 흐름을 순차적으로 따르며 처리하는 방식이다. 즉 '**어떻게**'를 중심으로 프로그래밍 한다.

#### 객체 지향 프로그래밍
* 객체 지향 프로그래밍은 이름 그대로 객체를 지향한다. 쉽게 이야기해서 객체를 중요하게 생각하는 방식이다.
* 객체 지향 프로그래밍은 실제 세계의 사물이나 사건을 객체로 보고, 이러한 객체들 간의 상호작용을 중심으로 프로그래밍하는 방식이다. 즉, '**무엇을**' 중심으로 프로그래밍 한다.

#### 객체란?
세상의 모든 사물을 단순하게 추상화해보면 속성(데이터)과 기능 딱 2가지로 설명할 수 있다.

* **자동차**
  * **속성** : 차량 색상, 현재 속도
  * **기능** : 엑셀, 브레이크, 문 열기, 문 닫기
* **동물**
   * **속성** : 색상, 키, 온도
   * **기능** : 먹는다. 걷는다.
* **게임 케릭터**
   * **속성** : 레벨, 경험치, 소유한 아이템들
   * **기능** : 이동, 공격, 아이템 획득

객체 지향 프로그래밍은 모든 사물을 속성과 기능을 가진 객체로 생각하는 것이다. 객체에는 속성과 기능만 존재한다.
이렇게 단순화하면 세상에 있는 객체들을 컴퓨터 프로그램으로 쉽게 설계할 수 있다.
이런 장점들 덕분에 지금은 객체 지향 프로그래밍이 가장 많이 사용된다.

객체 지향의 특징은 속성과 기능을 하나로 묶는 것 뿐만 아니라 캡슐화, 상속, 다형성, 추상화, 메시지 전달 같은 다양한 특징들이 있다.
참고로 실세계와 객체가 항상 1:1로 매칭되는 것은 아니다.
