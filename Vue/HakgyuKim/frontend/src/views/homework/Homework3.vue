<template>
    <div>
        <h3>과일 구매</h3>
        <form @submit.prevent="buyApple">
                구매할 사과 개수: <input type="number" v-model="appleCount" value="1" min="1" max="10" step="1"><br>
                구매할 수박 개수:  <input type="range" v-model="watermelonCount" value="1" min="1" max="10" step="1"> <br>
                <v-btn color="secondary" type="submit">담기</v-btn>
        </form>
        <p>구매 총량: 사과 {{ appleCount }} 개, 수박 {{ watermelonCount }} 개</p>
            <v-btn color="secondary" @click="getTotalPrice">가격 확인하기</v-btn>
        <p>가격: {{ totalPrice }}</p>
    </div>
</template>
<script>

import axios from 'axios';

export default {
    data () {
        return {
            appleCount: 1,
            watermelonCount: 1,
            totalPrice: 0,
        }
    },
    methods: {
        buyApple() {
            const{appleCount, watermelonCount} = this
            axios.post('http://localhost:7777/fruit-problem/buyFruit',
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
}
}

</script>

<style>
    
</style>