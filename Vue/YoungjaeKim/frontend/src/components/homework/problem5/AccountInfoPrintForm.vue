<template lang="">
    <div v-if="email !== null">
        <h3>{{ email }} 계정으로 로그인하셨습니다!</h3>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data () {
        return {
            email: null,
        }
    },
    mounted () {
        let gameAccountId = localStorage.getItem("loginUserInfo")
        axios.post('http://localhost:7777/bmp-account/find-account-info', 
                { gameAccountId: gameAccountId })
            .then((res) => {
                this.email = res.data
            })
    }
}
</script>

<style lang="">
    
</style>