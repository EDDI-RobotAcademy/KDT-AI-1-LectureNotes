<template lang="">
    <div v-if="email !== null"> 
        <p></p>
        <!-- 이메일 값이 없다면 -->
        <p>{{ email }} 계정으로 로그인 하셨습니다</p>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data() {
        return {
            email: null,
        }
    },
    mounted() {
        let gameAccountId = localStorage.getItem("loginUserInfo")
        axios.post('http://localhost:7777/lets-show/find-account-info',
        {gameAccountId: gameAccountId})
        .then((res) => {
            this.email = res.data
        })
    },
}
</script>

<style lang="">
</style>