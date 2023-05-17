<template lang="">
    <div>
        <h3>1. 랜덤한 주사위 2개를 돌립니다.<br>
            돌린 주사위의 값의 합이 짝수라면 승리를 반환하고 홀수라면 패배를 반환합니다.</h3>
        <v-btn @click="startDiceGame2">주사위게임 시작!</v-btn>
        <p> 얻은 결과 : {{playingNumber}} <br>
        승자 판정: {{ result }}</p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            result: '알 수 없음',
            playingNumber: 0,
        }
    },
    methods: {
        startDiceGame2 () {
            axios.get
        }
    }
}
</script>

<style lang="">
    
</style>