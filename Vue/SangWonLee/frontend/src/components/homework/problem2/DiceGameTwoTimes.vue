<template lang="">
    <div>
        <h3>주사위 2개를 굴려 합이 짝수면 승리 홀수면 패배!</h3>
        <v-btn color="primary" @click="startTwoTimesDiceGame">주사위 게임 시작!</v-btn>
        <p>얻은 결과: {{ playingNumber }}, 승자 판정: {{ result }}</p>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return {
            result: '알 수 없음',
            playingNumber: 0,
        }
    },
    methods: {
        startTwoTimesDiceGame() {
            axios.get('http://localhost:7777/dice-game/firstGame')
                .then((res) => {
                    //this.result = res.data
                    //console.log('result: ' + res.data)
                    this.result = res.data.result
                    this.playingNumber = res.data.winnerNumber
                })
        }
    }
}
</script>

<style lang="">
    
</style>