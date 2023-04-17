<template>
    <div>
        1번 <br>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            결과는:  {{ receivedWinLoss }}
        </p>
        2번 <br>
        <button type="submit" @click="playGame">게임 플레이</button>
        <p>
            결과는: {{ gameResult }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {
            receivedWinLoss: '',
            gameResult: '',
        }
    },
    methods: {
        onSubmit () {
        axios.get('http://localhost:7777/vue-test/roll-two-dice')
        .then((res) => {
            this.receivedWinLoss = res.data
        })
        .catch((res) => {
            alert('데이터 전송 실패!')
        })
    },
        playGame () {
            axios.get('http://localhost:7777/dice-game/play-game')
            .then((res) => {
            this.gameResult = res.data
        })
        .catch((res) => {
            alert('데이터 전송 실패!')
        })
        }
}
}
</script>
<style lang="">
    
</style>