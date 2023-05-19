# 서비스 계층에서의 DI
### DI를 통한 서비스 계층과 API 계층 연동
1. 기능을 담당하는 메인 클래스 작성

    ```java
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public class Member {
        private long memberId;
        private String email;
        private String name;
        private String phone;
    }
    ```

2. ResponseDto 클래스 생성

    ```java
    @Getter
    @AllArgsConstructor
    public class MemberResponseDto {
        private long memberId;

        private String email;

        private String name;

        private String phone;
    }
    ```

3. Mapper 인터페이스 정의

    ```java
    @Mapper(componentModel = "spring")  // 빌드 시 매퍼 클래스 자동 구현
    public interface MemberMapper {
        Member memberPostDtoToMember(MemberPostDto memberPostDto);
        Member memberPatchDtoToMember(MemberPatchDto memberPatchDto);
        MemberResponseDto memberToMemberResponseDto(Member member);
    }
    ```
    @Mapper를 이용하여 자동으로 Mapper 클래스를 생성하기 위해선 다음 의존 라이브러리를 build.gradle에 추가해야 한다.
    implementation 'org.mapstruct:mapstruct:1.4.2.Final'
	annotationProcessor 'org.mapstruct:mapstruct-processor:1.4.2.Final'

4. 비즈니스 로직을 처리하는 Service 클래스 작성

    ```java
    @RestController
    @RequestMapping("/v4/members")
    @Validated
    public class MemberController {
        private final MemberService memberService;
        private final MemberMapper mapper;

            // (1) MemberMapper DI
        public MemberController(MemberService memberService, MemberMapper mapper) {
            this.memberService = memberService;
            this.mapper = mapper;
        }

        @PostMapping
        public ResponseEntity postMember(@Valid @RequestBody MemberPostDto memberDto) {
                    // (2) 매퍼를 이용해서 MemberPostDto를 Member로 변환
            Member member = mapper.memberPostDtoToMember(memberDto);

            Member response = memberService.createMember(member);

                    // (3) 매퍼를 이용해서 Member를 MemberResponseDto로 변환
            return new ResponseEntity<>(mapper.memberToMemberResponseDto(response), 
                    HttpStatus.CREATED);
        }
        ...
    }
    ```
