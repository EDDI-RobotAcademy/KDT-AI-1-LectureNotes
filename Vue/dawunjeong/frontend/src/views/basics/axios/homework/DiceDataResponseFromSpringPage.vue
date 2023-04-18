<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            승패 판정: {{ receivedWin }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data () {
        return {
        receivedWin: ''
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/vue-homework/get-random-dice-winner')
            .then((res) => {
                alert('요청에 대한 응답 데이터: ' + res.data)
                this.receivedWin = res.data
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