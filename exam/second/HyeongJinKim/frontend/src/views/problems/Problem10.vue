<!-- 
    [ 복합 문제 10 ~ 14 ]
    사용자의 종류엔 일반, 사업자 두 종류가 있습니다.
    사업자 회원의 경우엔 사업자 등록번호 10자리를 추가로 입력 받도록 합니다.

    10. 작업을 진행하기 위한 Backlog를 작성해보세요.

    ================================================
    VAP [VUE-ACCOUNT-PROBLEM]
    사용자가 회원 정보를 입력할 페이지 구현 [VAP-SINGUP-1]
        Success Criteria
        1. 사용자가 email, password, role, bussinessNumber을 입력 할 수 있는 페이지 구현

        To-Do
        - email, password는 Text 형식으로 한다
        - role은 select로, 개인회원과 사업자회원을 나눈다
        - bussinessNumber은 Number형식으로 입력 할 수 있도록 한다.
        - role이 개인(NORMAL)이라면 bussinessNumber 입력칸을 비활성화한다.
        - 회원가입 버튼을 만든다.

    사용자가 입력한 회원 정보를 backend에 전송 [VAP-SIGNUP-2]
        Success Criteria
        1. 사용자가 입력한 정보를 backend에 전송한다

        To-Do
        - 사용자가 입력한 정보를 axois.post로 backend에 전송
    ================================================
    SAP [SPRING-ACCOUNT-PROBLEM]
    입력받은 회원 정보를 Db에 저장한다. [SAP-SIGNUP-1]
        Success Criteria
        1. front에서 입력받은 정보를 Db에 저장한다

        To-Do
        - 계정 정보가 담긴 객체를 Db에 저장
    ================================================
 -->
