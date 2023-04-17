<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            승리 플레이어: {{ receivedDiceGamewinner }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            receivedDiceGamewinner: ''
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/vue-test/get-dice-game-manager')
            .then((res) => {
                alert('요청에 대한 응답 데이터: ' + res.data)
                this.receivedDiceGamewinner = res.data
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        }
    }
}
</script>

<style>
    
</style>