<template lang="">
    <div>
        <table>
            <tr>
                <td><label>id: <input type="text" v-model="id"/> </label></td>
                <td rowspan='2'><v-btn @click="login">로그인</v-btn></td>
            </tr>
            <tr>
                <label>password: <input type="password" v-model="userPassword"/> </label>
            </tr>
            <div v-if="checked">유저의 이메일주소는: {{checkedEmail}} <br>
            <label>계정을 선택해주세요</label>
            </div>
        </table>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    
    data(){
        return{
            checked: false,
            id: 0,
            userPassword: "",
            checkedEmail: ""

        }
    },
    methods: {
        login(){
            const{id,userPassword}=this
            console.log("aaaaaaaa")
            axios.post("http://localhost:7777/test-account/test-login",
            {id,userPassword})
            .then((res)=>{
            alert('로그인 성공')
            this.checked=true
            this.checkedEmail=res.data.userEmail})
            .catch((res)=>{
            alert('로그인 실패')})
            
            
            

        }
    }
}
</script>
<style lang="">
    
</style>