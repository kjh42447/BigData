# Spring MVC
Servlet API를 기반으로 클라이언트의 요청을 처리하는 모듈인 spring-webmvc 의 줄임말, Spring MVC 프레임워크라고도 부른다.
   
### MVC의 의미
- M(Model) : 클라이언트에게 응답으로 돌려주는 작업의 처리 결과 데이터
- V(View) : Model의 데이터를 이용해서 클라이언트 어플리케이션 화면에 보여지는 리소스를 제공
- C(Controller) : 클라이언트 측의 요청을 직접적으로 전달 받는 엔드포인트, Model과 View 사이에서 상호 작용 담당
   
### Spring MVC 동작 방식 및 구성요소
![Spring MVC 동작 방식 및 구성요소](https://s3.ap-northeast-2.amazonaws.com/urclass-images/mOBBYB4R6JbDjgJ32DNif-1655088735317.png)
1. 클라이언트가 요청을 전송하면 DispatcherServlet 클래스에 요청이 전달
2. DispatcherServlet은 해당 요청을 처리할 Controller에 대한 검색을 HandlerMapping 인터페이스에 요청
3. HandlerMapping에서 해당하는 핸들러 객체(Controller 클래스 내에 구현된 요청 처리 메서드를 포함한 객체) 리턴
4. DispatcherServlet에서 HandlerAdapter에 핸들러 메서드 호출을 위임
5. HandlerAdapter에서 해당 Controller의 핸들러 메서드 호출
6. Controller에서 요청에 대한 비즈니스 로직 처리 후 리턴 받은 Model 데이터를 HandlerAdapter에 전달
7. HandlerAdapter는 해당 Model 데이터와 View 정보를 DispatcherServlet에 전달
8. DispatcherServlet은 해당 View 정보를 ViewResolver에 검색 요청
9. ViewResolver는 해당하는 View 객체 리턴
10. DispatcherServlet은 전달 받은 View 객체에 Model 데이터를 넘겨주고 클라이언트에게 전달할 응답 데이터 생성을 요청
11. View는 응답 데이터를 리턴
12. DispatcherServlet는 전달 받은 응답 데이터를 클라이언트에게 전달