<template lang="">
    <div>
        <!-- 로그인 했을 때 이메일 주소 보여주기  -->
        <v-btn @click="logIn">로그인</v-btn>
        <p></p>
        <form v-if="isLoginButton"> 
            <label>
            <p></p>
            Email입력: <input type="text" v-model="email"><br>
            Password입력: <input type="password" v-model="password"><br>
            <p></p>
            </label>
            <!-- <p>당신의 이메일 주소는 {{ email }}입니다</p> -->
            <!-- 
                이메일 주소 보여주게 하려면?
                아이디와 이메일을 매칭시켜야
                일단 다른 컴포넌트에서 이메일 보냄
                여기서 아이디 보내고 그걸 전에 보냈던 이메일과 매칭시키고 싶음
                여기서 이메일 주소를 보여달라는게 진짜 출력하라는게 아니라 중복을 체크하라는 뜻이었음
                중복체크하려면? 스프링에서 해쉬맵
            -->
            <v-btn color="primary" @click="finishLogIn">로그인 완료</v-btn><br>
            <p></p>
        </form>
    </div>
    <!-- 이제 사용자들의 로그인이 되었는지 안되었는지 판단해야함 - localStorage -->
</template>
<script>

import axios from 'axios';

export default {
    data() {
        return {
            isLoginButton: false,
            email: null,
            password: null,
            // 게임 아이디 받아올 것임
            gameAccountId: null,
        }
    },
    methods: {
        logIn() {
            this.isLoginButton = true;
        },
        finishLogIn() {
            axios.post('http://localhost:7777/lets-show/login',
            {email: this.email, password: this.password})
            .then((res) => {
                if(res) {
                    alert("로그인 완료!")
                    // 이제 입력한 로그인 값들을 저장해 두어야 한다
                    // 로그인 하자마자 정보가 날아가면 로그인 하는 의미가 없으니까      
                    this.gameId = res.data.gameAccountId,
                    console.log('gameId: ' + this.gameId)
                    localStorage.setItem("loginUserInfo", res.data.gameAccountId)
                } else {
                    alert("동일한 계정이 이미 존재합니다.")
                }
            })
        },
        mounted() {
            this.gameId = localStorage.getItem("loginUserInfo")
            console.log('현재 gameId: ' + this.gameId)
        },
    },
}
</script>
<style lang="">
    
</style>