<template>
  <div>
    <h3>2000원짜리 사과 3개, 10000원짜리 수박 5개를 구매해봅시다.</h3>
    <input type="number" v-model="apple">사과<br>
    <input type="number" v-model="watermelon">수박<br>
    <v-btn color="primary" @click="AllPrice">계산</v-btn>
    <p>사과의 값: {{ applePrice }}, 수박의 값: {{ watermelonPrice }}</p>
    <p>총합: {{ result }}</p>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    data () {
        return {
            apple: 0,
            watermelon: 0,
            result: 0,
            applePrice: 0,
            watermelon: 0,
        }
    },
    methods: {
        AllPrice () {
            axios.get('http://localhost:7777/apple-watermelon/result',
            {apple: this.apple, watermelon: this.watermelon})
            .then((res) => {
                console.log('applePrice: ' + res.data.applePrice)
                console.log('watermelonPrice: ' + res.data.watermelonPrice)
                console.log('result: ' + res.data.priceSum)
                this.applePrice = res.data.applePrice
                this.watermelonPrice = res.data.watermelonPrice
                this.result = res.data.priceSum
            })
        }        
    }
}
</script>

<style>

</style>