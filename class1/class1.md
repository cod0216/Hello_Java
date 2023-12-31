# 클래스와 데이터

## 배열 사용의 한계

```java
String[] studentNames = {"학생1", "학생2"};
int[] studentAges = {15, 16};
int[] studentGrades = {90, 80};
```

```java
String[] studentNames = {"학생1", "학생2", "학생3", "학생4", "학생5"}
int[] studentAges = {15, 16, 17, 10, 16}
int[] strudentGrades = {90, 80, 100, 80, 50}
```
배열을 사용해서 코드 변경을 최소화하는데는 성공했지만, 한 학새으이 데이터가 studentNames[], studentAges[], studentGrades[]라는 3개의 배열에 나누어져 있다. 따라서 데이터를 변경할 떄 매우 조심해서 작업해야 한다. 예를 들어서 학생 2의 데이터를 제거하려면 각각의 배열마다 학생 2의 데이터를 제거하려면 각각의 배열마다 학생2의 요소를 정확하게찾아서 제거해주어야 한다.
```java
String[] studentNames = {"학생1", "학생3", "학생4", "학생5"}
int[] studentAges = {15, 17, 10, 16}
int[] strudentGrades = {90, 100, 80, 50}
```

한 학생의 데이터가 3개의 배열에 나누어져 있기 떄문에 3개의 배열을 각각 변경해야 한다. 그리고 한 학생의 데이터를 관리하기 위해 3개 배열의 인덱스 순서를 항상 정확하게 맞추어야 한다. 이렇게 하면 특정 학생의 데이터를 변경할 때 실수할 가능성이 매우 높다.
이 코드는 컴퓨터가 볼 때는 아무 문제가 없지만, 사람이 관리하기에는 좋은 코드가 아니다.

## 클래스 도입
클래스를 사용해서 학생이라는 개념을 만들고, 각각의 학생 별로 본인의 이름, 나이, 성적을 관리하는 것이다.
```java
public class Student {
    String name;
    int age;
    int grade;
}
```
class 키워드를 사용해서 학생 클래스{Student}를 정의한다. 학생 클래스는 내부에 이름(name), 나이(age), 성적(grade)변수를 가진다.

이렇게 **클래스에 정의한 변수들을 멤버 변수, 또는 필드** 라고 한다.

 * 맴버 변수(Member Variable) : 이 변수들은 특정 클래스에 소속된 멤버이기 때문에 이렇게 부른다.
 * 필드 (field) : 데이터 항목을 가리키는 정통적인 용어이다. 데이터베이스, 엑셀 등에서 데이터 각각의 항목을 필드라 한다.
 * 자바에서 멤버 변수, 필드는 같은 뜻이다. 클래스에 소속된 변수를 뜻한다.

#### 클래스는 관례쌍 대문자로 시작하고 낙타 표기법을 사용한다.
    예) Student, User, MemberService

#### 클래스와 사용자 정의 타입
* 타입은 데이터의 종류나 형태를 나타낸다.
* int라고 하면 정수 타입, String이라고 하면 문자 타입이다.
* 학생(Student)이라는 타입을 만들면 되지 않을까?
* 클래스를 사용하면 int, String과 같은 타입을 직접 만들 수 있다.
* 사용자가 직접 정의하는 사용자 정의 타입을 만들려면 설계도가 필요하다. 이 설계도가 바로 클래스이다.
* 설계도인 클래스를 사용해서 실제 메모리에 만들어진 실체를 객체 또는 인스턴스라 한다.
* 클래스를 통해서 사용자가 원하는 종류의 데이터 타입을 마음껏 정의할 수 있다.

#### 용어 : 클래스, 객체, 인스턴스
클래스는 설계도이고, 이 설계도를 기반으로 실제 메모리에 만들어진 실체를 객체 또는 인스턴스라 한다. 둘다 같은 의미로 사용된다.
여기서는 학생(Student)클래스를 기반으로 학생1(student1),  학생2(student2) 객체 또는 인스턴스를 만들었다.

1. 변수 선언

* `Student student1 // 변수 선언`
  * student 타입을 받을 수 있는 변수를 선언한다.
  * int는 정수를, String은 문자를 담을 수 잇듯이 Student는 Student 타입의 객체(인스턴스)를 받을 수 있다.

2. 객체 생성
 * `student1 = new Student() //Student 인스턴스 생성`
   * 객체를 사용하려면 먼저 설계도인 클래스 기반으로 객체(인스턴스)를 생성해야 한다.
   * `new Student()` : new는 새로 생성한다는 뜻이다. new Student()는 Student 클래스 정보를 기반으로 새로운 객체를 생성하라는 뜻이다. 이렇게 하면 메모리에 실제 Student 객체(인스턴스)를 생성한다.
   * 객체를 생성할 때는 new 클래스명()을 사용하면 된다. 마지막에 ()도 추가해야 한다.
   * Student 클래스는 String name, int age, int grade 멤버 변수를 가지고 있다. 이 변수를 사용하는데 필요한 메모리 공간도 함께 확보한다.
 
3. 참조값 보관
 * `student1 = x001; // Student 인스턴스 참조값 보관`
 * 객체를 생성하면 자바는 메모리 어딘가에 있는 이 객체에 접근할 수 있는 참조값(주소)(x001)을 반환한다.
   * 여기서 x001 이라고 표현한 것이 참조값이다.
 * new 키워드를 통해 객체가 생성되고 나면 참조값을 반환한다. 앞서 선언한 변수인 Student student1에 생성된 객체의 참족밧(x001)을 보관한다.
 * Student student1 변수는 이제 메모리에 존재하는 실제 Student 객체(인스턴스)의 참조값을 가지고 있다.
   * student1 변수는 방금 만든 객체에 접근할 수 있는 참조값을 가지고 있다. 따라서 이 변수를 통해 객체를 접근(참조)할 수 있다. 쉽게 이야기해서 student1 변수를 통해 메모리에 있는 실제 객체를 접근하고 사용할 수 있다.
 
#### 참조값을 변수에 보관해야 하는 이유
객체를 생성하는 new Student() 코드 자체에는 아무런 이름이 없다. 이 코드는 단순히 Student 클래스를 기반으로 메모리에 실제 객체를 만드는 것이다. 따라서 생성한 객체에 접근할 수 있는 방법이 필요하다. 이런 이유로 객체를 생성할 떄 반환되는 참조값을 어딘가에 보관해두어야 한다. 앞서 Student student1 변수에 참조값(x001)을 저장해 두었으므로 저장한 참조값(x001)을 통해서 실제 메모리에 존재하는 객체에 접근할 수 있다.

```java
Student student1 = new Student(); // 1. Student 객체 생성
Student student1 = new Student(); // 2. Student()의 결과로 x001 참조값 반환
student1 = x001; //3. 최종 결과
```
위 내용을 간단히 코드로 풀어본 것이다.

## 객체 사용

클래스를 통해 생성한 객체를 사용하려면 먼저 메모리에 존재하는 객체에 접근해야 한다. 객체에 접근하려면 .(점, dot)을 사용하면 된다.
```java
//객체 값 대입
student1.name = "학생1";
student1.age = 15;
student1.grade = 90;

//객체 값 사용
System.out.println("이름 : " + student1.name + ", 나이 : " + student1.age + ", 성적 : " + student1.grade);
```

#### 객체에 값을 대입
객체가 가지고 있는 맴버변수(name,age, grade)에 값을 대입하려면 먼저 객체에 접근해야 한다.
객체에 접근하려면 . (점, dot)키워드를 사용하면 된다. 이 키워드는 변수(student1)에 들어있는 참조값(x001)을 읽어서 메모리에 존재하는 객체에 접근한다.

순서를 간단히 플어보면 다음과 같다.
```java
student1.name = "학생1"; //1. student1 객체의 name 맴버 변수에 값 대입
x001.name = "학생1"; //2. 변수에 있는 참조값을 통해 실제 객체에 접근, 해당 객체의 name 멤버 변수에 값 대입
```
* student1.(dot)이라고 하면 student1 변수가 가지고 있는 참조값을 통해 실제 객체에 접근한다.
* student1은 x001이라는 참족밧을 가지고 있으므로 x001위치에 있는 Student 객체에 접근한다.

## 클래스, 객체, 인스턴스 정리
#### 클래스-class
클래스는 객체를 생성하기 위한 '틀' 또는 '설계도'이다. 클래스는 객체가 가져야 할 속성(변수)과 기능(메서드)를 정의한다. 예를 들어 학생이라는 클래스는 속성으로 name, age, grade를 가진다.
 * **틀** : 붕어빵 틀을 생각해보자. 붕어빵 틀은 붕어빵이 아니다. 이렇게 생긴 붕어빵이 나왔으면 좋겟다고 만드는 틀일 뿐이다. 실제 먹을 수 잇는 것이 아니다. 실제 먹을 수 잇는 팥 붕어빵을 객체 또는 인스턴스라 한다.
 * **설계도** : 자동차 설계도를 생각해보자. 자동차 설계도는 자동차가 아니다! 설계도는 실제 존재하는 것이 아니라 개념으로만 있는 것이다. 설계도를 통해 실제 존재하는 흰색 테슬라 모델 Y 자동차를 객체 또는 인스턴스라 한다.

#### 객체-Object
객체는 클래스에서 정의한 속성과 기능을 가진 실체이다. 객체는 서로 독립적인 상태를 가진다.
예를 들어 위 코드에서 student1은 학생1의 속성을 가지는 객체이고, student2는 학생2의 속성을 가지는 객체이다. student1과 student2는 같은 클래스에서 만들어졌지만, 서로 다른 객체이다.

#### 인스턴스-Instance
인스턴스는 특정 클래스로부터 생성된 객체를 의미한다. 그래서 객체와 인스턴스라는 용어는 자주 혼용된다. 인스턴스는 주로 객체가 어떤 클래스에 속해 있는지 강조할 떄 사용한다. 예를 들어 student1 객체는 Student 클래스의 인스턴스다. 라고 표현한다.

#### 객체 vs 인스턴스
둘다 클래스에서 나온 실체라는 의미에서 비슷하게 사용되지만, 용어상 인스턴스는 개게촙다 좀 더 관계에 초점을 맞춘 단어이다. 보통 student1은 Student의 객체이다. 라고 말하는 대신 student1은 student의 인스턴스이다. 라고 특정 클래스와의 관걔를 명확하게 할 때 인스턴스라는 용어를 주로 사용한다.
좀 더 쉽게 풀어보자면, 모든 인스턴스는 객체이지만, 우리가 인스턴스라고 부르는 순간은 특정 클래스로부터 그 객체가 생성되었음을 강조하고 싶을 떄이다. 얘를 들어 student1은 객체이지만, 이 객체가 Student 클래스로부터 생성되다는 점을 명확히 하기 위해 student1을 Student의 인스턴스라고 부른다.

**하지만 둘다 클래스에서 나온 실체라는 핵심 의미는 같기 떄문에 보통 둘을 구분하지 않고 사용한다.**

## 배열

배열을 사용하면 특정 타입을 연속한 데이터 구조로 묶어서 편리하게 관리할 수 있다.
Student 클래스를 사용한 변수들도 Student 타입이기 떄문에 학생도 배열을 사용해서 하나의 데이터 구조로 묶어서 관리할 수 있다.

```java
Student[] students = new Student[2];
```
* Student 변수를 2개 보관할 수 있는 사이즈 2의 배열을 만든다. 
* Student 타입의 변수는 Student 인스턴스의 참조값을 보관한다. Student 배열의 각각의 항목도 Student 타입의 변수일 뿐이다. 따라서 Student 타입의 참조값을 보관한다.
   * Student1, Student2 변수를 생각해보면 Student 타입의 참조값을 보관한다.
* 배열에는 아직 참조값을 대입하지 않았기 떄문에 참조값이 없다는 의미의 null 값으로 초기화 된다.

#### 자바에서 대입은 항상 변수에 들어 있는 값을 복사한다.
student1, student2에는 참조값이 보관되어 있다. 따라서 이 참조값이 배열에 저장된다. 또는 student1, student2에 보관된 참조값을 읽고 복사해서 배열에 대입한다고 표현한다.

이제 배열은 x001, x002의 참조값을 가진다. 참조값을 가지고 있기 떄문에 x001(학생1), x002(학생2) Student 인스턴스에 모두 접근할 수 있다.

```java
students[0] = student1;
students[1] = student2;
```

#### 주의!

>변수에는 인스턴스 자체가 들어있는 것이 아니다! 인스턴스의 위치를 가리키는 참조값이 들어있을 뿐이다. 따라서 대입(=)시에 인스턴스가 복사되는 것이 아니라 참조값만 복사된다.

