<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            수신된 주사위 번호 : {{ receivedDiceNubmer1 }}, {{ receivedDiceNubmer2 }}
        </p>
        <p v-if="(receivedDiceNubmer1 + receivedDiceNubmer2) % 2 == 0">결과 : 승리</p>
        <p v-if="(receivedDiceNubmer1 + receivedDiceNubmer2) % 2 == 1">결과 : 패배</p>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            receivedDiceNubmer1: 0,
            receivedDiceNubmer2: 0,
        }
    },
    methods: {
        onSubmit () {
            // 아래와 같이 데이터에 대한 요청은 Front에서
            // 데이터를 처리해서 전달하는 것은 Back으로 분리할 수 있습니다.
            axios.get('http://localhost:7777/vue-test/get-random-dice')
                .then((res) => {
                    this.receivedDiceNubmer1 = res.data
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
            axios.get('http://localhost:7777/vue-test/get-random-dice')
                .then((res) => {
                    this.receivedDiceNubmer2 = res.data
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