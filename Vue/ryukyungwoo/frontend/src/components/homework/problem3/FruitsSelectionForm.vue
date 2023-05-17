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
        <v-divider></v-divider>
        <h3>Review에 따른 또 다른 답안</h3>
        <v-btn color="primary" @click="otherCalculateFruitsForOrder">과일 가격 계산</v-btn>
        <p>최종 가격: {{ otherTotalPrice }}</p>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    props: {
        kindsOfFruits: Array,
    },
    data () {
        return {
            fruitsListForPrint: this.kindsOfFruits,
            totalPrice: 0,
            otherTotalPrice: 0,
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
                    appleName: fruitsListForPrint[0].name,
                    appleCount: fruitsListForPrint[0].count,
                    watermelonName: fruitsListForPrint[1].name,
                    watermelonCount: fruitsListForPrint[1].count,
                })
                .then((res) => {
                    console.log('result: ' + res.data)
                    this.totalPrice = res.data
                })
        },
        otherCalculateFruitsForOrder () {
            const { fruitsListForPrint } = this
            alert('orderedFruitsList: ' + JSON.stringify(fruitsListForPrint))

            console.log('appleCount: ' + fruitsListForPrint[0].count)
            console.log('watermelonCount: ' + fruitsListForPrint[1].count)

            axios.post('http://localhost:7777/buy-fruit/get-price-sum',
                { 
                    appleCount: fruitsListForPrint[0].count,
                    watermelonCount: fruitsListForPrint[1].count,
                })
                .then((res) => {
                    console.log('result: ' + res.data)
                    this.otherTotalPrice = res.data
                })
        },
    }
}
</script>

<style lang="">
    
</style>