<template lang="">
    <div>
        <!-- 1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요. -->
        <global-add-component :first-value="3" :second-value="7"/>
        <!-- 2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요. -->
        <local-sub-component :first-value="7" :second-value="2"/>
        <!-- 3. 어떤 수를 입력하면 해당 숫자 곱하기 2의 결과를 출력하는 Local Component를 만들어보세요. -->
        <local-input-two-times-component :receivedNumber="3"/>
        <!-- 4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행할 수 있는 Local Component를 만들어봅시다. -->
        <local-calculate-component :first-value="3" :second-value="2" :third-value="`+`"/>
        <local-calculate-component :first-value="3" :second-value="2" :third-value="`-`"/>
        <local-calculate-component :first-value="3" :second-value="2" :third-value="`*`"/>
        <local-calculate-component :first-value="3" :second-value="2" :third-value="`/`"/>
    </div>
</template>
<script>
import GlobalAddComponent from '@/components/homework/problem1/GlobalAddComponent.vue';
import LocalSubComponent from '@/components/homework/problem1/LocalSubComponent.vue'
import LocalInputTwoTimesComponent from '@/components/homework/problem1/LocalInputTwoTimesComponent.vue'
import LocalCalculateComponent from '@/components/homework/problem1/LocalCalculateComponent.vue'


export default {
    components: { GlobalAddComponent,
                  LocalSubComponent, 
                  LocalInputTwoTimesComponent, 
                  LocalCalculateComponent,
 
    }
}
</script>
<style lang="">
    
</style>