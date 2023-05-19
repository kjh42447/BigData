# API 명세서
### REST API
모든 리소스에 대해 고유한 URI를 부여하고 HTTP Method를 적절히 사용하여 리소스를 제어할 수 있는 수단을 의미한다. 이때 요청에 대한 응답은 JSON이나 XML과 같은 사전 정의된 형식을 사용하여 일관된 방법으로 주고 받습니다. REST의 특징을 몇가지로 정리할 수 있는데 그 특징은 다음과 같다.
- 서버-클라이언트 구조
- 무상태성
- 캐시 기능
- 일관된 인터페이스
- 자체적인 표현 구조
- 계층 구조

### Rest API 규칙
- /로 끝나지 않게 하기
- _말고 - 사용
- 소문자를 사용
- 동사의 사용 피하기
- 확장자 포함 금지

### 관계 나타내기
ex) http://test.com/groups/1/users
- groups, users : 이와 같이 복수로 표현되는 것들은 보통 여러개의 리소스를 갖을 수 있으므로 복수형으로 표시하고 ‘Collection’ 이라고 부른다.
- 1 : Collection에 포함된 대상 리소스는 단수형으로 표시하고 ‘Document’라고 부른다.
- /groups/1/users : Collection과 Document의 관계를 /를 통해 나타낼 수 있습니다. 그룹이라는 Collection 안에 ‘1’ Document를 나타내고, 해당 Document가 갖고 있는 사용자들을 나타낸다.