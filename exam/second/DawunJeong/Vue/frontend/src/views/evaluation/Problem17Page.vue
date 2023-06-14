<template lang="">
    <div>
        <h2>문제 17번: 
            일반 회원 및 사업자 회원의 로그인이 가능해야 합니다.
            위 작업을 진행하기 위한 Backlog를 작성해봅시다.
        </h2>
        <p>
        백로그 태그 : [ACCOUNT LOGIN SPRING]<br>

        Title : 사용자는 이메일과 비밀번호를 입력하여 로그인을 할 수 있습니다. [ALS-1]<br>

        Success criteria :<br>
            1. 예상값으로 이메일과 비밀번호를 설정합니다.<br>
            2. 해당 값들로 AccountLoginRequestForm을 생성합니다.<br>
            3. 입력된 이메일로 accountRepository에서 동일한 이메일이 있는지 검사합니다.<br>
            4. 동일한 이메일이 있다면 해당 계정의 비밀번호와 예상값의 비밀번호가 동일한지 검사합니다.<br>
            5. 모두 동일하다면 AccountLoginResponseForm에 token을 넣어 반환합니다.<br>

        To-do :<br>
            1. 예상값 설정<br>
            2. 이메일, 비밀번호, 회원 타입을 인자로 갖는 AccountLoginRequestForm을 생성<br>
            3. service 내에 login 기능을 수행하는 매서드 생성<br>
            4. 로그인시 랜덤한 token값을 뽑아 AccountLoginResponseForm 객체 생성 후 반환<br>
        </p>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>