# Project Reactor
Reactive Streams 명세를 구현한 구현체 중 하나로, Spring 5 버전부터 지원하는 리액티브 스택에 포함되어 리액티브한 애플리케이션으로 동작하는데 있어 핵심적인 역할을 담당하는 리액티브 프로그래밍을 위한 라이브러리이다.

### Reactor 특징
- Reactive library
- Non-Blocking
- Mono(0 or 1 emit), Flux(n emit)의 2가지 타입을 제공
- 서비스 간의 통신이 잦은 MSA(Microservice Architecture)에 적합한 구조
- Backpressure(Subscriber의 처리 속도가 Publihser의 emit 속도를 따라가지 못할 때 적절하게 제어하는 것) 전략 지원

### Backpressure 전략 종류
- Drop : 버퍼가 가득차면 이후에 들어오는 데이터는 버리는 전략
- Latest : 버퍼가 가득차면 가장 나중에 emit된 데이터만 남기고 폐기하는 전략(가득찬 버퍼의 데이터를 폐기하는 것이 아니라 버퍼 뒤의 데이터를 폐기)
- Buffer

    - Drop Latest : 버퍼가 가득차면 버퍼 안에 있는 데이터 중 가장 최근에 버퍼 안에 채워진 데이터를 버리는 전략
    - Drop Oldest : 버퍼가 가득차면 버퍼 안에 있는 데이터 중 가장 오래된 데이터를 버리는 전략


### Reactor의 기본 구성 요소
```java
Flux    // 1. Reactor Sequence 시작
    .just("Hello", "Reactor")   // 2. Publisher
    .map(message -> message.toUpperCase())  // 3. emit한 데이터 가공
    .publishOn(Schedulers.parallel())   // 4. 2개의 스레드 실행
    .subscribe(System.out::println,     // 5. emit한 데이터 처리
            error -> System.out.println(error.getMessage()),    // 6. 에러가 발생한 경우, 에러를 받아서 처리
            () -> System.out.println("# onComplete"));  // 7. Reactor Sequence가 종료 된 후 후처리
```

### Marble Diagram
데이터를 구슬로 표시하여 시간의 흐름에 따라 변화하는 데이터의 흐름을 표현하는 다이어그램이다. '|'는 정상 종료를 의미하고 'X'는 비정상 종료를 의미한다.

### Scheduler
 Reactor Sequence 상에서 처리되는 동작들을 하나 이상의 쓰레드에서 동작하도록 별도의 쓰레드를 제공해준다. 

#### Scheduler 전용 Operator
- subscribeOn() : 구독 직후 실행되는 Operator 체인의 실행 스레드를 스케줄러로 지정한 스레드로 변경
- publishOn() : 추가할 때 마다 publishOn 기준 Downstream쪽 스레드가 publishOn()에서 스케줄러로 지정한 스레드로 변경