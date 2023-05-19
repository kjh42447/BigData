# Reactive Programming
리액티브 시스템(클라이언트의 요청에 반응을 잘 하는 시스템)에서 사용되는 프로그램이 모델을 의미한다. 여기서의 반응은 스레드의 Non-Blocking과 관련이 있다. 즉 클라이언트의 요청에 대한 응답 대기 시간을 최소화 할 수 있도록 요청 쓰레드가 차단되지 않게 함으로써(Non-Blocking) 클라이언트에게 즉각적으로 반응하도록 구성된 시스템을 리액티브 시스템이라고 하고, 해당 시스템에서 사용되는 모델을 의미한다.

### Reactive System의 특징
- MEANS : 리액티브 시스템에서 사용하는 커뮤니케이션 수단

    - Message Driven : 리액티브 시스템에서는 메시지 기반 통신을 통해 여러 시스템 간에 느슨한 결합을 유지


- FORM : 메시지 기반 통신을 통해 리액티브 시스템이 어떤 특성을 가지는 구조로 형성되는지를 의미

    - Elastic : 시스템으로 들어오는 요쳥량과 무관하게 일정한 응답성을 유지
    - Resillient : 시스템의 일부에 장애가 발생하더라도 응답성을 유지


- VALUE : 리액티브 시스템의 핵심 가치가 무엇인지를 표현하는 영역

    - Responsive : 클라이언트의 요청에 즉각적으로 응답할 수 있어야 함
    - Maintainable : 클라이언트의 요청에 대한 즉각적인 응답이 지속가능해아 함
    - Extensible : 클라이언트의 요청에 대한 처리량을 자동으로 확장하고 축소할 수 있어야 함


### Reactive programming 특징
- 선언형 프로그래밍 패러다임
- 지속적인 데이터 발생 및 변경

### Reactive Streams
리액티브 프로그래밍을 위한 표준 사양(specification)을 의미한다.

### Reactive Streams Component(Interface)
- Publisher : 데이터 소스로부터 데이터를 내보내는 역할
- Subscriber : Publisher로부터 내보내진 데이터를 소비하는 역할
- Subscription : Subscriber의 구독 자체를 표현
- Processor : Subscriber와 Publisher를 상속하여 두 역할을 동시에 수행 가능

### Reactive Streams implementaiton
- Project Reactor
- RxJava
- Java Flow API

### Reactive Programming 주요 용어
- Emit : Publisher가 데이터를 내보내는 것
- Signal : Publisher가 발생시키는 이벤트
- Operator : 동작을 수행하는 메서드
- Sequence : Operator 체인으로 표현되는 데이터의 흐름
- Upstream / Downstream : Sequence 상의 특정 Operator를 기준으로 위쪽의 Sequence 일부를 Upstream, 아래 쪽 Sequence 일부를 Downstream이라고 표현