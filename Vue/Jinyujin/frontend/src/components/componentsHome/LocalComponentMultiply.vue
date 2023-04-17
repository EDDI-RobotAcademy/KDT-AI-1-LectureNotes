<!-- 3. 어떤 수를 입력하면 해당 숫자 곱하기 2의 결과를 출력하는 Local Component를 만들어보세요. -->

<template>
    <div>
        <!-- 일단 숫자 한 개 생성 -->
        <input v-model="numberValue">
        <!-- 곱하기 버튼 클릭-->
        <button @click="multiplyNumber">곱하기2 계산</button>
        <!-- 곱셈 결과 출력 -->
        <p>곱셈 결과는 {{ multiplyResult }} 입니다.</p>
    </div>
</template>

<script>
export default {
    name: "MultiplyLocalComponent",
    props: ['numberValue'], 
    data() {
        return {
            // 숫자들 0으로 리턴
            numberValue : 0,
            multiplyResult : 0,
        }
    },
    methods: {
        multiplyNumbers() {
           this.multiplyResult = parseInt(this.numberValue) * parseInt(2) // 숫자로 계산되도록 parseInt
        }
    }
}
</script>

<style>
    
</style>