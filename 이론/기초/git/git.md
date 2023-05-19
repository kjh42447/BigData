- 혼자서
    1. fork한 repository 가져오기
    ```bash
    git status
    ```
    2. repository 상태 확인
    ```bash
    git clone repository명
    ```
    3. 로컬 파일을 staging area로 이동
    ```bash
    git add 로컬파일명
    ```
    - add 취소
        ```bash
        git restore 로컬파일명
        ```
    4. staging area의 내용을 commit
    ```bash
    git commit -m "커밋 명"
    ```
    + 커밋 취소
         ```bash
        git reset HEAD-1 
        또는 
        git reset HEAD^
        ```
    5.  commit한 내용을 github repository에 등록
    ```bash
    git push repository명 branch명
    ```
    - 커밋 로그 확인
        ```bash
        git log
        ```
- 여럿이
    1. git 초기화
    ```bash
    git init
    ```
    2. 리모트 연결
    ```bash
    git remote add 내repository명 링크
    ```
    3. 페어의 리모트 연결
    ```bash
    git remote add 페어repository명 링크
    ```
    - 리모트 확인
        ```bash
        git remote -v
        ```
    4. 페어의 작업물 가져오기
    ```bash
    git pull 페어repository명 branch명
    ```
    5. 페어와 merge된 작업물 등록
    ```bash
    git push 내repository명 branch명
    ```
- 충돌 발생 시(같은 원격 repository에 같은 파일이 수정하여 pull할 경우, 충돌 발생)
    1. 충돌 부분 수정 후 staging area에 추가
    ```bash
    git add 로컬파일명
    ```
    2. commit(충돌 수정 후 staging area에 추가하면 자동으로 commit 메시지 생성됨)
    ```bash
    git commit
    ```
    3. push
    ```bash
    git push repository명 branch명
    ```
- 브랜치 관련 명령
    1. 브랜치 목록 확인
    ```bash
    git branch
    ```
    2. 브랜치 생성
    ```bash
    git branch 브랜치명
    ```
    3. 브랜치 이동
    ```bash
    git checkout 브랜치명
    ```
    4. 브랜치 생성 후 해당 브랜치로 이동
    ```bash
    git checkout -b 브랜치명
    ```
    5. 브랜치 병합
    ```bash
    git merge 병합될브랜치명
    ```