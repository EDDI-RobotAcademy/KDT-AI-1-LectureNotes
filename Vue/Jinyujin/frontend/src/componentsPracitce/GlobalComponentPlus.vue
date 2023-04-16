<!-- 1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요. -->

<template>
    <div>
        <p>
            <input v-model.number="firstNum">
            <input v-model.number="secondNum">
        </p>
        <p>
            <button v-on:click = add(firstNum, secondNum)>덧셈계산</button>
        </p>
        <p>결과는 [{{ result }}]입니다.</p>
    </div>
</template>

<script>
export default {
    name: "addNumberGlobalComponent",
    // props가 바로 파라메터입니다.
    // v-bind로 전달된 initial-test는 initialTest가 됩니다.
    // '-'를 떼고 앞글자를 대문자로 변환합니다.
    // Java의 표현 방식과 동일한 관습을 가지고 있습니다.
    props: ['addNumber'], // java 파라메터 대신 props
    data() {
        return {
            result: add(firstNum, secondNum),
        }
    },
    methods: {
        addNumber() {
            this.addNumber
        }
    }
}
</script>

<style>
    
</style>