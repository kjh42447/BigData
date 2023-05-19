# Spring Security
Spring MVC 기반 어플리케이션의 인증과 인가 기능을 지원하는 사실상 보안 표준 프레임워크이다.

### Spring Security로 할 수 있는 보안 강화 기능
1. 다양한 유형(폼 로그인 인증, 토큰 기반 인증, OAuth2 기반 인증, LDAP인증 등)의 사용자 인증 기능 적용
2. 어플리케이션 사용자의 역할에 따른 권한 레벨 적용
3. 어플리케이션에서 제공하는 리소스에 대한 접근 제어
4. SSL 적용
5. 데이터 암호화
6. 잘 알려진 웹 보안 공격 차단
...

### 주요 용어 정리
- Principal(주체) : 어플리케이션에서 작업을 수행할 수 있는 사용자, 디바이스 또는 시스템 등. 일반적으로는 인증된 사용자의 계정 정보를 의미
- Authentication(인증) : 사용자가 본인이 맞음을 증명하는 절차. 인증을 수행하기 위해 필요한 사용자 식별 정보를 Credential(신원 증명 정보)라고 한다.
- Authorization(인가) : 인증이 정상적으로 수행된 사용자에게 하나 이상의 권한을 부여하여 특정 리소스에 접근을 허가하는 것. 반드시 인증 이후 수행되어야 한다.
- Access Control(접근 제어) : 사용자가 어플리케이션의 리소스에 접근하는 행위를 제어하는 것

### Spring Security의 웹 요청 처리 흐름
##### 보안이 적용된 웹 요청의 일반적인 처리 흐름
1. 사용자가 보호된 리소스를 요청
2. 인증 관리자 역할을 하는 컴포넌트가 Credential(일반적으로 패스워드)을 요청
3. 사용자는 인증 관리자에게 Credential을 제공
4. 인증 관리자는 사용자의 Credential을 조회
5. 인증 관리자는 사용자의 Credential과 저장소의 Credential을 비교해서 검증
6. 유효한 Credential이 아니라면 Exception throw
7. 유효한 Credential이면 접근 결정 관리자 역할을 하는 컴포넌트는 사용자가 적절한 권한을 부여받았는지 검증
8. 적절한 권한을 부여 받지 못한 사용자면 Exception throw
9. 적절한 권한을 부여 받은 사용자라면 보호된 리소스 접근 허용

##### 웹 요청에서의 서블릿 필터와 필터 체인 역할
서블릿 필터 : 어플리케이션의 엔드포인트에 요청이 도달하기 전에 중간에서 요청을 가로챈 후 처리를 할 수 있는 포인트(API, 인터페이스)로 하나 이상의 필터을을 연결해 필터 체인을 구성할 수 있다. 

### Spring Security의 인증 처리 흐름
1. 사용자가 ID와 PW를 포함한 요청을 Spring Security가 적용된 어플리케이션에 전송하면 Filter Chain의 UsernamePasswordAuthenticationFilter가 해당 요청을 전달 받는다.
2. UsernamePasswordAuthenticationFilter는 UsernamePasswordAuthenticationToken을 생성
3. 아직 인증되지 않은 Authentication을 가지고 있는 UsernamePasswordAuthenticationFilter는 Authentication을 AuthenticationManager(인터페이스, 구현 클래스는 ProviderManager)에게 전달
4. ProviderManager는 해당 Authentication을 AuthenticationProvider로 전달
5. AuthenticationProvider는 UserDetailsService를 이용해 UserDetails(ID, PW, 권한 정보를 가지고 있는 컴포넌트) 조회
6. DB 등에서 조회한 Credential을 기반으로 UserDetails를 생성하고 AuthenticationProvider에 전달
7. AuthenticationProvider는 PasswordEncoder를 이용해 PW 일치 검증, 성공하면 UserDetails를 이용해 인증된 Authentication을 생성. 실패 시 Exception
8. AuthenticationProvider는 인증된 Authentication을 ProviderManager에 전달
9. ProviderManager는 인증된 Authentication을 UsernamePasswordAuthenticationFilter에 전달
10. UsernamePasswordAuthenticationFilter는 SecurityContextHolder를 이용해 SecurityContext에 인증된 Authentication을 저장

### Spring Security의 권한 부여 처리 흐름
1. Spring Security Filter Chain의 AuthorizationFilter는 SecurityContextHolder로 부터 Authentication을 획득
2. AuthorizationFilter는 Authentication과 HttpServletRequest를 AuthorizationManager(인터페이스)에 전달
3. AuthorizationManager의 구현체 중 하나인 RequestMatcherDelegatingAuthorizationManager내부에서 매치되는 AuthorizationManager구현 클래스가 있다면 해당 AuthorizationManager구현 클래스가 사용자의 권한을 체크
4. 적절한 권한이라면 다음 프로세스를 진행, 적절한 권한이 아니라면 AccessDeniedException throw 되고 ExceptionTranslationFilter가 Exception처리