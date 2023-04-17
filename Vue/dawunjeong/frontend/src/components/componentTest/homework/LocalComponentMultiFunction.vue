<template>
    <div>
        숫자1: <input type="number" v-model.number="number1"><br>
        숫자2: <input type="number" v-model.number="number2"><br>
        <button @click="addNumber">더하기</button><br>
        <button @click="subNumber">빼기</button><br>
        <button @click="multipleNumber">곱하기</button><br>
        <button @click="divisionNumber">나누기</button>
        <p>결과: {{ resultNumber }}</p>
    </div>
</template>

<script>
export default {
    data () {
        return {
            number1: 0,
            number2: 0,
            resultNumber: 0
        }
    },
    methods: {
        addNumber () {
            this.resultNumber = this.number1 + this.number2
        },
        subNumber () {
            this.resultNumber = this.number1 - this.number2
        },
        multipleNumber () {
            this.resultNumber = this.number1 * this.number2
        },
        divisionNumber () {
            this.resultNumber = this.number1 / this.number2
        },
    }
}
</script>

<style>

</style>