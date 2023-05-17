<template>
    <div>
        <!--1.덧셈을 수행할 수 있는 Global Componet를 만들어보자-->
        <global-add-component :firstValue="3" :secondValue="7"/>
        <!-- 2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요. -->
        <local-sub-component :firstValue="10" :secondValue="5"/>
        <!-- 3. 어떤 수를 입력하면 해당 숫자 곱하기 2의 결과를 출력하는 Local Component를 만들어보세요. -->
        <local-input-two-times-component :receivedNumber="3"/>
        <!-- 4. 사칙연산 결과를 출력하는 Local Component를 만들어보세요. -->
        <local-calculate-component :firstValue="1" :secondValue="2" :thirdValue="'+'"/>
        <local-calculate-component :firstValue="1" :secondValue="2" :thirdValue="'-'"/>
        <local-calculate-component :firstValue="1" :secondValue="2" :thirdValue="'*'"/>
        <local-calculate-component :firstValue="1" :secondValue="2" :thirdValue="'/'"/>
        <!--5. Local Component 내에 checkbox가 존재합니다.
             v-bind로 전달할 데이터는 숫자입니다.
             checkbox가 체크되면 10%를 차감하는 형태로 만들어봅시다.
        -->
        <local-taxbil-component :inputAmount="1000000" />
    </div>
</template>
<script>

import LocalSubComponent from '@/components/homework/problem1/LocalSubComponent.vue';
import LocalInputTwoTimesComponent from "@/components/homework/problem1/LocalInputTwoTimesComponent.vue"
import LocalCalculateComponent from "@/components/homework/problem1/LocalCalculateComponet.vue"
import LocalTaxbilComponent from "@/components/homework/problem1/LocalTaxbilComponent.vue"
export default {
    components: { 
        LocalSubComponent,
        LocalInputTwoTimesComponent,
        LocalCalculateComponent,
        LocalTaxbilComponent,
     }
}
</script>
<style>
    
</style>