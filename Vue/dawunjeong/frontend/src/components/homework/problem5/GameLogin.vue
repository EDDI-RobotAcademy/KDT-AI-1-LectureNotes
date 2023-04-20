<template lang="">
    <div>
        <v-btn color="red" @click="openLoginPage">로그인 페이지</v-btn>
        <div v-if="showLoginPage">
            이메일을 입력하세요: <input type="email" v-model="email"><br>
            비밀번호를 입력하세요: <input type="password" v-model="password"><br>
            <v-btn @click="isRegisteredEmail">로그인</v-btn>

            <div>
                <v-btn color="primary" @click="openSelectAccount">계정 선택 페이지</v-btn>
                <div v-if="showselectAccountPage">
                    계정 Id를 입력하세요(0부터 시작): <input type="Number" v-model="accountId"><br>
                    <v-btn @click="selectAccount">계정 선택!</v-btn>
                </div>
            </div>
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
            checkedEmail:'',
            accountId: 0,
            selectedId: 0,
            showLoginPage: false,
            showselectAccountPage: false
        }
    },
    methods: {
        openLoginPage () {
            this.showLoginPage = true;
        },
        openSelectAccount () {
            this.showselectAccountPage = true;
        },
        isRegisteredEmail () {
            axios.post('http://localhost:7777/character-game/check-account',
            { email: this.email, password: this.password })
            .then((res) => {
                alert('데이터 전송!')
                alert('가입된 이메일: ' + res.data)
                this.checkedEmail = res.data
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        },
        selectAccount () {
            axios.post('http://localhost:7777/character-game/get-account', 
            { accountId: this.accountId })
            .then((response) => {
                alert('선택된 계정Id' + response.data)
                this.selectedId = response.data
            })
            .catch((response) => {
                alert('입력하신 계정은 없는 계정입니다.')
            })
        }
    }
}
</script>

<style lang="">
    
</style>