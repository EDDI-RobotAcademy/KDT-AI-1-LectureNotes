<template lang="">
    <div>
        <h1>캐릭터 게임</h1>
        <div id="createCharacter">
            <v-btn color="red" @click="addAccount">게임 캐릭터 생성</v-btn>
            <p></p>
            <div v-if="showCreatAccount">
                <div>
                    <p>이메일 입력: <input type="email" v-model="email"></p>
                    <p>비밀번호 입력: <input type="password" v-model="password"></p>
                    <p><v-btn color="primary" @click="complete">생성</v-btn></p>
                </div>

                <div id="playGame">
                <p></p>    
                <v-btn color="red" @click="showCharacterStatus">PLAY!!!</v-btn>
                    <div v-if="showStatus">
                        <p></p>
                        <p>게임 캐릭터의 상태:<br>
                        <li>
                            strength: {{characterStatus[0]}}
                            intelligent: {{characterStatus[1]}}
                            dexterity: {{characterStatus[2]}}
                            agility: {{characterStatus[3]}}
                            hp: {{characterStatus[4]}}
                        </li>
                        </p>
                    </div>
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
            showStatus: false,

            email: '',
            password: '',

            accountInfo: [],
            characterStatus: [],
        }
    },
    methods: {
        addAccount () {
            this.showCreatAccount = true
        },
        complete () {
            axios.post('http://localhost:7777/character-game/add-character',
            { email: this.email, password: this.password })
            .then((res) => {
                alert('데이터 전송!')
                alert(JSON.stringify(res.data.email) + '님 가입이 완료되었습니다.')
                this.accountInfo = res.data
            })
        },
        showCharacterStatus () {
            this.showStatus = true
            axios.get('http://localhost:7777/character-game/create-character-status')
                .then((response) => {
                    this.characterStatus = response.data;
            })
        }
    }
}
</script>

<style lang="">
    
</style>