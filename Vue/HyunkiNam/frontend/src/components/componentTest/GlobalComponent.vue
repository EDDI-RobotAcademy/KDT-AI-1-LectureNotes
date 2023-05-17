<template>
    <div>
        <button @click="addCounter">{{ counterValue }}</button>
    </div>
</template>

<script>
export default {
    name: "GlobalComponent",
    // props는 파라메터
    // v-bind로 전달된 initial-test는 initialTest가 됨
    // '-'를 떼고 앞글자를 대문자로 변환
    // Java의 표현 방식과 동일한 관습을 가지고 있음
    props: ['initialTest'],
    data () {
        return {
            counterValue: this.initialTest,
        }
    },
    methods: {
        addCounter () {
            this.counterValue++
        }
    }
}
</script>

<style>
    
</style>