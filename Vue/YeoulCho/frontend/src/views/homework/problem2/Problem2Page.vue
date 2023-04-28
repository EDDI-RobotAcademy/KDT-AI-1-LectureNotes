<template>
    <div>
        <button color= "black" type="submit" @click="onSubmit">2개의 주사위 굴리기</button>
        <p>
            수신된 주사위의 합: {{ receivedDiceNubmer }} <br>
            결과: {{ result }}
        </p>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            receivedDiceNubmer: 0,
            result: "던지기전",
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/vue-test/get-random-dice-game')
                .then((res) => {
                    this.receivedDiceNubmer = res.data
                    if(res.data %2 ==0){
                        this.result = "주사위 합이 짝수이므로 승리";
                        console.log(res.data);
                    } else{
                    this.result = "주사위 합이 홀수이므로 패배";}
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