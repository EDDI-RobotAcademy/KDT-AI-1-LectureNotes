<!-- 2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요. -->

<template>
    <div>
        <!-- 일단 숫자 두 개 생성 -->
        <input v-model="numberValue1">
        <input v-model="numberValue2">
        <!-- 빼기 버튼 클릭-->
        <button @click="subtractNumbers">뺄셈계산</button>
        <!-- 뺄셈 결과 출력 -->
        <p>뺄셈 결과는 {{ subtractResult }} 입니다.</p>
    </div>
</template>

<script>
export default {
    name: "SubtractLocalComponent",
    props: ['numberValue1', 'numberValue2'], // java 파라메터 대신 props
    data() {
        return {
            // 숫자들 0으로 리턴
            numberValue1 : 0,
            numberValue2 : 0,
            subtractResult : 0,
        }
    },
    methods: {
        subtractNumbers() {
           this.subtractResult = parseInt(this.numberValue1) - parseInt(this.numberValue2) // 숫자로 계산되도록 parseInt
        }
    }
}
</script>

<style>
    
</style>