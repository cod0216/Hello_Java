# Class, 클래스

자바에서 `Class` 클래스는 클래스의 정보(메타 데이터)를 다루는데 사용된다. `Class`클래스를 통해 개발자는 실행중인 자바 애플리케이션 내에서 필요한 클래스의 속성과 메서드에 대한 정보를 조회하고 조작할 수 있다.

`Class`클래스의 주요 기능은 다음과 같다.
* **타입 정보 얻기** : 클래스의 이름, 슈퍼클래스, 인터페이스, 접근 제한자 등과 같은 정보를 조회할 수 있다.
* **리플렉션** : 클래스에 저으이된 메서드, 필드, 생성자 등을 조회하고, 이들을 통해 객체 인스턴스를 생성하거나 메서드를 호출하는 등의 작업을 할 수 있다.
* **동적 로딩과 생성** : `Class.forName()` 메서드를 사용하여 클래스를 동적으로 로드하고, `newInstance()`메서드를 통해 새로운 인스턴스를 생성할 수 있다.
* **애노테이션 처리** : 클래스에 적용된 애노테이션(annotation)을 조회하고 처리하는 기능을 제공한다.

[사진]

```java
// Class 조회 (1.클래스에서 조회, 2.인스턴스에서 조회, 3.문자열로 조회)
    Class clazz = String.class; // 1.클래스에서 조회
    Class clazz = new String().getClass(); // 2.인스턴스에서 조회
    Class clazz = clazz.forName("java.lang.String") // 3.문자열로 조회
// 3.문자열 조회는 외부에서 입력을 받아서도 사용 가능하다

// 모든 필드 출력 -> getDeclaredFields
    Field[] fields = clazz.getDeclaredFields();
    for(Field Field : fields){
        System.out.println("Field : " + field.getType() + " " + field.geName());    
    }

// 모든 메서드 출력 -> getDeclaredMethods()
    Method[] Methods = clazz.getDeclareMethods();
    for(Method method : methods) {
        System.out.println("Method : " + method);    
    }

// 상위 클래스 정보 출력
    System.out.println("Superclass : " + clazz.getSuperclass().getName());
    
// 인터페이스 정보 출력
    Class[] interface = clazz.getInterface();
    for(Class i : interfaces){
        System.out.println("Interface : " + i.getName());    
    }
    
```

## 클래스 생성하기
`Class`클래스에는 클래스의 모든 정보가 들어있다. 이 정보를 기반으로 인스턴스를 생성하거나, 메서드를 호출하고, 필드의 값도 변경할 수 있다.

```java
    Class helloClass = Hello.class;
    Class helloClass = Class.forName("lang.clazz.Hello");
    // 둘중 하나 사용
    
    Hello hello = (Hello) helloClass.getDeclaredConstructor().newInstance();
    String result = hello.hello();
    
    System.out.println("result = " + result);
```

[사진]

> **리플렉션**
> 
> `Class`를 사용하면 클래스의 메타 정보를 기반으로 클래스에 정의된 메서드, 필드, 생성자 등을 조회하고, 이들을 통해 객체 인스턴스를 생성하거나 메서드를 호출하는 작업을 할 수 있다.
> 이런 작업을 **리플렉션**이라고 한다. 추가로 애노테이션정보를 읽어서 특별한 기능을 수행할 수 도 있다.