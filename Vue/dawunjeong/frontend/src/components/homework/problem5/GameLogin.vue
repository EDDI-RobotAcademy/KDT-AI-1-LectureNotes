<template lang="">
    <div id="login">
        <v-btn color="red" @click="openLoginPage">로그인</v-btn>
        <p></p>
        <div v-if="showLoginPage">
            <p>이메일을 입력하세요: <input type="email" v-model="email"><br></p>
            <p>비밀번호를 입력하세요: <input type="password" v-model="password"><br></p>
            <p><v-btn @click="isRegisteredEmail">로그인</v-btn></p>
            <p><hr style="width: 400px; margin: auto;"></p>
        </div>

        <div id="playGame" v-if="showStatus"> 
        <p><v-btn color="red" @click="showCharacterStatus">PLAY!!!</v-btn></p>
            <p>게임 캐릭터의 상태:<br>
                {{ characterStatus }}
            </p>
            <p><hr style="width: 400px; margin: auto;"></p>
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

            showLoginPage: false,

            checkedAccount: false,
            accountId: 0,

            showStatus: false,
            characterStatus: [],
        }
    },
    methods: {
        openLoginPage () {
            this.showLoginPage = true;
        },
        isRegisteredEmail () {
            axios.post('http://localhost:7777/character-game/check-account',
            { email: this.email, password: this.password })
            .then((res) => {
                this.checkedAccount = res.data.isSuccessForLogin
                if(this.checkedAccount === true) {
                    alert(this.email + '님 로그인이 완료되었습니다.')
                    console.log('accountId: ' + res.data.accountId)

                    this.accountId = res.data.accountId
                    localStorage.setItem("loginUserInfo", res.data.accountId)

                    this.showStatus = true
                }
                if(this.checkedAccount === false) {
                    alert('이메일과 비밀번호를 다시 확인해주세요.')
                }
            })
        },
        showCharacterStatus () {
            axios.post('http://localhost:7777/character-game/create-character-status', 
            {accountId: this.accountId})
                .then((res2) => {
                    this.characterStatus += JSON.stringify(res2.data)
            })
        }
    },
    mounted () {
        this.accountId = localStorage.getItem("loginUserInfo")
        console.log('현재 accountId: ' + this.accountId)
    }
}
</script>

<style lang="">
    
</style>