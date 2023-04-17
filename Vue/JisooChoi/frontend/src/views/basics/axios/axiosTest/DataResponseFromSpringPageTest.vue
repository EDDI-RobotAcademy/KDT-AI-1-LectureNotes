<template>
    <div>
        <button type="submit" @click="onSubmitNum1">첫 번째 주사위 굴리기</button>
        <p>수신된 첫 번째 주사위: {{ receiveDiceOne }}</p>

        <button type="submit" @click="onSubmitNum2">두 번째 주사위 굴리기</button>
        <p>수신된 두 번째 주사위: {{ receiveDicetwo }}</p>

        <p>합산 결과 : {{  }}</p>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            receiveDiceOne:0,
            receiveDicetwo:0,
        }
    },
    methods: {
        onSubmitNum1 () {
            axios.get('http://localhost:7777/vue-test/get-random-dice')
                .then((res) => {
                    this.receiveDiceOne = res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        onSubmitNum2 () {
            axios.get('http://localhost:7777/vue-test/get-random-dice')
                .then((res) => {
                    this.receiveDicetwo = res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        // 여기에 각 주사위를 매개변수로 보내주는 메서드가 필요하다.
        
    }
}
</script>

<style>
    
</style>