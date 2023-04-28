<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            수신된 주사위 번호: {{ receivedDiceNumber }}
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
        // 아래와 같이 데이터에 대한 요청은 Front에서 
        // 데이터를 처리해서 전달하는 것은 Back으로 분리할 수 있습니다.
        onSubmit() {
            axios.get('http://localhost:7777/vue-test/get-random-dice',)
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

<style>
</style>