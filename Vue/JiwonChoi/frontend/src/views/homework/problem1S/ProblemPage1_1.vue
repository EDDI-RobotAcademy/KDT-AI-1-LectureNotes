<template lang="">
    <div>
        <!-- 1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요. -->
        <global-add-component2 :first-value="4" :second-value="7" :third-value="3"/>

        <!-- 2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요. -->
        <local-sub-component2 :first-value="10" :second-value="2" :third-value="1"/>

        <!-- 3. 어떤 수를 입력하면 해당 숫자 곱하기 2의->제곱의 결과를 출력하는 Local Component를 만들어보세요. -->
        <local-input-two-times-component2 :receivedNumber="3"/>

        <!-- 4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행할 수 있는 Local Component를 만들어봅시다. -->
        <local-calculate-component2 :first-value="6" :second-value="2" :third-value="'*'" :fourth-value="'+'"/>

        <!-- 5. Local Component 내에 checkbox가 존재합니다.
                v-bind로 전달할 데이터는 숫자입니다.
                checkbox가 체크되면 10%를 차감하는 형태로 만들어봅시다. -->
        <local-tax-bill-check-component2 :inputAmount="10000"/>        
        
    </div>
</template>

<script>
import LocalSubComponent2 from '@/components/homework/problem1S/LocalSubComponent2.vue'
import LocalInputTwoTimesComponent2 from '@/components/homework/problem1S/LocalInputTwoTimesComponent2.vue'
import LocalCalculateComponent2 from '@/components/homework/problem1S/LocalCalculateComponent2.vue'
import LocalTaxBillCheckComponent2 from '@/components/homework/problem1S/LocalTaxBillCheckComponent2.vue'
export default {
    components: {
        LocalSubComponent2,
        LocalInputTwoTimesComponent2,
        LocalCalculateComponent2,
        LocalTaxBillCheckComponent2
    }
    
}
</script>

<style lang="">
</style>