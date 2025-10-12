# OOP Lab1 + Homework 2

## 학습 목표

이 실습은 객체지향프로그래밍의 핵심 개념을 실습하며, Homework 2(미니 프로젝트) 수행을 위한 기초를 다지는 과정입니다.

- 클래스, 상속, 다형성, 인터페이스 실습  
- 캡슐화, 예외 처리, 컬렉션 프레임워크 활용  
- 코드 품질 향상을 위한 리팩토링 감각 익히기

## 실습 환경

- GitHub Codespaces
- 오른쪽 위 Code -> Codespaces -> + 클릭 (Create a codespace on main)
  
## STEP 1. 클래스와 객체의 기본

###  개념 요약
- **클래스(Class)**: 객체의 설계도  
- **객체(Object)**: 클래스로부터 생성된 실체  
- **인스턴스 변수**: 객체마다 독립적으로 존재  
- **메서드**: 객체가 수행할 수 있는 동작  


### 실습 코드
```java
class Rectangle {
    private double width;
    private double height;

    // 생성자
    Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    // 넓이 계산
    double area() {
        return width * height;
    }

    // Getter/Setter
    public double getWidth() { return width; }
    public void setWidth(double w) { width = w; }
    public double getHeight() { return height; }
    public void setHeight(double h) { height = h; }

}

class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 10);
        System.out.println("넓이: " + r.area());
    }
}

```

### TODO LIST
- `toString()`을 오버라이드해서 출력 형식 개선  
- 생성자 오버로딩 (기본값 생성자 추가)  

## STEP 2. 상속(Inheritance)과 다형성(Polymorphism)

### 개념 요약
- 상속: 기존 클래스의 특성을 확장해 새로운 클래스를 만드는 것  
- 다형성: 같은 타입으로 서로 다른 객체를 다루는 능력  


### 실습 코드
```java
class Animal {
    void sound() { System.out.println("(동물이 소리를 냅니다)"); }
}

class Dog extends Animal {
    @Override
    void sound() { System.out.println("멍멍!"); }
}

class Cat extends Animal {
    @Override
    void sound() { System.out.println("야옹!"); }
}

public class Main {
    public static void main(String[] args) {
        Animal a1 = new Dog();
        Animal a2 = new Cat();

        a1.sound();  // 멍멍!
        a2.sound();  // 야옹!
    }
}
```

### TODO List
- `Bird` 클래스를 추가하고 `fly()` 메서드 구현  
- `ArrayList<Animal>`을 만들어 다양한 동물을 한꺼번에 관리  

## STEP 3. 인터페이스와 추상 클래스

### 개념 요약
- **추상 클래스**: 공통 뼈대를 제공하지만 일부 구현은 자식에게 위임  
- **인터페이스**: 동작 규약만 정의, 다중 구현 가능  
- **implements** 키워드로 구현, **extends**는 상속  

### 실습 코드
```java
class CardPayment {
    public void pay(int amount) {
        System.out.println("카드 결제: " + amount + "원");
    }
}

class PaypalPayment {
    public void pay(int amount) {
        System.out.println("페이팔 결제: " + amount + "원");
    }
}

public class Main {
    public static void main(String[] args) {
        CardPayment cardPayment = new CardPayment();
        cardPayment.pay(10000);

        PaypalPayment paypalPayment = new PaypalPayment();
        paypalPayment.pay(15000);
    }
}
```

### TODO List
- `refund()` 기능 추가  
- Strategy 패턴 적용


## STEP 4. 예외 처리 (Exception Handling)

### 개념 요약
- 예외는 프로그램 실행 중 발생하는 오류 상황  
- `try`–`catch`–`finally` 구조로 처리  
- 사용자 정의 예외 클래스를 만들어 특정 상황을 명확히 표현 가능  


### 실습 코드
```java
public class Main {
    public static void main(String[] args) {
        try {
            int a = 0;
            int b = 42 / a;
            //int[] c = { 1 };
            //c[42] = 99;
        } catch(ArithmeticException e) {
            System.out.println("Divide by 0: " + e);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("Array oob: " + e);
        }
    }
}
```

### TODO List
- finally 추가해보기
- Exception으로 예외 잡을 때 문제 살펴보기
- 커스텀 예외 클래스 만들기

## STEP 5. 접근 제어자와 패키지 (Access Control & Packages)

### 개념 요약
- 접근 제어자는 클래스 외부에서 멤버(필드, 메서드)에 접근 가능한 범위를 결정
- 패키지는 클래스를 **논리적으로 그룹화**하고, 이름 충돌을 방지하는 역할

| 제어자 | 접근 가능 범위 | 사용 예시 |
|--------|----------------|-----------|
| `public` | 모든 클래스에서 접근 가능 | API 메서드, 외부 공개 클래스 |
| `protected` | 같은 패키지 + 하위 클래스에서 접근 가능 | 상속 관계에서 사용 |
| (default) | 같은 패키지 내에서만 접근 가능 | 내부 유틸 클래스 |
| `private` | 같은 클래스 내부에서만 접근 가능 | 캡슐화된 데이터 |

### 예제: `User` 클래스의 캡슐화
```java
package user;

public class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    // getter
    public String getName() { return name; }

    // setter
    public void setPassword(String pw) {
        if (pw == null || pw.length() < 8) {
            throw new IllegalArgumentException("비밀번호는 8자 이상이어야 합니다.");
        }
        this.password = pw;
    }
}
```

```java
package main;
import user.User;

public class Main {
    public static void main(String[] args) {
        User u = new User("Alice", "mypassword");
        System.out.println("사용자 이름: " + u.getName());

        // 직접 접근 불가 (private 접근 제한)
        // System.out.println(u.password);

        // setter를 통한 변경
        u.setPassword("securePass123");
    }
}
```

### TODO List
- `protected` 키워드 실습
- 다른 패키지 일 때 접근 제어 실습

## Homework 2

**도서 대출 시스템 (Library System)** 을 구현

핵심 요구사항:  
- 회원 관리, 도서 관리, 대출 관리 기능 구현
- 인터페이스 또는 추상클래스 사용
- 예외 처리 + 컬렉션 활용
- Main.java 클래스에서 도서 대출 시스템을 위한 여러 기능을 테스트 케이스 작성
- SOLID 원칙 몇가지 활용하고 어떻게 활용했는지 제시

### 요구사항

- Homework 2를 수행하여 설계, 구현 과정 및 실행 결과를 `hw2.pdf`로 작성하여 KLAS에 제출
- 보고서 분량은 10페이지 이내
- GitHub Copilot 사용 가능하지만, **실행 결과 분석은 반드시 직접 작성**
