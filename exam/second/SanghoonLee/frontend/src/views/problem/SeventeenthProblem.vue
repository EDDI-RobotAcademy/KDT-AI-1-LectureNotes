<template lang="">
    <div>
        <!--
            Backend 파트
            제목: 로그인 요청이 들어오면 수신된 정보를 바탕으로 로그인을 진행하고 토큰을 반환합니다

            Success Criteria:
            1. 로그인 요청을 수신할 수 있는 Controller를 맵핑합니다
            2. 수신된 정보를 바탕으로 이메일이 존재하는지 확인합니다
            3. 이메일이 존재하지 않는다면 null을 리턴합니다
            4. 이메일이 존재한다면 비밀번호를 확인합니다
            5. 비밀번호가 일치하지 않는다면 null을 리턴합니다
            6. 비밀번호가 일치한다면 토큰을 반환합니다

            Todo:
            v 로그인 요청에 대한 Controller 구성
            v 이메일 존재 여부 확인
            v 비밀번호 일치 여부 확인
            v 토큰 반환하기

            Frontend 파트
            제목: 로그인에 필요한 정보를 입력할 수 있는 페이지 만들기

            Success Criteria:
            1. email, password 정보를 입력할 수 있는 textfield를 구성합니다
            2. 로그인 버튼을 눌러서 로그인 성공 여부를 확인합니다
            3. 로그인 상태를 유지할 수 있어야합니다
        -->        
    </div>
</template>

<script>
export default {
    
}
</script>
<style lang="">
    
</style>