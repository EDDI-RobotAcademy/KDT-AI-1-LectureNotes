<template lang="">
    <div>
        <v-btn color="primary" @click="showLoginForm">로그인 형식 보기</v-btn>
        <div v-if="isPressedButton">
            <!-- 역시나 가려진 부분을 보이게 해줌-->
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
            </div>
            <v-btn color="purple" @click="processLogin">로그인</v-btn>
        </div><!-- 역시나 열었던것 다시 가리고 나머지 는 axios.post 통신한다.-->
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
            // 다시 가려주고  객체화 한 정보들을 보낸다.
            const { email, password } = this
            axios.post('http://localhost:7777/bmp-account/login', { email, password })
                .then((res) => {
                    // Boolean 타입으로 리턴 받는다.
                    if (res.data.isSuccessForLogin) {
                        alert('로그인 완료!')// 해당 아이디와 비번이 맞을 경우
                        this.accountId = res.data.gameAccountId
                        console.log('accountId: ' + this.accountId)
                        localStorage.setItem("loginUserInfo", res.data.gameAccountId)
                        // 로그인 가능한 경우 브라우저의 로컬 스토리지에 아이디 정보 저장한다.
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