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
        <p>최종가격: {{ totalPrice }}</p>
    </div>
</template>

<script>

import axios from 'axios';

export default {
    //값을 배열로 나타내줄 생각이니까 우선 props를 배열로 생성해줌
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
            // const를 주석처리 했더니 fuitsListForPrint is not defined 라고 나오는 오류

            alert( 'orderedFruitsList: ' + JSON.stringify(fruitsListForPrint) )

            console.log('appleName: ' + fruitsListForPrint[0].name)
            console.log('appleCount: ' + fruitsListForPrint[0].count)
            console.log('watermelonName: ' + fruitsListForPrint[1].name)
            console.log('watermelonCount: ' + fruitsListForPrint[1].count)

            axios.post('http://localhost:7777/fruits-test/calculate', 
                {   // axios.post() 메서드는 서버로 POST 요청을 보내는 것
                    // 그래서 Spring으로 데이터를 보내고 싶을 때는 여기에 데이터를 처리해 줘야 한다
                    // 아래 있는 애들도 Spring으로 데이터를 보낸 것
                    appleName: fruitsListForPrint[0].name,
                    appleCount: fruitsListForPrint[0].count,
                    watermelonName: fruitsListForPrint[1].name,
                    watermelonCount: fruitsListForPrint[1].count
                })
                .then((res) => {
                    // axios.then() 메서드를 사용하여 Spring에서 반환된 데이터를 처리해주는 것
                    // 그래서 Spring에서 반환된 데이터들은 이 데이터 안에서 처리해주는 것이다
                    console.log('result: ' + res.data)
                    this.totalPrice = res.data
                    // totalPrice는 Spring에서 데이터를 받아옴
                    // Spring에서 받아온 데이터를 res 매개변수로 받아와서 
                    // data에 있는 totalPrice 값에 넣어주기 위해 this.totalPrice에 저장하는 것
                    // 그래서 결국엔 Spring에서 받아온 데이터가 UI에 나타날 수 있는 것이다
                })
        },
    }
}
</script>

<style lang="">
</style>