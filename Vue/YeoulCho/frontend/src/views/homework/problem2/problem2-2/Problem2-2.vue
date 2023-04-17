<template>
    <div>
        <button type="submit" @click="onSubmit">Play</button>
        <p>Player1<br>
            주사위 1: {{ receivedDiceNumber}} <br>
            <!-- 주사위 2: {{ receivedDiceNubmer2 }} <br>
            주사위 3: {{ receivedDiceNubmer3 }} <br> -->
            주사위 점수 결과: {{ result }}
        </p>
        <!-- <p>Player2<br>
            주사위 1: {{ receivedDiceNubmer }} <br>
            주사위 2: {{ receivedDiceNubmer2 }} <br>
            주사위 3: {{ receivedDiceNubmer3 }} <br>
            주사위 점수 결과: {{ result }}
        </p> -->
    </div>
</template>

<script>
import axios from 'axios'
export default {
    data () {
        return {
            receivedDiceNubmerList: [
            { id: 1, name: '슬라임', hp:30},
            { id: 2, name: '슬라임', hp:30},
            { id: 3, name: '슬라임', hp:30}
        ],
            
            result: "던지기전",
        }
    },
    methods: {
        onSubmit () {
            axios.get('http://localhost:7777/vue-test/get-problem-2-2')
                .then((res) => {
                
                this.receivedDiceNumber = res.data
                    
                    // if(res.data %2 ==0){
                    //     this.result = "주사위 합이 짝수이므로 승리";
                    // } else{
                    // this.result = "주사위 합이 홀수이므로 패배";}
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