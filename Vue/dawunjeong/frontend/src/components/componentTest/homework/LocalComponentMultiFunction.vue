<template>
    <div>
        첫번째 숫자 입력: <input type="number" v-model.number="number1" style="text-align: center; width: 60px;"><br>
        두번째 숫자 입력: <input type="number" v-model.number="number2" style="text-align: center; width: 60px;"><br>
        <p>원하는 연산을 선택하세요.</p>
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