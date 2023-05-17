<template lang="">
    <div>
        <sum-form :firstValue="3" :secondValue="4"/>
        <minus-form :firstValue="3" :secondValue="4"/>
        <double-form :receivedNumber="67"/>
        <tax-form :input-amount="1000000"/>
        <arithmetic-form :firstValue="3" :secondValue="5" :thirdValue="`+`"/>
        <arithmetic-form :firstValue="3" :secondValue="5" :thirdValue="`-`"/>
        <arithmetic-form :firstValue="3" :secondValue="5" :thirdValue="`*`"/>
        <arithmetic-form :firstValue="3" :secondValue="5" :thirdValue="`/`"/>
        <!--특수 문자 사용할때는 "`특수문자`"  이렇게 안에다가 넣어야함
        
            컴포넌트에 Props는 컴포넌트 불러올때 넣어줘야 한다.    
        -->
        


    </div>
</template>
<script>
import TaxForm from '@/components/testProblem/TaxForm.vue'
import ArithmeticForm from '@/components/testProblem/ArithmeticForm.vue'
import DoubleForm from '@/components/testProblem/DoubleForm.vue';
import MinusForm from '@/components/testProblem/MinusForm.vue';
import SumForm from '@/components/testProblem/SumForm.vue';
export default {
    components:{
        SumForm,
        MinusForm,
        DoubleForm,
        TaxForm,
        ArithmeticForm



    }
    
}
</script>
<style lang="">
    
</style>