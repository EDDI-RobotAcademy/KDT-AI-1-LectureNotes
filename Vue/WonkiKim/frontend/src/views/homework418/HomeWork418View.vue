<template>
  <v-container>
      사과 갯수: {{numApple}}, 수박 갯수: {{numWatermelon}}
      <br>
      <v-btn @click="()=>{numApple++;calculatePrice()}">+Apple</v-btn>
      <v-btn @click="()=>{numApple--;calculatePrice()}">-Apple</v-btn>
      <v-btn @click="()=>{numWatermelon++;calculatePrice()}">+Watermelon</v-btn>
      <v-btn @click="()=>{numWatermelon--;calculatePrice()}">-Watermelon</v-btn>
      <br>
      <br>
      <v-btn @click="getPrice">calculate</v-btn> <br>
      과일 가격의 총 합: {{totalPrice}}

  </v-container>
</template>

<script>
import axios from "axios";

export default {
    data() {
        return {
            numApple:0,
            numWatermelon:0,
            totalPrice:0
        }
    },
    methods: {
        calculatePrice() {
            const {numApple, numWatermelon} = this
            axios.post('http://localhost:7777/homework-418/calculate-price',
                {numApple, numWatermelon})
                .then((res) => {
                    console.log("데이터 전송 성공")
                }).catch((res) => {
                console.log("데이터 전송 실패")
            });
        },
        getPrice() {
            axios.get('http://localhost:7777/homework-418/get-total-price')
                .then((res) => {
                    console.log(res.data)
                    console.log("데이터 수신 성공")
                    this.totalPrice = res.data.totalPrice


                }).catch((res) => {
                    console.log("데이터 수신 실패")
            })

        }

    }
}
</script>