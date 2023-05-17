<template>
    <div>
        
        <v-btn @click="bag">장바구니</v-btn>
            <!-- <li v-for="(fruit, index) in fruitList" :key="index">
            과일명: {{fruit.name}}, 가격: {{fruit.price}} -->
        <p>품명: 사과, 가격: 2000
            수량: <input type="number" length=2px min="0" v-model="apple"> 
        </p>
        <p>품명: 수박, 가격: 10000
            <!--수량: <input type="text" size=2px min="0" v-model="watermelon"> -->
            수량: <input type="number" size=2px min="0" v-model="watermelon">    
        </p>
    
            <br>
            <br>
            <v-btn @click="price">결제</v-btn>
            <p> 사과 {{appleNumber}} 개, 수박 {{watermelonNumber}} 결제할 금액: {{result}}</p>
        
    </div>
</template>
<script>
import axios from 'axios'
export default {
    
    
    data(){
        return{
            apple: 0,
            watermelon: 0,
            result: 0,
            appleNumber: 0,
            watermelonNumber: 0,

}
},
    methods:{
        bag () {
            const{apple,watermelon}=this
            axios.post('http://localhost:7777/problem3/buy-product',
            {apple,watermelon})
                .then((res) => {
                    alert('데이터 전송 성공!')
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
    },
        price () {
            axios.get('http://localhost:7777/problem3/product-sum')
                .then((res) => {
                    this.result = res.data.tmpSum
                    this.appleNumber = res.data.apple
                    this.watermelonNumber = res.data.watermelon
                })
                .catch((res) => {
                    alert('데이터 전송 실패!')
                })
}
}
}
</script>


<style scoped>
   input{
    width: 50px
   } 
</style>