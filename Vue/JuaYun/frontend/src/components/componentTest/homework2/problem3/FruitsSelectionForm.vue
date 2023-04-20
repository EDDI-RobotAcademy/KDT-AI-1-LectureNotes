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
        kindsOfFruits: Array,
    },
    data () {
        return {
            fruitsListForPrint: this.kindsOfFruits,
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
            axios.get('http://localhost:7777/fruits-test/calculate',
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
    }
}
</script>

<style lang="">
    
</style>