<template lang="">
    <div>
        <!-- 1. 덧셈을 수행할 수 있는 Global Component를 만들어보세요. -->
        <global-add-component :first-value="3" :second-value="6"/>
        <!-- 2. 뺄셈을 수행할 수 있는 Local Component를 만들어보세요. -->
        <local-sub-component :firstValue="3" :secondValue="2"/>
        <!-- 3. 어떤 수를 입력하면 해당 숫자 곱하기 2의 결과를 출력하는 Local Component를 만들어보세요. -->
        <local-input-two-times-component :receivedNumber="3"/>
         <!-- 4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행할 수 있는 Local Component를 만들어봅시다. -->
        <local-calculate-component :firstValue="3" :secondValue="4" :thirdValue="'+'"/>
        <local-calculate-component :firstValue="3" :secondValue="4" :thirdValue="'-'"/>
        <local-calculate-component :firstValue="3" :secondValue="4" :thirdValue="'*'"/>
        <local-calculate-component :firstValue="3" :secondValue="4" :thirdValue="'/'"/>
         <!-- 5. Local Component 내에 checkbox가 존재합니다.
                v-bind로 전달할 데이터는 숫자입니다.
                checkbox가 체크되면 10%를 차감하는 형태로 만들어봅시다. -->
        <local-tax-bill-check-component :input-amount="100000"/>
    </div>
</template>
<script>

import GlobalAddComponent from '@/views/homeworks/globaComponent/GlobalAddComponent.vue'
import LocalSubComponent from '@/views/homeworks/localComponent/LocalSubComponent.vue'
import LocalInputTwoTimesComponent from '@/views/homeworks/localComponent/LocalInputTwoTimesComponent.vue'
import LocalCalculateComponent from '@/views/homeworks/localComponent/LocalCalculateComponent.vue'
import LocalTaxBillCheckComponent from '@/views/homeworks/localComponent/LocalTaxBillCheckComponent.vue'

export default {
    components: { GlobalAddComponent },
    components:{
        LocalSubComponent,
        LocalInputTwoTimesComponent,
        LocalCalculateComponent,
        LocalTaxBillCheckComponent

    }

}   
</script>
<style lang="">
    
</style>