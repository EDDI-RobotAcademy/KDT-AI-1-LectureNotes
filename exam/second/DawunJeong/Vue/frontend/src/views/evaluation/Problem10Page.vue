<template lang="">
    <div>
        <h2>문제 10번: 
            사용자의 종류엔 일반, 사업자 두 종류가 있습니다.
            사업자 회원의 경우엔 사업자 등록번호 10자리를 추가로 입력 받도록 합니다.

            작업을 진행하기 위한 Backlog를 작성해봅시다!
        </h2>
        <p></p>
        <div>
            <h4>일반 회원 가입</h4>
            <p>
            백로그 태그 : [ACCOUNT NORMAL SPRING]<br>

            Title : 사용자는 일반 회원을 선택하여 회원가입을 할 수 있습니다. [ANS-1]<br>

            Success criteria :<br>
                1. 일반 회원이 회원 가입을 하는 Test 코드를 작성합니다.<br>
                2. 예상값으로 이메일과 비밀번호, 회원 타입(NORMAL)을 설정합니다.<br>
                3. 해당 값들로 NormalAccountRegisterRequestForm 생성합니다.<br>
                4. NormalAccountRegisterRequest을 생성하여 String 타입의 roleType을 RoleType 타입으로 바꿔줍니다.<br>
                5. 입력된 이메일로 accountRepository에서 동일한 이메일이 있는지 검사합니다.<br>
                6. 동일한 이메일이 있다면 "이미 가입된 회원입니다."를 log에 출력합니다.<br>
                7. 동일한 이메일이 없다면 accountRepository에 저장합니다.<br>
                8. 저장된 Account 객체를 반환합니다.

            To-do :<br>
                1. 예상값 설정<br>
                2. NormalAccountRegisterRequestForm 생성<br>
                3. String 타입의 회원 타입을 RoleType으로 변경할 NormalAccountRegisterRequest 생성
                4. accountService, accountRepository 생성하여 normalRegister 매서드 작성<br>
            </p>
        </div>
        <div>
            <h4>사업자 회원 가입</h4>
            <p>
            백로그 태그 : [ACCOUNT BUSINESS SPRING]<br>

            Title : 사용자는 사업자 회원을 선택하여 회원가입을 할 수 있습니다. [ABS-1]<br>

            Success criteria :<br>
                1. 사업자 회원이 회원 가입을 하는 Test 코드를 작성합니다.<br>
                2. 예상값으로 이메일과 비밀번호, 회원 타입(BUSINESS), 사업자 번호를 설정합니다.<br>
                3. 해당 값들로 BusinessAccountRegisterRequestForm 생성합니다.<br>
                4. BusinessAccountRegisterRequest 생성하여 String 타입의 roleType을 RoleType 타입으로 바꿔줍니다.<br>
                5. 입력된 이메일로 accountRepository에서 동일한 이메일이 있는지 검사합니다.<br>
                6. 동일한 이메일이 있다면 "이미 가입된 회원입니다."를 log에 출력합니다.<br>
                7. 동일한 이메일이 없다면 accountRepository에 저장합니다.<br>
                8. 저장된 Account 객체를 반환합니다.

            To-do :<br>
                1. 예상값 설정<br>
                2. BusinessAccountRegisterRequestForm 생성<br>
                3. String 타입의 회원 타입을 RoleType으로 변경할 BusinessAccountRegisterRequest 생성
                4. businessRegister 매서드 작성<br>
            </p>
        </div>
    </div>
</template>

<script>
export default {
    
}
</script>

<style lang="">
    
</style>