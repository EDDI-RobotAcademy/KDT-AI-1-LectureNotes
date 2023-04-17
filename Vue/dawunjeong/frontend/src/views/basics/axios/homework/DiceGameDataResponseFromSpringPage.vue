<template>
    <div>
        <button type="submit" @click="onSubmit">플레이어1 주사위 굴리기</button>
        <p>
            플레이어1 주사위의 합: {{ receivedDiceSum }}
        </p>
        <button type="submit" @click="onSubmit2">플레이어2 주사위 굴리기</button>
        <p>
            플레이어2 주사위의 합: {{ receivedDiceSum2 }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
            receivedDiceSum: 0, 
            receivedDiceSum2: 0,
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/vue-test/get-random-dice-list')
            .then((res) => {
                alert('요청에 대한 응답 데이터: ' + res.data)
                this.receivedDiceSum = res.data
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        },
        onSubmit2 () {
            axios.get('http://localhost:7777/vue-test/get-random-dice-list')
            .then((res) => {
                alert('요청에 대한 응답 데이터: ' + res.data)
                this.receivedDiceSum2 = res.data
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        },
    }
}
</script>

<style>
    
</style>