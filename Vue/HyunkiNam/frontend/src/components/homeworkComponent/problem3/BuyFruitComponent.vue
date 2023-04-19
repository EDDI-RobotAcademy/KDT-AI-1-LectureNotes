<template>
    <div>
        <form>
            <fieldset>
                <legend>Vue 문제 은행 3</legend>
                <ul>
                    <form @submit.prevent="buyApple">
                        사과&nbsp;
                        <input type="text" v-model="apple">
                        <button type="submit">구매</button>
                    </form>

                    <form @submit.prevent="buyWatermelon">
                        수박&nbsp;
                        <input type="text" v-model="watermelon">
                        <button type="submit">구매</button>
                    </form>

                    <form @submit.prevent="getBuyList">
                        <button type="submit">구매 리스트 확인</button>
                    </form>
                    사과 : {{ appleAmount }}&nbsp; 수박 : {{ watermelonAmount }}<br>
                    가격 : {{ buyPriceSum }}
                    <br><br>
                    <form @submit.prevent="buyFruit">
                        사과&nbsp;
                        <input type="number" v-model="apple2" value="1" min="1" max="10" step="1">
                        수박&nbsp;
                        <input type="number" v-model="watermelon2" value="1" min="1" max="10" step="1">
                        <button type="submit">구매</button>
                    </form>
                    {{ apple2 }} {{ watermelon2 }}

                    <form @submit.prevent="getBuyList2">
                        <button type="submit">구매 리스트 확인</button>
                    </form>
                    사과 : {{ appleAmount2 }}&nbsp; 수박 : {{ watermelonAmount2 }}<br>
                    가격 : {{ buyPriceSum2 }}
                </ul>

            </fieldset>
        </form>

    </div>
</template>
<script>

import axios from 'axios'

export default {

    name: "BuyFruitComponent",
    data() {
        return {
            apple: 0,
            watermelon: 0,

            apple2: '',
            watermelon2: '',

            appleAmount: 0,
            watermelonAmount: 0,
            buyPriceSum: 0,

            appleAmount2: 0,
            watermelonAmount2: 0,
            buyPriceSum2: 0,
        }
    },
    methods: {
        buyApple() {
            this.apple++
            const { apple } = this
            axios.post('http://localhost:7777/homework/buy-apple',
                { apple })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        buyWatermelon() {
            this.watermelon++
            const { watermelon } = this
            axios.post('http://localhost:7777/homework/buy-watermelon',
                { watermelon })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        buyFruit() {
            //const { apple2, watermelon2 } = this
            axios.post('http://localhost:7777/homework/buy-fruit',
                { apple2: this.apple2, watermelon2: this.watermelon2 }, { "Content-Type": "application/json" })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
        },
        getBuyList() {
            axios.get('http://localhost:7777/homework/get-buy-list')
                .then((res) => {
                    this.appleAmount = res.data.apple
                    this.watermelonAmount = res.data.watermelon
                    this.buyPriceSum = res.data.buyPriceSum
                })
                .catch((res) => {
                    alert('데이터 수신 실패!')
                })
        },
        getBuyList2() {
            axios.get('http://localhost:7777/homework/get-buy-list2')
                .then((res) => {
                    this.appleAmount2 = res.data.apple
                    this.watermelonAmount2 = res.data.watermelon
                    this.buyPriceSum2 = res.data.buyPriceSum
                })
                .catch((res) => {
                    alert('데이터 수신 실패!')
                })
        }
    }
}
</script>
<style></style>