<template lang="">
    <div>
        <p>사과 개수를 입력하세요.<input type="number" v-model="appleNum"></p>
        <p>수박 개수를 입력하세요.<input type="number" v-model="watermelonNum"></p>
        <p>선택한 과일의 개수: 사과 {{ appleNum }}개, 수박 {{watermelonNum}}개</p>
        <p><v-btn @click="calculateFruitsPrice">계산하기</v-btn></p>
        <p>총 금액: {{ totalPrice }}</p>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    data () {
        return {
            appleNum: 0,
            watermelonNum: 0,
            totalPrice: 0,
        }
    }, 
    methods: {
        calculateFruitsPrice () {
            axios.post('http://localhost:7777/fruits-store/calculate-fruits',
            {appleNum: this.appleNum, watermelonNum: this.watermelonNum})
            .then((res) => {
                alert('데이터 전송 성공')
                this.totalPrice = res.data
            })
            .catch((res) => {
                alert('데이터 전송 실패')
            })
        }
    }
}
</script>
<style lang="">
    
</style>