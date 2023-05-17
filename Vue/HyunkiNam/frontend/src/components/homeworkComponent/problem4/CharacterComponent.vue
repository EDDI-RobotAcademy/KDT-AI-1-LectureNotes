<template>
    <div id="contanier">
        <form>
            <fieldset>
                <legend>Vue 문제 은행 4</legend>

                <form @submit.prevent="createCharacter">
                    <button style="background-color: deepskyblue; border-radius: 10px; padding: 5px; color: white;"
                        type="submit">
                        캐릭터 생성
                    </button>
                </form>
                <div v-show="isCreate">

                    <label for="user_email">이메일</label>
                    <input type="email" v-model="user_email">
                    <br>
                    <label for="user_password">비밀번호</label>
                    <input type="password" v-model="user_password">

                    <br>
                    <v-btn color="success" @click="completeCreate">완료</v-btn>
                </div>
            </fieldset><br>

            <select id="player" v-model="playerIdx" @change="setSelect($event)">
                <option v-for="(player, index) in playerList" :key="index" :value="player.value">
                    {{ player.name }}</option>
            </select>

            <fieldset>
                <legend>
                    <v-btn color="primary" block rounded @click="getCharacterStatus">플레이</v-btn>
                    <v-btn block rounded @click="addPlayerList">더하기</v-btn>
                </legend>

                <ul style="text-align: left;">
                    <li> 아이디 : {{ savedUserEmail }}</li>
                    <li> 힘 : {{ strength }}</li>
                    <li> 민첩 : {{ dexterity }}</li>
                    <li> 지능 : {{ intellect }}</li>
                </ul>
            </fieldset>
        </form>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    name: "CharacterComponent",
    data() {
        return {
            isCreate: false,
            user_email: '',
            user_password: '',
            savedUserEmail: '',
            strength: 0,
            dexterity: 0,
            intellect: 0,
            count: 1,
            playerIdx: 0,

            playerList: [
                { name: "플레이어목록", value: 0 },
            ]
        }
    },
    methods: {
        createCharacter() {
            this.isCreate = true;
        },
        completeCreate() {
            axios.post('http://localhost:7777/homework/create-character',
                { user_email: this.user_email, user_password: this.user_password })
                .then((res) => {
                    if (res.data == false) {
                        alert('이메일 중복')
                    }
                    if (res.data == true) {
                        alert('생성 완료');

                        this.addPlayerList();
                        this.tmpRes = res.data;
                        this.isCreate = false;
                        this.user_email = '';
                        this.user_password = '';
                    }
                })
                .catch((res) => {
                    alert('전송 실패!')
                });
        },
        getCharacterStatus() {
            axios.get('http://localhost:7777/homework/get-character-status',
                { params: { playerIdx: this.playerIdx } })
                .then((res) => {
                    this.savedUserEmail = res.data.user_email
                    this.strength = res.data.strength
                    this.dexterity = res.data.dexterity
                    this.intellect = res.data.intellect
                })
                .catch((res) => {
                    alert('데이터 수신 실패!')
                });
        },
        // addPlayerList() {
        //     const option = document.createElement("option");

        //     option.setAttribute('value', this.count);
        //     const textNode = document.createTextNode("플레이어" + this.count);
        //     option.append(textNode);

        //     document.getElementById('playerList').append(option);
        //     this.count++
        // },
        addPlayerList() {
            this.playerList.push({ name: "플레이어" + this.count, value: this.count })
            this.count++
            console.log(this.count)
            console.log(this.playerList)
            console.log(this.playerIdx)
        },
        setSelect(event) {
            this.playerIdx = event.target.value;
            console.log(this.playerIdx);
        }
    }
}
</script>
<style></style>