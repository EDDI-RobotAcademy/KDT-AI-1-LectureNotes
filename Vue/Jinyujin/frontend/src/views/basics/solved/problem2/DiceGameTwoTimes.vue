<template lang="">
    <div>
        <h3>주사위 2개를 굴려 합이 짝수면 승리 홀수면 패배!</h3>
        <v-btn type="submit" @click="startTwoTimesDiceGame">주사위 게임 시작!</v-btn>
        <p>얻은 결과: {{ winnerScore }}, 승자 판정: {{ result }}</p>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data() {
        return {
            result:'알 수 없음',
            winnerScore: 0
        }
    },
    methods: {
        startTwoTimesDiceGame() {
            axios.get('http://localhost:7777/dice-game/firstGame')
                .then((res) => {
                    this.result = res.data.result,
                    this.winnerScore = res.data.winnerScore
                })
        }
    },
}
</script>

<style lang="">
</style>