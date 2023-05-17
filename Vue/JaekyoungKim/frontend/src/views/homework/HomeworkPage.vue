<template>
    <div>
        <local-diploic :receiveNumber="3"/>
        <local-minus :numberA="3" :numberB="1"/>
       <ten-percent :input-amount="100000"/>
       <!-- 4. 덧셈, 뺄셈, 곱셈, 나눗셈을 모두 수행할 수 있는 Local Component를 만들어봅시다. -->
       <arithmetic-component :first-value="3" :second-value="2" :third-value="`+`"/>
        <arithmetic-component :first-value="3" :second-value="2" :third-value="`-`"/>
        <arithmetic-component :first-value="3" :second-value="2" :third-value="`*`"/>
        <arithmetic-component :first-value="3" :second-value="2" :third-value="`/`"/>
    </div>
</template>
<script>
import ArithmeticComponent from '@/components/componentTest/ArithmeticComponent.vue';
import LocalDiploic from '@/components/componentTest/LocalDiploic.vue';
import LocalMinus from '@/components/componentTest/LocalMinus.vue';
import TenPercent from '@/components/componentTest/TenPercent.vue';
export default {
    components:{
        'local-diploic':LocalDiploic,
        'local-minus':LocalMinus,
        'ten-percent': TenPercent,
        'arithmetic-component':ArithmeticComponent
    },
}
</script>
<style>
    
</style>