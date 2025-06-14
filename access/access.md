# 접근 제어자

##자바는 `public`, `private` 같은 접근 제어자(access modifier)를 제공한다. 접근 제어자를 사용하면 해당 클래스 외부에서 특정 필드나 메서드에 접근하는 것을 허용하거나 제한할 수 있다.

```java
package access;

public class Speaker {
    int volume;
    Speaker(int volume) {
        this.volume = volume;
    }

    void volumeup(){
        if(volume >= 100) {
            System.out.println("음량을 증가할 수 없습니다. 최대 음량입니다.");
        } else {
            volume += 10;
            System.out.println("음량을 10 증가합니다.");
        }
    }
    void volumedown(){
        if(volume <= 0) {
            System.out.println("음량을 감소할 수 없습니다. 최소 음량입니다.");
        } else {
            volume -= 10;
            System.out.println("음량을 10 감소합니다.");
        }
    }
    void showvolume() {
        System.out.println("현재 음량은 " + volume + "입니다.");
    }
}
```

```java
package access;

public class SpeakerMain {
    public static void main(String[] args) {
        Speaker speaker = new Speaker(60);
        speaker.showvolume();

        speaker.volumeup();
        speaker.showvolume();

        speaker.volumedown();
        speaker.showvolume();

        speaker.volumedown();
        speaker.showvolume();

        //필드에 직접 접근
        System.out.println("volume 필드 직접 접근 수정");
        speaker.volume = 200;
        speaker.showvolume();
    }
}
```
위 코드에서는 `volume`이 100을 넘지 못하도록 설계했지만 `volume`필드에 직접 접근할수 있기에 소용이 없게 됐다.

위 문제를 해결하기위해 접근 제어자를 사용하여 다음과 같이 수정할 수 있다.

```java
private int volume;
```
private 접근 제어자는 모든 외부 호출을 막는다. 따라서 private이 붙은 경우 해당 클래스 내부에서만 호출할 수 있다.

만약 처음부터 `private`을 사용해서 volume 필드의 외부 접근을 막아두었다면 어떠했을까? 새로운 개발자도 volume 필드에 직접 접근하지 않고, volumeUp()과 같은 메서드를 통해서 접근했을 것이다.
>> **참고** : 좋은 프로그램은 무한한 자유도가 주어지는 프로그램이 아니라 적절한 제약을 제공하는 프로그램이다.

## 접근 제어자 종류
자바는 4가지 종류의 접근 제어자를 제공한다.

* `private` : 모든 외부 호출을 막는다.
* `default(package-private)` : 같은 패키지안에서 호출은 허용한다.
* `protected` : 같은 패키지안에서 호출은 허용한다. 패키지가 달라도 상속 관계의 호출은 허용한다.
* `public` : 모든 외부 호출을 허용한다.

순서대로 `private`이 가장 많이 차단하고 `public`이 가장 많이 허용한다.

`private` -> `default` -> `protected` -> `public`

#### package-private
접근 제어자를 명시하지 않으면 같은 패키지 안에서 호출을 허용하는 default 접근 제어자가 적용된다. default라는 용어는 해당 접근 제어자가 기본값으로 사용되기 떄문에 붙여진 이름이지만, 실제로는 package-private이 더 정확한 표현이다. 왜냐하면 해당
접근 제어자를 사용하는 멤버는 동일한 패키지 내의 다른 클래스에서만 접근이 가능하기 때문이다. 참고로 두 용어를 함께 사용한다.

#### 접근 제어자 사용 위치
접근 제어자는 필드와 메서드, 생성자에 사용된다.
추가로 클래스 레벨에도 일부 접근 제어자를 사용할 수 있다.

#### 접근 제어자의 핵심은 속성과 기능을 외부로부터 숨기는 것이다.
* `private`은 나의 클래스 안으로 속성과 기능을 숨길 떄 사용, 외부 클래스에서 해당 기능을 호출할 수 없다.
* `dafault`는 나의 패키지 안으로 속성과 기능을 숨길 때 사용, 외부 패키지에서 해당 기능을 호출할 수 없다.
* `protected`는 상속 관계로 속성과 기능을 숨길 때 사용, 상속 관계가 아닌 곳에서 해당 기능을 호출할 수 없다.
* `public`은 기능을 숨기지 않고 어디서든 호출할 수 있게 공개한다.

```java
public class AccessData {
    public int publicField;
    int defaultField;
    private int privateField;

    public void publicMethod() {
        System.out.println("publicMethod 호출 " + publicField);
    }

    void defaultMethod() {
        System.out.println("defaultMethod 호출 " + defaultField);
    }
    private void privateMethod() {
        System.out.println("privateMethod 호출 " + privateField);
    }
    public void innerAccess() {
        System.out.println("내부 호출");
        publicField = 100;
        defaultField = 200;
        privateField = 300;
        publicMethod();
        defaultMethod();
        privateMethod();
    }

}
```
* `public`은 모든 접근을 허용하기 떄문에 필드, 메서드 모두 접근 가능하다.
* `default`는 같은 패키지에서 접근할 수 있다. 즉 같은 페키지에 생성된 Main코드는 default 접근 제어자에 접근할 수 있다.
* `private`은 AccessData 내부에서만 접근할 수 있다. 따라서 호출 불가다.
* `AccessData.innerAccess()`메서드는 `public`이다. 따라서 외부에서 호출할 수 있다. `innerAccess()`메서드는 외부에서 호출되었지만 `innerAccess()`메서드는 AccessData에 포함되어 있다. 이 메서드는 자신의 `private`필드와 메서드에 모두 접근 할 수 있다.

## 접근 제어자 사용 - 클래스 레벨
#### 클래스 레벨의 접근 제어자 규칙
* 클래스 레벨의 접근 제어자는 `public`, `default`만 사용할 수 있다.
  * `private`, `protected`는 사용할 수 없다.
* `public`클래스는 반드시 파일명과 이름이 같아야 한다.
  * 하나의 자바 파일에 `public` 클래스는 하나만 등장할 수 있다.
  * 하나의 자바 파일에 `default` 접근 제어자를 사용하는 클래스는 무한정 만들 수 있다.

## 캡슐화
캡슐화(Encapsulation)는 객체 지향 프로그래밍의 중요한 개념 중 하나다. 캡슐화는 데이터와 해당 데이터를 처리하는 메서드를 하나로 묶어서 외부에서의 접근을 제한하는 것을 말한다. 
캡슐화를 통해 데이터의 직접적인 변경을 방지하거나 제한할 수 있다.
캡슐화는 쉽게 이야기해서 속성과 기능을 하나로 묶고, 외부에 꼭 필요한 기능만 노출하고 나머지는 모두 내부로 숨기는 것이다.

이전에 객체 지향 프로그래밍을 설명하면서 캡술화에 대해 알아보았다. 이떄는 데이터와 데이터를 처리하는 메서드를 하나로 모으는 것에 초점을 맞추었다. 
여기서 한발짝 더 나아가 캡슐화를 안전하게 완성할 수 있게 해주는 장치가 바로 접근 제어자다.

그럼 어떤 것을 숨기고 어떤 것을 노출해야 할까?

1. **데이터를 숨겨라**
  
   객체는 속성(데이터)과 기능(메서드)이 있다. 캡슐화에서 가장 필수로 숨겨야 하는 것은 속성(데이터)이다.
객체 내부의 데이터를 외부에서 함부로 접근하게 두면, 클래스 안에서 데이터를 다루는 모든 로직을 무시하고 데이터를 변경할 수 있다.
결국 모든 안전망을 다 빠져나가게 된다. 따라서 캡슐화가 깨진다.

   우리가 일상에서 생각할 수 있는 음악 플레이어를 떠올려 보자. 음악 플레이어를 사용할 때 그 내부에 들어있는 전원부나, 볼륨 상태의 데이터를 직접 수정할 일이 있을까? 우리는 
그냥 음악 플레이어의 켜고, 끄고, 볼륨을 조절하는 버튼을 누를 뿐이다. 그 내부에 있는 전언부나, 볼륨의 상태 데이터를 직접 수정하지 않는다. 전원 버튼을 눌렀을 때 실제 전원을 받아서 전원을 켜는 것은 음악 플레이어의 일이다.
볼륨을 높였을 떄 내부에 있는 볼륨 장치들을 움직이고 볼륨 수치를 조절하는 것도 음악 플레이어가 스스로 해야하는 일이다. 쉽게 이야기해서 우리는 음악 플레이어가 제공하는 기능을 통해서 음악 플레이어를 사용하는 것이다.
복잡하게 음악 플레이어의 내부를 까서 그 내부 데이터까지 우리가 직접 사용하는 것은 아니다.
2. **기능을 숨겨라**
   객체의 기능 중에서 외부에서 사용하지 않고 내부에서만 사용하는 기능들이 있다. 이런 기능도 모두 감추는 것이 좋다. 우리가 자동차를 운전하기 위해 자동차가 제공하는 복잡한 엔진 조절 기능, 배기 기능까지 우리가 알 필요는 없다.
우리는 단지 엑셀과 핸들 정도의 기능만 알면 된다.
만약 사용자에게 이런 기능까지 모두 알려준다면, 사용자가 자동차에 대해 너무 많은 것을 알아야 한다.
사용자 입장에서 꼭 필요한 기능만 외부에 노출하자. 나머지 기능은 모두 내부로 숨기자