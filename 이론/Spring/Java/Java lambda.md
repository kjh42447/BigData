# 자바 람다  
자바는 대표적인 객체지향언어이므로 람다 식을 사용하기 위해 함수형 인터페이스를 시용한다. 사용 방식은 여느 언어들과 동일하다.
자주 사용하는 함수형 인터페이스는 자바에서 기본적으로 제공하기 때문에 따로 생성하여 사용하지 않아도 된다.  

사용 예시
```java
//일반적인 함수
int sum(int num1, int num2) {
    return num1 + num2;
}

//람다식
(int num1, int num2) -> {
    num1 + num2 //return시 return과 세미콜론은 생략 가능
}

//향상된 람다식
(num1 + num2) -> num1 + num2    //매개변수 타입 유추가 쉬울 경우, 생략 가능
```

# 메서드 참조(Method Reference)
람다식에서 매서드를 간단하게 호출하고 싶을 때 사용한다.  

- 정적 메서드 : 클래스명::메서드명
- 인스턴스 메서드 : 인스턴스명::메서드명  

사용 예시
```java
//일반적인 함수
class Carlculator {
    int sum(int num1, int num2) {
        return num1 + num2;
    }
}

//매서드 참조
Calculator sum_method = Calculator::sum;

//생성자 참조
Calculator cal = Calculator::new;    //매개변수 타입 유추가 쉬울 경우, 생략 가능
```