<template >
    <div>
        <h3>사과와 포도를 갯수 정하고 버튼 누르면 총 가격을 받을 수 있게 만들어야함</h3>
        <form @submit.prevent="onSubmit">
        <p>사과 : <input type="number" v-model="appleAmount"></p>
        <p>포도 :<input type="number" v-model="grapeAmount"></p>
        <button type="submit">button</button>
        <br>
        <p>{{ allFruitsPrice }}</p>
        </form>
    </div>
</template>
<script>
import axios from 'axios';
export default {

    name:"FruitsBuyComponent",
    data() {
        return {
            allFruitsPrice:0,
            appleAmount:0,
            grapeAmount:0

           
            
        }
    },
    methods: {
        onSubmit(){
            const{appleAmount,grapeAmount} =this
            axios.post('http://localhost:7777/fruits-test/fruits-calculate', { appleAmount,grapeAmount })
            .then((res)=>{
                this.allFruitsPrice=res.data
            })
            .catch((res)=>{
                alert('데이터 전송 실패!')
            })
        },
       
}}
</script>
<style >
    
</style>