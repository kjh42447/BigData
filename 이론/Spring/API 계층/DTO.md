# DTO
Data Transfer Object의 약자로, 데이터 전송을 위한 객체이다. 

### DTO 사용 목적
1. 코드의 간결화 : 많은 수의 파라미터와 해당 파라미터의 가본적인 처리를 하나의 DTO 객체로 묶어버린다.
2. 데이터 유효성 검증의 단순화 : DTO 클래스에서 해당하는 애너테이션을 추가하여 간단하게 데이터 유효성 검증을 할 수 있다.
3. HTTP 요청 수 감소 : 데이터를 캡슐화 하여 유연한 대처가 가능

### HTTP Request Body가 Json인 경우의 DTO 적용
1. DTO 클래스 생성

    ```java
    @Getter
    @Setter
    @NoArgumentConstructor
    pubilc void MemberDTO{
        private long memberId;
        @Email
        private String email;
        private String name;
    }
    ```

2. Controller 클래스에 DTO 적용

    ```java
    @RestController
    @RequestMapping("/v1/members")
    public class MemberController {
        // 회원 정보 등록
        @PostMapping
        public ResponseEntity postMember(@RequestBody MemberPostDto memberDto.POST) {   //@RequestBody 에너테이션 추가
            return new ResponseEntity<>(memberDto.POST, HttpStatus.CREATED);
        }

        // 회원 정보 수정
        @PatchMapping("/{member-id}")
        public ResponseEntity patchMember(@PathVariable("member-id") long memberId,
                                        @RequestBody MemberPatchDto memberDto.PATCH) {
            memberDto.PATCH.setMemberId(memberId);
            memberDto.PATCH.setName("홍길동");

            // No need Business logic

            return new ResponseEntity<>(memberDto.PATCH, HttpStatus.OK);
        }
    ...
    }
    ```
### Json 직렬화, 역직렬화
Json 직렬화 : 서버에서 클라이언트로 응답 데이터를 전송하기 위해 자바 객체를 Json 형식으로 변환하는 것
Json 역직렬화 : 서버에서 클라어언트로부터 전송 받은 요청 데이터를 Json 형식에서 자바 객체로 변환하는 것

### DTO 유효성 검증
일반적으로 프론트엔드에서 1차적으로 데이터 유효성 검증을 하고 전달을 준다. 하지만 혹시나 모를 상황 및 비즈니스 로직 처리 중 발생할 수 있는 예외 케이스 등 때문에 서버에서도 유효성 검증을 하는 것이 좋다.

Spring Boot에서 유효성 검증을 위해 Starter라는 라이브러리를 지원해준다. 해당 라이브러리를 사용하기 위해 build.gradle의 dependencies 항목에 'org.springframework.boot:spring-boot-starter-validation’를 추가해준다. 또한 각 파라미터와 DTO 클래스의 필드에 해당하는 에너테이션을 추가해준다.

##### 유효성 검증 주요 에너테이션
- @Email : 이메일 형식인지 검증
- @notBlank : null과 공백이 아닌지 검증
- @pattern : 주어진 정규표현식 조건에 해당하는지 검증 
- @Min : 최솟값 이상인지 검증

##### Custom Validator를 사용한 유효성 검증
1. Custom Annotation 정의

    ```java
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    @Constraint(validatedBy = {NotSpaceValidator.class})
    public @interface NotSpace {
        String message() default "공백이 아니어야 합니다";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
    ```
2. Custom Validator 구현 

    ```java
    public class NotSpaceValidator implements ConstraintValidator<NotSpace, String> {

        @Override
        public void initialize(NotSpace constraintAnnotation) {
            ConstraintValidator.super.initialize(constraintAnnotation);
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext context) {
            return value == null || StringUtils.hasText(value);
        }
    }
    ```

3. 구현한 Costom Annotation 사용