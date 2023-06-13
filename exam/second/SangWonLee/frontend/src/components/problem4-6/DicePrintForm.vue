<template lang="">
    <div>
        <br>
        <button class="diceNumberCss" type="submit" @click="onSubmit">주사위 굴리기 버튼</button>

        <p>
            주사위 번호 : {{ receivedDiceNumber }}
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
        onSubmit() {
            axios.get('http://localhost:7777/problem4-6/dice-print')
                .then((res) => {
                    this.receivedDiceNumber = res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        }
    },


}
</script>
<style scoped>
.diceNumberCss {
    background-color: red;
}
</style>