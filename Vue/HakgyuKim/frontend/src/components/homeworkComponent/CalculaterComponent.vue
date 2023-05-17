<template>
    <div>
        <p>4번</p>
        1번 숫자 = <input type="text" v-model="value1"><br>
        2번 숫자 = <input type="text" v-model="value2"><br>
        <button @click="clickSum">더하기</button><br>
        <button @click="clickSub">빼기</button><br>
        <button @click="clickMulti">곱하기</button><br>
        <button @click="clickDiv">나누기</button>
        <p>결과는 : {{ result }}</p>
    </div>
</template>

<script>
export default {
    name: "CalculaterComponent",
    data () {
        return {
            value1: '',
            value2: '',
            result: 0
        }
    },
    methods: {
        clickSum () {
            this.result = parseInt(this.value1) + parseInt(this.value2)
        },
        clickSub () {
            this.result = parseInt(this.value1) - parseInt(this.value2)
        },
        clickMulti () {
            this.result = parseInt(this.value1) * parseInt(this.value2)
        },
        clickDiv () {
            this.result = parseInt(this.value1) / parseInt(this.value2)
        }
    }
}
</script>

<style>
    
</style>