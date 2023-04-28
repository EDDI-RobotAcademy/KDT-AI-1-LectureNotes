<!-- 2. input 창에 입력한 숫자가 짝수인지 홀수인지 판정해봅시다. -->

<template lang="">
    <div>
        <label>
            <input type="text" v-model="someNumber">
        </label>
        <div v-if="someNumber % 2 === 0"> 
            <!-- 
                v-if=" " 이게 표현 방식!
                그리고 자바 스크립트에서 == -> === 이라고 해야함
            -->
            <p>짝수입니다</p>
        </div>
        <div v-else>
            <p>홀수입니다</p>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            someNumber: 0
        }
    },
}
</script>

<style lang="">
</style>