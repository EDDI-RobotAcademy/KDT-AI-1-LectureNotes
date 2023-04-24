<template>
    <div>
       <p>{{ firstNumber }} - {{ secondNumber }} = {{ Number(firstNumber) - Number(secondNumber) }}</p>
       <label for="num1">firstNumber: </label>
       <input type="text" v-model="firstNumber"><br><br>
       <label for="num1">secondNumber: </label>
       <input type="text" v-model="secondNumber">
    </div>
</template>
<script>
export default {
    name: "subtraction-local-component",
    props: {
        firstNumber: Number,
        secondNumber: Number,
        
    },
    data() {
        return{
           Result: this.firstNumber - this.secondNumer
        }
        
    },
    methods: {
        
    }
}
</script>
<style>
input{
    border : 1px solid black;
}
    
</style>