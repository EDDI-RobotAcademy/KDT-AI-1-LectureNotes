<template>
    <div>
        <button type="submit" @click="onSubmit">버튼</button>
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
            receivedDiceNumber: 0
        }
    },
    methods: {
        onSubmit() {
            axios.get('http://localhost:7777/vue-test/get-random-dice')
                .then((res) => {
                    alert('데이터 수신 성공!' + res.data)
                    this.receivedDiceNumber = res.data
                })
                .catch((res) => {
                    alert('데이터 수신 실패!')
                })
        }
    }

}
</script>
<style></style>