<template lang="">
    <div>
        <!--
            바로 밑의 변수?는 name과 count를 보여주는 일종의 메뉴판 같은 것
		    그냥 뭐 있는지 보여주는 것에 불과함
        -->
        {{ fruitsListForPrint }}

        <!-- 아래 table은 없어도 무방하다. -->
        <!-- <table v-for="(fruits, index) in this.fruitsListForPrint" :key="index">
            <tr>
                <td>
                    {{ fruits.name }}: <input type="number" v-model="fruits.min"/>
                </td>
            </tr>
        </table> -->
        <br>
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
            // 위에서 매개변수로 받아온 값이며 안에는 name, count가 들어있음
            fruitsListForPrint: this.kindsOfFruits,

            totalPrice: 0,
        }
    },
    methods: {
        calculateFruitsForOrder () {
            // Q. ? 변수선언 같은 건가 ?
            const { fruitsListForPrint } = this
            /* A.
                위 코드는 vue 객체내에 있는 data 정보를
                axios가 사용할 때 연결하지 못하는 문제를 해결하기 위해 구성합니다.
                this는 vue 객체 자체를 의미하므로
                data ()에 있는 이름과 동일한 형태의 변수명을 const { 이름 } = this로 구성하여
                실제 vue 객체(현재 컴포넌트)가 가지고 있는 data를
                해당 변수 이름에 보관하게 됩니다.
                변수명이 같아야만 성립하기 때문에
                담고 싶은 정보를 적절하게 배치해줘야 합니다.
            */

            // 그냥 정보 출력
            alert('orderedFruitsList: ' + JSON.stringify(fruitsListForPrint))

            // 매개변수로 받아와서 각 변수에 들어간 친구들을 콘솔 창에 출력해보고 있다.
            console.log('appleName: ' + fruitsListForPrint[0].name)
            console.log('appleCount: ' + fruitsListForPrint[0].count)
            console.log('watermelonName: ' + fruitsListForPrint[1].name)
            console.log('watermelonCount: ' + fruitsListForPrint[1].count)

            axios.post('http://localhost:7777/fruits-test/calculate',
                {   // 매개변수로 받은 리스트 안에 있는 값을 차례대로 각 변수(?)에 넣어주고 있다.
                    appleName: fruitsListForPrint[0].name,
                    appleCount: fruitsListForPrint[0].count,
                    watermelonName: fruitsListForPrint[1].name,
                    watermelonCount: fruitsListForPrint[1].count,
                })
                .then((res) => {
                    console.log('result: ' + res.data)
                    // axios 호출에 대한 결과 값 (총합)을 받아왔다.
                    this.totalPrice = res.data
                })
        },
    }
}
</script>

<style lang="">
    
</style>