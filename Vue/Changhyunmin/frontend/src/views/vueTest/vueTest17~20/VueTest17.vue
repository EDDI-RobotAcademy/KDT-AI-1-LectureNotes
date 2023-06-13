<!-- [ 복합 문제 17 ~ 20 ]

일반 회원 및 사업자 회원의 로그인이 가능해야 합니다.

17. 위 작업을 진행하기 위한 Backlog를 작성해봅시다.
18. 가입한 ID와 비밀번호를 확인하여 로그인 기능을 하도록 테스트를 작성합니다.
19. Controller를 작성하여 postman으로 로그인 여부를 검증합니다.
    [ 테스트 결과 스크린샷 첨부 ]
20. UI 페이지를 작성하여 로그인을 가능하게 만들어봅시다.
 -->
 <!-- 
    1.회원가입 페이지 만들기
    2.회원가입 후 로그인이 가능한지 확인하기
    3.로그인 성공여부 확인하기
  -->
<template lang="">
    <div>
        <InfoPrintForm/>
        <CreationForm/>
        <LoginForm/>
    </div>
</template>
<script>
import InfoPrintForm from './InfoPrintForm.vue';
import LoginForm from './LoginForm.vue';
import CreationForm from './CreationForm.vue'
export default {
    components:{
        CreationForm,
        InfoPrintForm,
        LoginForm,

    }
}
</script>
<style lang="">
    
</style>