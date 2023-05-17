<template lang="">
    <div>
        <h1>캐릭터 게임</h1>
        <div id="signUp">
            <p><v-btn color="red" @click="addAccount">회원가입</v-btn></p>
            <div v-if="showCreatAccount">
                <div>
                    <p>이메일 입력: <input type="email" v-model="email"></p>
                    <p>비밀번호 입력: <input type="password" v-model="password"></p>
                    <p><v-btn color="primary" @click="complete">확인</v-btn></p>
                    <p><hr style="width: 400px; margin: auto;"></p>
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
            showCreatAccount: false,

            email: '',
            password: '',

            accountInfo: [],
        }
    },
    methods: {
        addAccount () {
            this.showCreatAccount = true
        },
        complete () {
            axios.post('http://localhost:7777/character-game/add-character',
            { email: this.email, password: this.password })
            .then((res1) => {
                alert('데이터 전송!')
                if(res1.data === true) {
                    alert('회원 가입이 완료되었습니다.')
                }
                if(res1.data === false) {
                    alert('이미 등록된 이메일이 있습니다.')
                }
            })
        }
    }
}
</script>

<style lang="">
    
</style>