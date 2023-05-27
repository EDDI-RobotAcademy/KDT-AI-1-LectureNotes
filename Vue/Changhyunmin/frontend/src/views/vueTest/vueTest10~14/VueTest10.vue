<!-- [ 복합 문제 10 ~ 14 ]

사용자의 종류엔 일반, 사업자 두 종류가 있습니다.
사업자 회원의 경우엔 사업자 등록번호 10자리를 추가로 입력 받도록 합니다.
10. 작업을 진행하기 위한 Backlog를 작성해봅시다!
11. 일반 회원 가입 테스트를 작성합니다.
12. 사업자 회원 가입 테스트를 작성합니다.
13. 검증한 테스트에 대한 Controller를 작성하여 postman으로 테스트합니다.
    [ 테스트 결과 스크린샷 첨부 ]
14. Vue를 통해 위의 회원 가입을 진행할 수 있는 UI 페이지를 작성합니다.
 -->
 <!-- 
    vue
    1.회원가입에 필요한 페이지를 생성합니다.
    2.
  -->
<template lang="">
    <div>
        <form @submit.prevent="onSubmit">
            <div>
                <label for="name">이름</label>
                <input type="text" id="name" v-model="name">
            </div>
            <div>
                <label for="email">email</label>
                <input type="text" id="email" v-model="email">
            </div>
            <div>
                <label for="password">비밀번호</label>
                <input type="password" id="password" v-model="password">
            </div>
            <div>
                <label for="passwordConfirm">비밀번호확인</label>
                <input type="password" id="passwordConfirm" v-model="passwordConfirm">
            </div>
            <button type="submit">회원가입</button>
        </form>
    </div>
</template>
<script>
export default {
    // name: 'MembershipForm',
    data() {
        return {
            name:'',
            email:'',
            password:'',
            passwordConfirm:'',
        };
    },
    methods: {
        onSubmit(){
            console.log('');
        }
    },
}
</script>
<style lang="">
    
</style>