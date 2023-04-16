<template>
    <div>
        <p>4번</p>
        <button @click="clickSum">더하기</button><br>
        <button @click="clickSub">빼기</button><br>
        <button @click="clickMulti">곱하기</button>
        <button @click="clickDiv">나누기</button>
        <p>결과는 : {{ result }}</p>
    </div>
</template>

<script>
export default {
    name: "CalculaterComponent",
    props: {
        value1: Number,
        value2: Number
    },
    data () {
        return {
            result
        }
    },
    methods: {
        clickSum () {
            result = value1 + value2
        },
        clickSub () {
            result = value1 - value2
        },
        clickMulti () {
            result = value1 * value2
        },
        clickDiv () {
            result = value1 / value2
        }
    }
}
</script>

<style>
    
</style>