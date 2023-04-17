<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            결과는:  {{ receivedWinLoss }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {
            receivedWinLoss: '',
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
    }
}
}
</script>
<style lang="">
    
</style>