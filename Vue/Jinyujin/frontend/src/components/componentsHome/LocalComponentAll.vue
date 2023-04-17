<!-- 4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행할 수 있는 Local Component를 만들어봅시다. -->

<template>
    <div>
        <!-- 일단 숫자 두 개 생성 -->
        <input v-model="numberValue1">
        <input v-model="numberValue2">
        <!-- 버튼 클릭-->
        <button @click="plusNumbers">덧셈계산</button>
        <button @click="subtractNumbers">뺄셈계산</button>
        <button @click="multiplyNumbers">곱셈계산</button>
        <button @click="divideNumbers">나눗셈계산</button>
        <!-- 결과 출력 -->
        <p>결과는 {{ Result }} 입니다.</p>
    </div>
</template>

<script>
export default {
    name: "MathLocalComponent",
    props: ['numberValue1', 'numberValue2'],
    data() {
        return {
            // 숫자들 0으로 리턴
            numberValue1 : 0,
            numberValue2 : 0,
            Result : 0,
        }
    },
    methods: {
        plusNumbers() {
            this.Result = parseInt(this.numberValue1) + parseInt(this.numberValue2) 
        },
        subtractNumbers() {
           this.Result = parseInt(this.numberValue1) - parseInt(this.numberValue2) 
        },
        multiplyNumbers() {
            this.Result = parseInt(this.numberValue1) * parseInt(this.numberValue2) 
        },
        divideNumbers() {
            this.Result = parseInt(this.numberValue1) / parseInt(this.numberValue2) 
        },
    }
}
</script>

<style>
    
</style>