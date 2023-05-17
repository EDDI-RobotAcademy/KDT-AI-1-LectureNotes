<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            수신된 주사위 번호 {{ receivedDiceNumber }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {
            receivedDiceNumber: 0,
        }
    },
    methods: {
        onSubmit () {
        axios.get('http://localhost:7777/vue-test/get-random-dice')
        .then((res) => {
            this.receivedDiceNumber = res.data
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