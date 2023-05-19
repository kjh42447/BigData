# Controller

클라이언트의 HTTP 요청을 직접적으로 전달 받는 엔드포인트 클래스이다. 

### 주요 에너테이션
- @RestController : 해당 클래스가 REST API 리소스를 처리하기 위한 API 엔드포인트로 동작함을 정의, 어플리케이션 로딩 시 Spring Bean으로 등록해준다.
- @RequestMapping : 클라이언트의 요청과 핸들러 메서드(클라이언트의 요철을 처리할 메서드)를 매핑해주는 역할, 클래스 레벨에서 선언 시 공통 URL로 사용
- @PostMapping : 클라이언트의 요청 데이터를 서버에 생성해주는 역할, 각 HTTP 메서드 타입별로 동일하게 동작
- @RequestParam : 클라이언트의 요청 데이터 타입이 쿼리 파라미터, 폼 데이터, x-www-form-urlencoded 형식이면 서버 쪽에서 전달 받을 때 사용.
- @PathVariable : 리퀘스트의 URL 중 특정 값을 파라미터로 받고 싶을 경우 사용. @RequestMapping의 {템플릿 변수} 부분과 동일한 이름으로 사용.

### ResponseEntity
HttpStatus, HttpHeader, HttpBody를 포함하는 클래스이다. 물론 String으로 응답 데이터를 리턴해도 되지만 ResponseEntity로 한번 매핑해주는 것이 더 깔끔하기도 하고 다른 작업을 처리하기도 수월해진다.