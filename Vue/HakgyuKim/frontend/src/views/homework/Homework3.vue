<template>
    <div>
        <h3>사과</h3>
        <form @submit.prevent="buyApple">
                구매할 사과 개수: <input type="text" v-model="boughtApples"> <br>
                <button type="submit">구매하기</button>
            </form>
        <h3>수박</h3>
        <v-btn color="primary" @click="buyWatermelon">구매하기</v-btn>
        <p>구매 총량: 사과 {{ boughtApples }} 개, 수박 {{ boughtWatermelons }} 개</p>
        <p>가격: {{ totalPrice }}</p>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    data () {
        return {
            boughtApples: 0,
            boughtWatermelons: 0,
            totalPrice: 0,
        }
    },
    methods: {
        buyApple() {
            const{boughtApples} = this
            axios.post('http://localhost:7777/fruit-problem/appleCount')
            .then((res) => {
                    alert('구매 성공!')
                })
            axios.get('http://localhost:7777/fruit-problem/buyApple')
            .then((res) => {
                this.totalPrice += res.data.applePrice
                console.log(res.data)

            })
        },

        buyWatermelon() {
            axios.get('http://localhost:7777/fruit-problem/buyWatermelon')
            .then((res) => {
                this.boughtWatermelons += res.data.watermelonCount
                this.totalPrice += res.data.watermelonPrice
                console.log(res.data)

            })
        }
    
}
}

</script>

<style>
    
</style>