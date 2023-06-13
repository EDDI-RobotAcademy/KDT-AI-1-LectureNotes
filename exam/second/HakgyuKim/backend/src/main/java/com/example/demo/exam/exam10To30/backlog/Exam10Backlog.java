package com.example.demo.exam.exam10To30.backlog;

public class Exam10Backlog {
    /*
    Frontend: [ACCOUNT-SIGNUP-VUE]
        Title:
            사용자가 회원가입 할 수 있다 [ASV-1]
        Success Criteria:
            사용자가 회원가입에 필요한 정보를 입력하고 그 정보가 backend로 전달된다
            역할에 따라 필요한 정보를 요청한다
        To-Do:
            회원가입 form 제작
            역할 선택창 구현
            역할에 따라 필요한 정보 입력 칸 구현

    Backend: [ACCOUNT-SIGNUP-SPRING]
        Title:
            사용자가 회원가입 할 수 있고 정보가 저장된다 [ASS-1]
        Success Criteria:
            회원가입 요청이 들어오면 정보를 받아온다
            이메일의 중복을 확인 하고 중복이면 가입 불가능하다고 전달한다
            중복이 아닐 시 사용자 정보를 repository에 저장한다
        To-Do:
            사용자(account) entity 생성
            사용자에 필요한 정보를 받아 올 Form 작성
            사용자 정보 받아오는 PostMapping 작성
            사용자 정보 저장할 수 있는 Repository 생성
            사용자 이메일 중복 체크하고 아니면 저장하는 매서드 service에 작성


        Title:
            사용자 역할 분리 및 역할에 필요한 정보 저장 [ASS-2]
        Success Criteria:
            사용자에게 여러 역할을 만든다
            역할에 맞는 정보를 받아오고 저장한다
        To-Do:
            사용자 역할을 나타낼 AccountRole entity 생성
            역할 구분할 RoleType enum 생성
            역할에 맞게 저장할 매서드 service에 작성
     */
}
