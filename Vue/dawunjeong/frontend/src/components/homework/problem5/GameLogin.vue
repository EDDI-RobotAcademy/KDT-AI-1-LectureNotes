<template lang="">
    <div id="login">
        <v-btn color="red" @click="openLoginPage">로그인</v-btn>
        <p></p>
        <div v-if="showLoginPage">
            <p>이메일을 입력하세요: <input type="email" v-model="email"><br></p>
            <p>비밀번호를 입력하세요: <input type="password" v-model="password"><br></p>
            <p><v-btn @click="isRegisteredEmail">로그인</v-btn></p>
            <p><hr style="width: 400px; margin: auto;"></p>

            <div id="selectAccount">
                <v-btn color="primary" @click="getAccountList">계정 조회하기</v-btn>
                <v-btn color="primary" @click="openSelectAccount">계정 선택하기</v-btn><br>
                <p><div v-if="showselectAccountPage">
                    <p>선택 가능한 계정: {{ userAccountList }}</p>
                    <p>원하는 계정 Id를 입력하세요: <input type="Number" v-model="accountId"></p><br>
                    <v-btn @click="selectAccount">계정 선택!</v-btn>
                </div></p>
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

            checkedEmail: false,

            userAccountList: [],
            accountId: 0,
            selectedId: 0,

            showLoginPage: false,
            showselectAccountPage: false,
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
                this.checkedEmail = res.data
                if(this.checkedEmail === true) {
                    alert(this.email + '님 로그인이 완료되었습니다.')
                }
                if(this.checkedEmail === false) {
                    alert('이메일과 비밀번호를 다시 확인해주세요.')
                }
            })
        },
        getAccountList () {
            axios.post('http://localhost:7777/character-game/get-account-list', 
            { email: this.email, password: this.password })
            .then((res1) => {
                alert('선택 가능한 계정 리스트: ' + JSON.stringify(res1.data))
                this.userAccountList = res1.data
            })
        },
        selectAccount () {
            axios.post('http://localhost:7777/character-game/get-account', 
            { accountId: this.accountId })
            .then((res2) => {
                alert('선택된 계정Id' + res2.data)
                this.selectedId = res2.data
            })
            .catch((res2) => {
                alert('입력하신 계정은 없는 계정입니다.')
            })
        }
    }
}
</script>

<style lang="">
    
</style>