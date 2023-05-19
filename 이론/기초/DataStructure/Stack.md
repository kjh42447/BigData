자바에서 Stack은 Java.util.Vector클래스를 상속받아 이미 구현되어있다.
주요 메소드및 사용법은 다음과 같다.  

- E push(E item) : item을 스택에 집어넣는다.
- E pop() : 스택 최상단의 값을 꺼내서 리턴한다.
- E peek() : 스택 최상단의 값을 꺼내지 않고 리턴한다.
- boolean empty() : 스택이 비어있는지 확인한다.
- int search(Object o) : o가 있으면 스택의 가장 높은 곳에 있는 o의 인덱스를 반환한다. 없을 경우 -1을 반환한다.