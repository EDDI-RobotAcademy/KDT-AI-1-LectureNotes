<template lang="">
    <div>
        <!--
            Backend 파트
            제목: 회원 가입 요청이 들어오면 사업자 및 일반회원을 구분하여 회원 정보를 저장합니다

            Success Criteria:
            1. 회원 가입 요청에 대한 Controller를 맵핑합니다
            2. 요청된 형태를 통해 사업자 및 일반 회원을 구분합니다
            3. 중복된 e-mail 계정이 존재하는지 확인합니다
            4. 중복되었다면 계정 생성이 불가함을 알리기 위해 false를 리턴합니다
            5. 중복되지 않았다면 정상적으로 계정을 생성하고 true를 리턴합니다

            Todo:
            v 회원 가입 Controller 맵핑
            v e-mail 중복 여부 검사
            v 사업자 및 일반회원 구분하기
            v 처리 결과 리턴하기

            Frontend 파트
            제목: 일반회원 및 사업자를 선택하여 회원가입 할 수 있는 페이지 작성하기

            Success Criteria:
            1. 일반회원 및 사업자를 선택 할 수 있도록 만듭니다
            2. e-mail 및 password를 입력합니다
            3. 회원가입을 눌러 가입 여부에 따라 재작성을 하도록 만듭니다
               (가입 되었다면 home '/' 페이지로, 안되었다면 다시 작성하도록 만듭니다)

            Todo:
            v 일반회원 및 사업자 선택 (checkbox)
            v e-mail 및 password를 입력할 textfield 구성
            v 회원가입 버튼을 통해 axios 요청하기
        -->
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>