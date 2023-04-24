<template lang="">
    <div>
        <h3>혼자 풀어보기 - 회원가입, 로그인</h3>
        <!--
            [] 회원가입
            [] 로그인
        -->
        <v-btn color="primary" @click="signUpBtn">회원가입</v-btn><br>

        <div v-if="isPush" id="signUpBox">
            <input type="text" v-model="userId" placeholder="ID"/><br>
            <input type="password" v-model="userPw" placeholder="PW"/><br>
            <v-btn color="primary" @click="writeComplete">작성 완료</v-btn>
        </div>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            isPush: false,
            userId: '',
            userPw: '',
        }
    },
    methods: {
        signUpBtn(){
            this.isPush = !this.isPush
        },
        writeComplete(){
            const {userId, userPw} = this
            axios.post('http://localhost:7777/game-world/signUp', {
                userId, userPw
            })
            .then((res) => {
                alert("회원가입이 완료되었습니다.")
            })
        }
    }
}
</script>

<style scoped></style>