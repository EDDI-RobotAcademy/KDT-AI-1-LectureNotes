<template lang="">
    <div>
        <!-- 1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요. -->
        <global-add-component :first-value = "3" :second-value= "7"/>
        <!-- 2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요. -->
        <local-subtract-component :first-value = "7" :second-value= "2"/>
        <!-- 3. 어떤 수를 입력하면 해당 숫자 곱하기 2의 결과를 출력하는 Local Component를 만들어보세요. --> 
        <local-input-two-times-component :receiveNumber = "3"/>
        <!-- 4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행할 수 있는 Local Component를 만들어봅시다. -->
        <!-- 이건 4가지 경우를 다 작성해 주어야 함 -->
        <local-calculate-component :first-value = "7" :second-value= "2" :third-value="'+'"/>
        <local-calculate-component :first-value = "7" :second-value= "2" :third-value="'-'"/>
        <local-calculate-component :first-value = "7" :second-value= "2" :third-value="'*'"/>
        <local-calculate-component :first-value = "7" :second-value= "2" :third-value="'/'"/>
        <!-- 5. Local Component 내에 checkbox가 존재합니다.
                v-bind로 전달할 데이터는 숫자입니다.
                checkbox가 체크되면 10%를 차감하는 형태로 만들어봅시다. -->
        <local-tax-bill-check-component :input-amount = "1000000"/>
    </div>
</template>

<script>

// GlobalComponent는 import를 해주지 않아도 값이 나와야 한다 (main.js에서 꼭 추가해줘야 함)
import LocalSubtractComponent from '@/components/homework/problem1/LocalSubtractComponent.vue'
import LocalInputTwoTimesComponent from '@/components/homework/problem1/LocalInputTwoTimesComponent.vue'
import LocalCalculateComponent from '@/components/homework/problem1/LocalCalculateComponent.vue'
import LocalTaxBillCheckComponent from '@/components/homework/problem1/LocalTaxBillCheckComponent.vue'

export default {
    components: { 
        LocalSubtractComponent,
        LocalInputTwoTimesComponent,
        LocalCalculateComponent,
        LocalTaxBillCheckComponent },
}
</script>

<style lang="">
    
</style>