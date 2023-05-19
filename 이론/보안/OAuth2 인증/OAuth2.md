# OAuth2
보안된 리소스에 접근하기 위해 클라이언트에게 권한을 제공하는 프로세스를 단순화하는 프로토콜 중 한 방법.

### OAuth2 workflow
1. User가 외부 계정으로 어플리케이션에 접근 요청
2. 어플리케이션에서 외부 사이트에 인증 요청
3. 외부 사이트에서 User 인증
4. 외부 사이트에서 어플리케이션에 인증 및 접근 권한 정보 전달(토큰으로 해당 데이터 저장)

### OAuth2 주요 용어
- Resource Owner : 엑세스 중인 리소스의 유저
- Resource server : 클라이언트의 요청을 수락하고 응답할 수 있는 서버
- Authorization server : Resource server가 엑세스 토큰을 발급받는 서버
- Authorization grant : 클라이언트가 엑세스 토큰을 얻을 때 사용하는 자격 증명(방법)
- Authorization code : 엑세스 토큰을 발급 받기 전에 필요한 코드

### OAuth2와 JWT를 이용하여 CSR 방식 인증 처리 흐름
1. User가 프론트엔드에 로그인 요청
2. 프론트엔드에서 백엔드로 요청 전송
3. 구글의 로그인 화면을 요청하는 URI로 리다이렉트. 이 때 Authorization Server가 백엔드 쪽으로 Authorization Code를 전송할 Redirect URI를 쿼리 파라미터로 전달. Redirect URI는 Spring Security가 내부적으로 제공
4. 구글 로그인 화면 오픈
5. User가 로그인
6. 로그인에 성공하면 3의 Redirect URI로 Authorization Code 요청 (6부터 11까지는 Spring Security에서 자체적으로 처리)
7. Authorization Server가 백엔드 쪽으로 Authorization Code 전달
8. 백엔드에서 Authorization Server로 Access Token 요청
9. Authorization Server가 백엔드 쪽으로 Access Token 전달
10. 백엔드에서 Resource server로 User Info 요청
11. Resource server는 백엔드로 User Info 전달
12. 백엔드는 JWT로 구성된 Access Token과 Refresh Token을 생성 후, 프론트엔드로 JWT를 리다이렉트