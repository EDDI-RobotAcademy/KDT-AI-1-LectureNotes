<template lang="">
    <div>
        <v-btn color="primary" @click="showLoginForm">로그인 형식 보기</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
            </div>
            <v-btn color="purple" @click="processLogin">로그인</v-btn>
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
            isPressedButton: false,
            gameAccountId: 0,
        }
    },
    methods: {
        showLoginForm () {
            this.isPressedButton = true
        },
        processLogin () {
            this.isPressedButton = false
            const { email, password } = this
            axios.post('http://localhost:7777/bmp-account/login', { email, password })
                .then((res) => {
                    // if 부분을 새롭게 생성
                    // 처음엔 res만 있었지만 데이터 정보를 받지 않아서
                    // 오류가 나왔음 
                    // res.data로 수정해주자 동일한 이메일을 작성했더니
                    // 동일한 계정이 이미 존재합니다. 라는 메세지가 생성됨 
                    if (res.data.isSuccessForLogin) {
                        alert('로그인 완료!')
                        this.accountId = res.data.gameAccountId
                        console.log('accountId: ' + this.accountId)
                        // F12를 누르고 어플리케이션을 누르면 스토리지가 있음
                        // 로그인을 유지해줌
                        localStorage.setItem("loginUserInfo", res.data.gameAccountId)
                    } else {
                        alert('로그인 실패!')
                    }
                })
        }
    },
    mounted () {
        this.accountId = localStorage.getItem("loginUserInfo")
        console.log('현재 accountId: ' + this.accountId)
    }
}
</script>
<style lang="">
    
</style>