<template lang="">
    <div>
        <!-- 플레이 버튼 누르면 캐릭터 status 가져오기 -->
        <v-btn @click="getCharacterStatus">게임 플레이</v-btn><br>
        <!-- 화면에 status가 송출되도록 -->
        <p>캐릭터 상태</p>
        <p>strength: {{ strength }}</p>
        <p>intelligent: {{ intelligent }}</p>
        <p>dexterity: {{ dexterity }}</p>
        <p>agility: {{ agility }}</p>
        <p>hp: {{ hp }}</p>
        <!-- 이제 캐릭터의 상태 변화를 보여주어야 함 -->
    </div>
</template>

<script>

import axios from 'axios'

export default {
    data() {
        return {
            strength: 0,
            intelligent: 0,
            dexterity: 0,
            agility: 0,
            hp: 0,
        }
    },
    methods: {
        getCharacterStatus() {
            axios.post('http://localhost:7777/lets-show/character-status')
            .then((res) => {
                this.strength = res.data.strength
                this.intelligent = res.data.intelligent
                this.dexterity = res.data.dexterity
                this.agility = res.data.agility
                this.hp = res.data.hp
            })
        },
    },
}
</script>

<style lang="">
</style>