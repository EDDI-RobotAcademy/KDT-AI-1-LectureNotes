<template lang="">
    <div>
        <!-- 10, 16번 문제 동시진행
            계정 등록 버튼을 누르면 회원가입을 요청합니다.

            Success Criteria
            - 등록할 이메일과 비밀번호 사업자번호를 기입할 칸을 만듭니다.
            - 확인을 누르면 backend 정보를 요청합니다.

            To-Do
            - 사업자 계정 등록 버튼 생성
            - 버튼을 누르면 가입을 진행할 수 있는 이메일 비밀번호 사업자번호가 나오게 만듭니다.
            - axios를 설정하여 정보를 요청합니다
        -->
        <!--
            16번 문제 vue에서 vuex를 사용할 때 Module을 사용하게 됨으로서 얻게되는 이점
            코드의 재사용성이 높아진다.
            코드의 유지보수성이 향상된다.
            코드의 확장성이 높아진다.
        -->
        <v-btn color="primary" @click="accountCreate">사업자 계정 등록</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
                <label>
                    사업자번호: <input type="number" v-model="BUSINESS_NUMBER"/>
                </label><br/>
            </div>
            <v-btn color="purple" @click="processCreateAccount">완료</v-btn>
        </div>
    </div>
</template>
<script>
import axios from 'axios'

export default {
    data () {
        return {
            email: '',
            password: '',
            BUSINESS_NUMBER: '',
            isPressedButton: false,
        }
    },
    methods: {
        accountCreate () {
            this.isPressedButton = true
        },
        processCreateAccount () {
            this.isPressedButton = false
            const { email, password, BUSINESS_NUMBER } = this
            axios.post('http://localhost:7777/business-test/business', { email, password, BUSINESS_NUMBER })
                .then((res) => {
                    alert('생성 요청 완료!')
                })
        }
    }
}
</script>
<style lang="">
    
</style>