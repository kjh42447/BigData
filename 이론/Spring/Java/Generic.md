# 제너릭
클래스 내의 데이터 타입을 외부에서 매개변수로 지정할 수 있도록 일반화 하는 것

형식
```java
접근제어자 class(interface) 클래스명<타입매개변수> {
    접근제어자 타입매개변수 변수명;
    접근제어자 타입매개변수 메소드명(매개변수...) {...}
    접근제어자 <타입매개변수> 메소드명(매개변수...) {...}
}
```

예시
```java
public class GenericTest<T> {
    public T t;
    public T TTest(T tt) {...}
    public <E> ETest(E ee) {...}
}
```

# 와일드카드
데이터 타입에 제한을 두지 않는다. ?로 표시한다.

예시
```java
void printCollection(Collection<?> c) {
    for (Object e : c) {
        System.out.println(e);
    }
}
```