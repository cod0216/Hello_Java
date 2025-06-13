# 익명클래스

익명클래스(Anonymous class)는 지역 클래스의 특별한 종류의 하나이다. 익명 클래스는 지역클래스인데, 클래스의 이름이 없다는 특징이 있다.

```java
    public class LocalOuterV2 {
    
        private int outInstanceVar = 3;
    
        public void process(int paramVar) {
            int localVar = 1;
    
            class LocalPrinter implements Printer {
                int value = 0;
            }
        }

        Print printer = new LocalPrinter();
    }

    public static void main(String[] args) {
        LocalOuterV2 localOuter = new LocalOuterV2();
        localOuter.process();
    }
}
```

여기서는 지역 클래스를 사용하기 위해 선언과 생성이라는 2가지 단계를 거친다.
1. **선언** : 지역 클래스를 `LocalPrinter`라는 이름으로 선언한다. 이때 `Printer`인터페이스도 함께 구현헌다.
2. **생성** : `new LocalPrinter()`를 사용해서 앞서 선언한 지역 클래스의 인스턴스를 생성한다.

**지역클래스의 선언과 생성**
```java
//선언
class LocalPrinter implements Printer{
    //body
}

//생성
Printer printer = new LocalPrinter();
```

익명 클래스를 사용하면 클래스의 이름을 생략하고, 클래스의 선언과 생성을 한번에 처리할 수 있다.

**익명 클래스 - 지역 클래스의 선언과 생성을 한번에**

```java
Printer printer = new Printer(){
        //body
}
```

* **new Printer() {body}**
  * **익명 클래스는 클래스의 본문{body}를 정의하면서 동시에 생성한다.**
  * new 다음에는 바로 상속 받으면서 구현 할 부모 타입을 입력하면 된다.
  * 이 코드는 마치 인터페이스 Printer를 생성하는 것 처럼 보인다. **하지만 자바에서 인터페이스를 생성하는 것은 불가능하다.**
  * 이 코드는 인터페이스를 생성하는 것이 아니고, `Printer`라는 이름의 인터페이스를 구현한 익명 클래스를 생성하는 것이다. {body} 부분에 `Printer` 인터페이스를 구현한 코드를 작성하면 된다.
  * 이 부분이 바로 익명 클래스의 본문이 된다.
  * 쉽게 이야기해서 `Printer`를 상속(구현) 하면서 바로 생성하는 것이다.
* **익명 클래스 특징**
  * 익명 클래스는 이름 없는 지역 클래스를 선언하면서 동시에 생성한다.
  * 익명 클래스는 부모 클래스를 상속 받거나, 또는 인터페이스를 구현해야 한다. 익명 클래스를 사용할 때는 상위 클래스나 인터페이스가 필요하다.
  * 익명 클래스는 말 그대로 이름이 없다. 이름을 가지지 않으므로, **생성자를 가질 수 없다.** (기본 생성자만 사용됨)
  * 익명 클래스는 AnonymousOuter$1과 같이 자바 내부에서 바깥 클래스 이름 + $ + 숫자로 정의 된다. 익명 클래스가 여러개면 $1, $2, $3으로 숫자가 증가하면서 구분된다.
* **익명 클래스의 장점**
  * 익명 클래스를 사용하면 클래스를 별도로 정의하지 않고도 인터페이스나 추상 클래스를 즉성에서 구현할 수 있어 코드가 더 간결해진다. 하지만 복잡하거나 재사용이 필요한 경우에는 별도의 클래스를 정의하는 것이 좋다.
* **익명 클래스를 사용할 수 없을 때**
  * 익명 클래스는 단 한번만 인스턴스를 생성할 수 있다. 다음과 같이 여러번 생성이 필요하다면 익명 클래스를 사용할 수 없다. 대신에 지역 클래스를 선언하고 사용하면 된다.
  * 또한 복잡하거나 재사용이 필요한 경우에는 별도의 크래스를 정의하는 것이 좋다.
  ```java 
  Printer printer1 = new LocalPrinter();
  printer1.print();
  
  Printer printer2 = new LocalPrinter();
  printer2.print();
  ``` 

* **정리**
  * 익명 클래스는 이름이 없는 지역 클래스이다. 
  * 특정 부모 클래스(인터페이스)를 상속 받고 바로 생성하는 경우 사용한다.
  * 지역 클래스가 일회성으로 사용되는 경우나 간단한 구현을 제공할 때 사용한다.

**익명클래스 → 일회성!**
