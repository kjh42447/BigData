# Spring WebFlux
 Spring 5부터 지원하는 리액티브 웹 애플리케이션을 위한 웹 프레임워크이다. 

 ### Spring WebFlux과 Spring MVC 차이
 - Non-Blocking - Blocking
 - Reactive Adapter를 사용하여 다른 리액티브 라이브러리 사용 가능 - Servlet API에 의존적
 - Spring Security WebFilter(Reactive) - Spring Security SurvlitFilter
 - Reactive Stack을 데이터 엑세스 계층까지 확장(R2DBC) - JDBC

 ### Spring WebFlux과 Spring MVC 기술 스택 비교
 - 공통 : @Controller, Reactive clients, Tomcat, Jetty, Undertow 등
 - MVC : JDBC, JPA 등
 - WebFlux : Netty 등