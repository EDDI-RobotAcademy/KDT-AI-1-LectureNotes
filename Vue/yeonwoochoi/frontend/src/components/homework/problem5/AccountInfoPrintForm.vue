<template lang="">
    <div>
        <div v-if="email !== null">
        <h3>{{ email }} 계정으로 로그인하셨습니다!</h3>
        </div>
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
                // 포스트맨에서 키값"email": 밸류값"s@s.com",
                // 키값      밸류값
                { gameAccountId: gameAccountId })
            .then((res) => {
                // 로그인하고 새고 해도 유지
                this.email = res.data
            })

    }
}
</script>
<style lang="">
    
</style>