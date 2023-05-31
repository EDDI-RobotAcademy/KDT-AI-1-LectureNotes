<template>
    <div>
        <button type="submit" @click="onSubmit">주사위 굴리기</button>
        <p>
            수신된 주사위 번호: {{ receivedDiceNubmer }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'
import mainRequest from "@/api/mainRequest";
export default {
    data () {
        return {
            receivedDiceNubmer: 0,
        }
    },
    methods: {
        onSubmit () {
            // 아래와 같이 데이터에 대한 요청은 Front에서
            // 데이터를 처리해서 전달하는 것은 Back으로 분리할 수 있습니다.
            mainRequest.get('/vue-test/get-random-dice')
                .then((res) => {
                    this.receivedDiceNubmer = res.data
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