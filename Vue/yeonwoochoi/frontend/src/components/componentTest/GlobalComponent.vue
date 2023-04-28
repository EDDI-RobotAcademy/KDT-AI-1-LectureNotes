<template>
    <div>
        <button @click="addCounter">{{ counterValue }}</button>
    </div>
</template>

<script>
export default {
    name: "GlobalComponent",
    // props가 바로 파라메터입니다.
    // v-bind로 전달된 intial-test는 intialtest가 됩니다.
    // '-' 를 떼고 앞글자를 대문자로 변환합니다.
    // Java의 표현 방식과 동일한 관습을 가지고 있습니다. 
    props: ['initialTest'],
    data () {
        return {
            // counterValue에 값을 대입
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