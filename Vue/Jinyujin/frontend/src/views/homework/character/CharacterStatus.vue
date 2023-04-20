<template lang="">
    <div>
        <!-- 플레이 버튼 누르면 캐릭터 status 가져오기 -->
        <v-btn @click="getCharacterStatus">게임 플레이</v-btn><br>
        <div v-if ="isPressButton">
            <p></p>
            <!-- 화면에 status가 송출되도록 -->
            <h2>캐릭터 상태</h2>
            <p>strength: {{ strength }}</p>
            <p>intelligent: {{ intelligent }}</p>
            <p>dexterity: {{ dexterity }}</p>
            <p>agility: {{ agility }}</p>
            <p>hp: {{ hp }}</p>
            <p>현재 플레이어 id: {{ whosAccountId }}</p>
        </div>
        <!-- 이제 캐릭터의 상태 변화를 보여주어야 함 -->
    </div>
</template>

<script>

import axios from 'axios'

export default {
    data() {
        return {
            isPressButton: false,

            strength: null,
            intelligent: null,
            dexterity: null,
            agility: null,
            hp: null,
            whosAccountId: null,
        }
    },
    methods: {
        getCharacterStatus() {
            this.isPressButton = true;

            axios.post('http://localhost:7777/lets-show/character-status')
            .then((res) => {
                this.strength = res.data.strength
                this.intelligent = res.data.intelligent
                this.dexterity = res.data.dexterity
                this.agility = res.data.agility
                this.hp = res.data.hp
                this.whosAccountId = res.data.whosAccountId
            })
        },
    },
}
</script>

<style lang="">
</style>