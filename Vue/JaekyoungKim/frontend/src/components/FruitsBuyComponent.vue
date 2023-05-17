<template lang="">
    <div>
        {{ fruitsListForPrint }}
        <table v-for="(fruits, index) in this.fruitsListForPrint" :key="index">
            <tr>
                <td>
                    {{ fruits.name }}: <input type="number" v-model="fruits.min"/>
                </td>
            </tr>
        </table>
        <v-btn color="primary" @click="calculateFruitsForOrder">과일 가격 계산</v-btn>
        <p>최종 가격: {{ totalPrice }}</p>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    props: {
        kindsOfFruits: Array, // kindsOfFruits는 배열 형식으로 받을거야 그러니까 배열로 보내줘
    },
    data () {
        return {
            fruitsListForPrint: this.kindsOfFruits,// 페이지에 지정된 값을 가져온다 사과 3개 수박 2개
            totalPrice: 0,
        }
    },
    methods: {
        calculateFruitsForOrder () {
            const { fruitsListForPrint } = this
            alert('orderedFruitsList: ' + JSON.stringify(fruitsListForPrint))
            console.log('appleName: ' + fruitsListForPrint[0].name)
            console.log('appleCount: ' + fruitsListForPrint[0].count)
            console.log('watermelonName: ' + fruitsListForPrint[1].name)
            console.log('watermelonCount: ' + fruitsListForPrint[1].count)
            axios.post('http://localhost:7777/fruits-test/calculate',
                { 
                    // 불변객체화 한 과일 리스트 보내기
                    appleName: fruitsListForPrint[0].name,
                    appleCount: fruitsListForPrint[0].count,
                    watermelonName: fruitsListForPrint[1].name,
                    watermelonCount: fruitsListForPrint[1].count,
                })
                .then((res) => {
                    console.log('result: ' + res.data)
                    this.totalPrice = res.data
                    //넘어오는건 Integer 총합 가격만 넘어오기 때문에
                    // 토탈 가격에 넣어주면 됩니다.
                })
        },
    }
}
</script>

<style lang="">
    
</style>