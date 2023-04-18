<template lang="">
    <div>
        <h3>주사위 2개를 굴려 합이 짝수면 승리 홀수면 패배!</h3>
        <v-btn color="primary" @click="startTwoTimesDiceGame">주사위 게임 시작!</v-btn>
        <p>얻은 결과: {{ playingNumber }}, 승자 판정: {{ result }}</p>
        <v-divider></v-divider>
        <h3>
            컴퓨터와 주사위 3개를 굴립니다. 
            첫 번째 주사위가 짝수라면 두 번째와 세번째를 굴릴 수 있습니다.
            세 번째 주사위의 숫자가 1인 경우 상대편 점수를 3점 뺏습니다.
            3인 경우 자신에게 2점을 가산합니다.
            4인 경우엔 무조건 패배합니다.
        </h3>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data () {
        return {
            result: '알 수 없음',
            playingNumber: 0,
        }
    },
    methods: {
        startTwoTimesDiceGame () {
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