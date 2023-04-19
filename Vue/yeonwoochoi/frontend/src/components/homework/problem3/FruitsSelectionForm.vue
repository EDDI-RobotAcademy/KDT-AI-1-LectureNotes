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
    // Vue 객체내에 배치되는 지역 변수
    // (class라 생각해도 무방)
    data () {
        return {
            fruitsListForPrint: this.kindsOfFruits,
            totalPrice: 0,
        }
    },
    methods: {
        calculateFruitsForOrder () {
            // javascript 문법 에서 ‘{ blablabla }’ 형태는 객체를 만드는 행위
            // const : 불변 객체를 만든다는 의미 (const 붙은 데이터들을 한 번 초기화하고 유지, 
            // 이 값은 변경이 불가능한 고정값으로 유지)
            // this : 자기 자신의 객체에 해당
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
    }
}
</script>

<style lang="">
    
</style>