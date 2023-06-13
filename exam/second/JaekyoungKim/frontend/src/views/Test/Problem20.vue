<template lang="">

<div style="text-align: center">
        <v-btn color="primary" @click="showLoginForm">로그인 하기</v-btn>
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
            accountUuid: 0,
        }},
    methods: {
        showLoginForm () {
            this.isPressedButton = true
        },
        processLogin(){
            this.isPressedButton=false
            const {email,password}=this
            axios.post('http://localhost:7777/account-test/login-test',{email,password})
            .then((res)=>{
                if(res.data!==null){
                    alert("로그인 완료")
                    this.accountUuid=res.data.userToken
                    localStorage.setItem("loginUserInfo",res.data.userToken)
                }
            })
        }
    },
    mounted () {
        this.accountUuid = localStorage.getItem("loginUserInfo")
        console.log('현재 accountId: ' + this.accountUuid)
    }
}
</script>

<style lang="">
    
</style>