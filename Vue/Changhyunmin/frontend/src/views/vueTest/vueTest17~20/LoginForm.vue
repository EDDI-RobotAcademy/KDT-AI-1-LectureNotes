<template lang="">
    <div>
        <v-dtn class="on" @click="showLoginForm">로그인 형식 보기</v-dtn>
        <div v-if="isPressedButton">
            <div>
                <label>
                이메일: <input type="text" v-model="email">
                </label><br/>
                <label>
                비밀번호: <input type="password" v-model="password">
                </label><br/>
            </div>
        </div>
        <v-dtn class="on" @click="processLogin">로그인</v-dtn>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data() {
        return {
            email:'',
            password:'',
            isPressedButton: false,
            AccountId:'',
        }
    },
    methods: {
        showLoginForm (){
            this.isPressedButton = true
        },
        processLogin(){
            this.isPressedButton = false
            
            const {email,password} = this
                axios.post('http://localhost:7778/bmp-account/login', {email,password})
                .then((res)=> {
                    if (res.data.isSuccessForLogin) {
                        alert('로그인 완료!')
                        this.accountId = res.data.AccountId
                        console.log('accountId: ' + this.accountId)
                        localStorage.setItem("loginUserInfo",res.data.AccountId)                        
                    }
                    else{
                        alert('로그인 실패!')
                    }
                })
        },
        
    },
    mounted() {
        this.accountId = localStorage.getItem("loginUserInfo")
        console.log('현재 accountId: ' + this.accountId)
    },


}
</script>
<style>
.on{
    border: #bebebe;
}
</style>