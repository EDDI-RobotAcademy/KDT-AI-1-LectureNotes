<!-- 
    2000원짜리 사과 3개, 10000원짜리 수박 5개를 구매해봅시다.
    Vue에 UI를 구성하고 Spring에서 데이터를 처리해서 총합을 알려주세요.
    어떤 물건을 구했는지 알 수 있어야 합니다.
-->

<template lang="">
    <div>
        <p>사과 1개 가격은 2000원, 수박 1통 가격은 10000원 입니다.</p>
        <label>
            <input type="number" v-model="appleCount" value="사과개수">구매할 사과개수<br>
            <input type="number" v-model="watermelonCount" value="수박개수">구매할 수박개수<br>
        </label>
    </form>
        <v-btn type="submit" @click="getPriceSum">구매하기</v-btn>
        <p> 구매 총 합: {{ priceSum }}</p>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    data() {
        return {
            priceSum: 0,
            appleCount: 0,
            watermelonCount: 0,
        }
    },
    methods: {
        getPriceSum() {
            axios.post('http://localhost:7777/buy-fruit/get-price-sum',
            {appleCount: this.appleCount, watermelonCount: this.watermelonCount}) // Spring - form으로 데이터를 보내는 것
                .then((res) => {
                    // 여기가 Spring에서 데이터를 받아오는 애들 처리하는 곳
                    // this.appleCount = res.data.appleCount
                    // this.watermelonCount = res.data.watermelonCount
                    this.priceSum = res.data
                })
        },     
    },
}
</script>

<style lang="">
</style>