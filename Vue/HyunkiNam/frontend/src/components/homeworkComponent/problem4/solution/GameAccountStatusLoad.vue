<template lang="">
    <div>
        <p>
        <input type="text" v-model="playerNumber">
        </p>
        <v-btn color="teal" @click="playGame">플레이</v-btn>
        <div v-if="isSuccessToGetData">
            <p>완력: {{ strength }}</p>
            <p>민첩: {{ dexterity }}</p>
            <p>지능: {{ intelligence }}</p>
            <p>체력: {{ vital }}</p>
            <p>넌 누구니: {{ whoAmI }}</p>
        </div>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    name: "game-account-status-load",
    data() {
        return {
            strength: 0,
            intelligence: 0,
            vital: 0,
            dexterity: 0,
            whoAmI: 0,
            isSuccessToGetData: false,
            playerNumber: 1,
        }
    },
    methods: {
        playGame() {
            alert('플레이!')
            axios.get('http://localhost:7777/test-account/get-status',
                { params: { playerNumber: this.playerNumber } })
                .then((res) => {
                    alert('스테이터스 확보 성공!')
                    this.strength = res.data.strength
                    this.intelligence = res.data.intelligence
                    this.vital = res.data.vital
                    this.dexterity = res.data.dexterity
                    this.whoAmI = res.data.whosAccountId
                    this.isSuccessToGetData = true
                })
        }
    }
}
</script>
<style lang="">
    
</style>