# 예외(Exception)

자바에서 오동작이나 결과에 악영향을 미칠 수 있는 실행 중 발생한 오류를 예외(exception)라고 한다.
문법에 맞지 않게 작성된 코드는 사전에 컴파일러에 의해 파일 오류(copile time error)로 걸러지지만, 예외는 사용자의 잘못된 입력이나
배열의 인덱스가 배열의 크기를 넘어가는 등, 예기치 못한 상황에 의해 프로그램 실행중에 발생한다.

* 정수를 0으로 나누는 경우
* 배열의 크기보다 큰 인덱스로 배열의 원소를 접근하는 경우
* 존재하지 않는 파일을 읽으려고 하는 경우
* 정수 입력을 기다리는 코드가 실행되고 있을 떄, 사용자가 문자를 입력한 경우

실행 중에 예외가 발생하면 자바 플랫폼이 가장 먼저 알게 되어, 현재 실행 중인 응용프로그램에게 예외를 전달한다. 만일 응용프로그램이 예외에 대처하는 코드를 가지고 있지 않다면, 
자바 플랫폼은 응용프로그램을 곧바로 종료시킨다.

#### 잠깐!
예외(exception)와 실행시간 오류(run-time error)는 어덯게 다른가? 실행시간 오류는 조건문이 잘못 작성된 반복문이 무한루프를 실행하거나. recursion을 제어하는 코드를 잘못
작성하여 스택이 계속 쌓여(스택 오버플로) JVM의 메모리가 부족할 때까지 실행되는 등 언제 어디서 발생할지 예측할 수 없고 발생하였을 때 시스템이나
사용자에게 해를 주거나 강제로 프로그램을 종료시키지 않으면 멈출 수 없는 경우이다.

하지만 예외란 사용자 프로그램에서 try-catch 블록을 이용하여 제어할(handling) 수 있는 실행시간 오류이다. 
파일을 여는 코드나 나누기 하는 코드 등을 작성할 때 파일을 열지 못할 수 있고, 0으로 나누기가 이루어질 수 있음을 알고, 또 이런 상황에
발생하였을 때는 try-catch 블록을 이용하여 문제를 바로 잡아(recoverable) 계속 실해오디게 하거나, 
시스템이나 사용자에게 해를 끼치지 않으면서 정상적인 방법으로 프로그램을 종료시킬 수 있도록 제어 가능한 경우다.

```java
import java.util.Scanner;

public class DivideByZero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dividend;
        int divisor;

        System.out.print("나뉨수를 입력하시오 : ");
        dividend = scanner.nextInt();
        System.out.print("나눗수를 입력하시오 : ");
        divisor = scanner.nextInt();
        System.out.println(dividend + "를 " + divisor + "로 나누면 몫은 " + dividend/divisor + "입니다.");
        scanner.close();
    }
}
```

두 정수를 입력받아 나눗셈을 하고 몫을 구하는 프로그램 코드이다. 사용자가 나누는 수에 0을 입력하면 ArithmeticException 예외가 발생하여 프로그램이 강제 종료된다.

## 예외 처리, try-catch-finally 문
예외 처리란, 개발자가 박성한 프로그램의 실행 중에 예외가 발생하면 이에 대응하는 것을 말한다. 
자바는 예외 처리를 위해 **try-catch-finally** 문을 사용한다. 사용법은 다음과 같다.
```java
try {
    예외가 발생할 가능성이 있는 실행문 (try 블록)
} 
catch (처리할 예외 타입 선언) {
    예외처리문(catch 블록)
}
finally {
    예외 발생 여부와 상관없이 무조건 실행되는 문장(finally 블록)
}
```
* 예외가 발생할 가능성이 잇는 실행문들은 try{} 블록으로 묶고, 예외 처리 코드는 catch{}블록 내에 작성한다.
* catch() 문의 ( ) 안에는 처리하고자 하는 예외의 타입을 선언한다. catch{ }블록은 예외마다 하나씩 작성되어야 한다.
* finally { } 블록은 생략해도 상관없으며 실제 많은 경우 생략한다. finally 블록은 예외가 발생하든 않든 마지막에 실행된다.

## 자바의 예외 클래스
응용프로그램에서는 자바 플랫폼에서 제공하는 예외 클래스를 이요하여 예외 발생을 탐지할 수 있다.
실행 중 try 블록 내에서 예외가 발생되면, 자바 플랫폼은 catch()문의 '처리할 예외 타입 선언'부에 객체로 만들어 전달한다. 
예외 객체는 발생한 예외에 대한 정보를 제공한다.

| **예외 타입**                      | **예외 발생 경우** | **패키지**   |
|--------------------------------|--------------|-----------|
| ArithmeticExceoption           |정수를 0으로 나눌 때 발생| java.lang |
| NullPointerExxceoption         |null 레퍼런스를 참조할 때 발생 | java.lang |
| ClassCastException             |변환할 수 없는 타입으로 객체를 변환할 떄 발생| java.lang |
| OutOfMemoryError               |메모리가 부족한 경우 발생| java.lang |
| ArrayIndexOutOfBoundsException |배열의 범위를 벗어난 접근 시 발생| java.lang |
| IllegalArgumentException       |잘못된 인자 전달 시 발생|java.lang|
| IOException                    |입출력 동작 실패 또는 인터럽트 시 발생|java.io|
| NumberFormatException          |문자열이 나타내는 숫자와 일치하지 않는 타입의 숫자로 변환 시 발생 | java.lang|
| InputMismatchException         | Scanner클래스의 nextInt()를 호출하여 정수로 입력받고자 하였지만, 사용자가 'a'등과 같이 문자를 입력한 경우 | java.util                      |

```java
int intArray [] = new int[5];
try {
    intArray[3] = 2;
    intArray[6] = 5;
}

catch(ArrayIndexOutOfBoundsException e) {
    System.out.println("배열의 범위를 초과하여 원소를 접근하였습니다.");
}
```
다수의 예외를 처리하고자 하는 경우에는 여러 개의 catch블록을 연속적으로 작성할 수 있으며, 발생한 예외와 타입이 일치하는 catch 블록이 실행된다.
만일 발생한 예외 타입과 일치하는 catch 블록이 없으면 프로그램은 강제 종료된다. catch블록 내에서 System.exit(0)을 호출하면 언제든지 프로그램을 종료할 수 있다.

#### 0으로 나눌 때 발생하는 ArithmeticException 예외 처리
```java
import java.util.Scanner;

public class DevideByZeroHandling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while(ture) {
            System.out.println("나뉨수를 입력하시오 : ");
            int dividend = scanner.nextInt();
            System.out.println("나눗수를 입력하시오 : ");
            int divisor = scanner.nextInt();
            try {
                System.out.println(dividend + "를 " +divisor + "로 나누면 몫은 " + dividend/divisor + "입니다.");
                break; //정상적인 나누기 완료 후 while 벗어나기
            }
            catch (ArithmeticException e) {
                System.out.println("0으로 나눌 수 없습니다.! 다시 입력하세요!");
            }
        }
        scanner.close();
    }
}
```

#### 범위를 벗어난 배열의 접근(ArrayIndexOutOfBoundsException)
```java
public class ArrayException {
    public static void main(String[] args) {
        int[] intArray = new int[5];
        intArray[0] = 0;
        try {
            for(int i = 0; i < 5; i++) {
                intArray[i+1] = i+1 + intArray[i]; //i = 4인 경우 예외 발생
                System.out.println("intArray["+ i + "]" + "=" + intArray[i]);
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println("배열의 인덱스가 범위를 벗어났습니다.");
        }
    }
}
```

#### 입력 오류 시 발생하는 예외(InputMismatchException)

```java
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("정수 3개를 입력하세요");
        int sum = 0, n = 0;
        for (int i = 0; i < 3; i++) {
            System.out.print(i + ">>");
            try {
                n = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("정수가 아닙니다. 다시 입력하세요!");
                scanner.nextLine(); // 현재 입력 스트림에 남아 있는 토큰을 지운다.
                i--; // 인덱스가 증가하지 않다록 미리 감소
                continue; // 다음 루프
            }
            sum += n;
        }
        System.out.println("합은 " + sum);
        scanner.close();
    }
}
```

#### 정수가 아닌 문자열을 정수로 변환할 때 예외 발생(NumberFormatException)
```java
public class NumException {
    public static void main(String[] args) {
        String[] stringNumber = {"23", "12", "3.141592", "998"};
        
        int i = 0;
        try {
            for( i = 0; i<stringNumber.length; i++) {
                int j = Integer.parseInt(stringNumber[i]);
                System.out.println("정수로 변환된 값은 " + j);
            }
        }
        catch(NumberFormatException e) {
            System.out.println(stringNumber[i] + "는 정수로 변환할 수 없습니다.");
        }
    }
}
```