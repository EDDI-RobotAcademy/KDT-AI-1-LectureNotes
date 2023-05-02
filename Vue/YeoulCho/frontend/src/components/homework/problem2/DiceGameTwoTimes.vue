<template lang="">
    <div>
        <h3>주사위 2개를 굴려 합이 짝수면 승리 홀수면 패배!</h3>
        <v-btn color="primary" @click="startTwoTimesDiceGame">주사위 게임 시작!</v-btn>
        <p>얻은 결과: {{ playingNumber }}, 승자 판정: {{ result }}</p>
    <v-divider></v-divider>
    <div style="text-align: left; padding: 20px;">
    <h3>컴퓨터와 3개 주사위를 굴리겠다</h3>
    첫번째 주사위가 짝수라면 두번쨰와 세번째를 굴릴 수 있습니다
    <v-btn color="primary" @click="startTwoTimesDiceGame">주사위 게임 시작!</v-btn>
    </div>
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
                    this.result = res.data.result
                    this.playingNumber = res.data.winnerNumber
                })
                .catch((res) => {
                    console.log(123);
                })
        },
        startDiceGameWithComputer(){
            axios.get("http://localhosr:7777/dice-game/secondGame")
            .then((res) =>{
                
            })
        }
    }
}
</script>

<style lang="">
    
</style>