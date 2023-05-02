<template>
    <div>
        <v-btn v-if="!isLoggedIn" color="secondary" @click="readyToLogin">로그인</v-btn>
        <v-btn v-if="isLoggedIn" color="secondary" @click="logout">로그아웃</v-btn>
        <div v-if="isPressedButton">
            <div>
                <label>
                    이메일: <input type="text" v-model="email"/>
                </label><br/>
                <label>
                    비밀번호: <input type="password" v-model="password"/>
                </label><br/>
            </div>
            <v-btn color="secondary" @click="login">로그인 하기</v-btn>
        </div>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data () {
        return {
            email: '',
            password: '',
            isPressedButton: false,
            accountId: 0,
            isLoggedIn: false
        }
    },
    methods: {
        readyToLogin () {
            this.isPressedButton = true

        },

        login () {
            this.isPressedButton = false

            const{email, password} = this
            axios.post('http://localhost:7777/character-problem/login', 
            {email, password})
            .then((res) => {
                if(res.data.isSuccessForLogin) {
                    alert('로그인 완료!')
                    this.accountId = res.data.accountId
                    localStorage.setItem("loginUserInfo", res.data.accountId)
                    console.log(this.accountId)
                    this.isLoggedIn = true
                }
                else {
                    alert("로그인 실패!")
                }
            })
        },

        logout () {
            localStorage.removeItem("loginUserInfo")
            this.isLoggedIn = false
        }
    },
    mounted () {
        this.accountId = localStorage.getItem("loginUserInfo")
        if (this.accountId > 0) {
            this.isLoggedIn = true
            console.log(this.accountId)
        }
    }
}
</script>
<style>
    
</style>