<template>
    <div>
        <h3>과일 구매</h3>
        <form @submit.prevent="buyApple">
                구매할 사과 개수: <input type="text" v-model="appleCount"> <br>
                구매할 수박 개수: <input type="text" v-model="watermelonCount"> <br>
                <v-btn color="primary" type="submit">담기</v-btn>
        </form>
        <p>구매 총량: 사과 {{ appleCount }} 개, 수박 {{ watermelonCount }} 개</p>
            <v-btn color="primary" @click="getTotalPrice">가격 확인하기</v-btn>
        <p>가격: {{ totalPrice }}</p>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    data () {
        return {
            appleCount: 0,
            watermelonCount: 0,
            totalPrice: 0,
        }
    },
    methods: {
        buyApple() {
            const{appleCount, watermelonCount} = this
            axios.post('http://localhost:7777/fruit-problem/appleCount',
            {appleCount, watermelonCount})
            .then((res) => {
                    alert('담기 성공!')
                })
        },

        getTotalPrice() {
            axios.get('http://localhost:7777/fruit-problem/total-price')
            .then((res) => {
                this.totalPrice = res.data
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