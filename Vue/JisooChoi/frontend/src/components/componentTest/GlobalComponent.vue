<template>
    <div>
        <button @click="addCounter">{{ counterValue }}</button>
    </div>
</template>

<script>
export default {
    name : "GlobalComponent",
    // props가 바로 파라미터이다.
    // v-bind로 전달된 initial-test는 initialTest가 된다.
    // '-'를 떼고 앞글자를 대문자로 변환한다.
    // Java의 표현 방식과 동일한 관습을 가지고 있다.
    props: ['initialTest'], /* 매개변수 */
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