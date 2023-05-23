<template lang="">
    <div>
        <p>숫자 입력</p>
        <input value="inputNumber" @change="handleInput">
    </div>
</template>
<script>
export default {
    data() {
        return {
            inputNumber: '숫자 입력',
        }
    },
    methods: {
        handleInput(inputNumber) {
            if (inputNumber % 2 == 0) {
                console.log('짝수')
            } else {
                console.log('홀수')
            }

        }
    },
}
</script>
<style lang="">
    
</style>