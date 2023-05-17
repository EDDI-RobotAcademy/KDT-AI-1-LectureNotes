<template lang="">
    <div v-if="email !== null">
        <h3>{{ email }} 계정으로 로그인하셨습니다!</h3>
        <!-- 이메일에 값이 생기면 나타나는 글씨이다.-->
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
        // 웹페이지에 마운트 될때 로컬 스토리지 유저 인포 값에서 아디를 가져온다.
        let gameAccountId = localStorage.getItem("loginUserInfo")
        // 해당 axios.post로 보낸다. 아이디니까 포스트 형식
        axios.post('http://localhost:7777/bmp-account/find-account-info', 
                { gameAccountId: gameAccountId })
            .then((res) => {
                // 통신 후 받은 아이디를 이메일에 넣어준다.
                // 그러면 이메일에 값이 생겼기 때문에
                // "무슨무슨 계정으로 로그인하셨습니다." 라는 글귀가 나타난다.
                this.email = res.data
            })
    }
}
</script>

<style lang="">
    
</style>