<template lang="">
    <div>
       <p> {{firstNumber}}
        {{secondNumber}}
        {{thirdNumber}}</p>
    </div>
</template>
<script>
import axios from 'axios';
export default {
    data() {
        return {
            firstNumber:0,
            secondNumber:0,
            thirdNumber:0
        }
    },
    methods: {
        firstNum(){
        axios.get('http://localhost:7777/fastapi-test/first')
            .then((res) => {
               this.firstNumber=res.data
               console.log(res.data)
        })
         },
        secondNum(){
        axios.get('http://localhost:7777/fastapi-test/second')
            .then((res) => {
               this.secondNumber=res.data
               console.log(res.data)
        })
         },  
        thirdNum(){
        axios.get('http://localhost:8000/request-int-third')
            .then((res) => {
               this.thirdNumber=res.data
               console.log(res.data)
        })
        },
    
    },
    created() {
        this.firstNumber()
        this.secondNumber()
        this.thirdNumber()

    },
    }
</script>
<style lang="">
    
</style>