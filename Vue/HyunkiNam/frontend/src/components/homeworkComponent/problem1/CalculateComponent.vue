<template>
    <div>
        4번<br>
        number1 = <input type="text" v-model="number1"><br>
        number2 = <input type="text" v-model="number2"><br><br>
        <button @click="plusNumber"> 덧셈 </button>&nbsp; &nbsp;
        <button @click="minusNumber"> 뺄셈 </button>&nbsp; &nbsp;
        <button @click="multipleNumber"> 곱셈 </button>&nbsp; &nbsp;
        <button @click="divisionNumber"> 나눗셈 </button><br><br>

        number1 = {{ number1 }}
        number2 = {{ number2 }}
        결과 = {{ calcResult }} <br><br>
    </div>
</template>
<script>
export default {
    name: "CalculateComponent",

    data() {
        return {
            number1: '',
            number2: '',
            calcResult: 0
        }
    },
    methods: {
        plusNumber() {
            this.calcResult = parseInt(this.number1) + parseInt(this.number2)
        },
        minusNumber() {
            this.calcResult = parseInt(this.number1) - parseInt(this.number2)
        },
        multipleNumber() {
            this.calcResult = parseInt(this.number1) * parseInt(this.number2)
        },
        divisionNumber() {
            this.calcResult = parseInt(this.number1) / parseInt(this.number2)
        }
    },
}
</script>
<style></style>