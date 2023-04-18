<template lang="">
    <div>
       <h1>과일 가게</h1>
       <p></p>
       <h3>원하는 과일을 선택하세요.</h3>
       <v-btn color="primary" @click="buyApple" v-model="appleNum">사과 구매</v-btn>
       <v-btn color="primary" @click="buyWaterMelon" v-model="waterMelon">수박 구매</v-btn><br>
       <p></p>
       <p>구매한 사과의 개수: {{ appleNum }} 개</p>
       <p>구매한 수박의 개수: {{ waterMelonNum }} 개</p>
       <h3>구매한 과일의 총 합계: {{ applePrice + waterMelonPrice }} 원</h3>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data () {
        return {
            appleNum: 0,
            applePrice: 0,
            fruitName: '',
            waterMelonNum: 0,
            waterMelonPrice: 0,
        }
    },
    methods: {
        buyApple () {
            this.appleNum++
            this.fruitName = 'apple'

            axios.post('http://localhost:7777/buy-fruit/apple', {fruitNum: this.appleNum, fruitName: this.fruitName})
            .then((res) => {
                alert('데이터 전송 성공!')      
                axios.get('http://localhost:7777/buy-fruit/apple-price')
                .then((res) => {
                    alert('요청에 대한 응답 데이터: ' + res.data)
                    this.applePrice = res.data
                })
                .catch((res) => {
                    alert('데이터 가져오기 실패!')
                })
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        },
        buyWaterMelon () {
            this.waterMelonNum++
            this.fruitName = 'waterMelon'

            axios.post('http://localhost:7777/buy-fruit/watermelon', {fruitNum: this.waterMelonNum, fruitName: this.fruitName})
            .then((res) => {
                alert('데이터 전송 성공!')
                axios.get('http://localhost:7777/buy-fruit/watermelon-price')
                .then((res) => {
                    alert('요청에 대한 응답 데이터: ' + res.data)
                    this.waterMelonPrice = res.data
                })
                .catch((res) => {
                    alert('데이터 가져오기 실패!')
                })
            })
            .catch((res) => {
                alert('데이터 전송 실패!')
            })
        },
    }
}
</script>

<style lang="">
    
</style>