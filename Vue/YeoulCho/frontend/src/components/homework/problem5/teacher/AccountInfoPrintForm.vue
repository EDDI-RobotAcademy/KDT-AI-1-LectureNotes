<template lang="">
    <div>
        <h3>{{email}} 계정으로 로그인하셨습니다!</h3>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    dat(){
        return{
            email: '',
        }
    },
    created(){
        let accountId= localStorage.getItem("loginUserInfo")
        axios.post("http://localhost:7777/bmp-account/lookup",
        {accountId: accountId})
        .then((res)=>{
            this.email= res.data
        })
    }
    
}
</script>
<style lang="">
    
</style>