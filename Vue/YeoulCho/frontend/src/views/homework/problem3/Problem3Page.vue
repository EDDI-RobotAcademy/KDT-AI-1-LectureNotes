<template lang="">
    <div>
        <h3><p style="text-align: left">조여울 과제</p></h3>
        <buy-product/>    
        <v-divider></v-divider>
        <br>
        <h3><p style="text-align: left">선생님 풀이</p></h3>
        <fruits-selection-form :kinds-of-fruits= "kindsOfFruits"/>
    </div>
</template>
<script>
import BuyProduct from '@/components/homework/problem3/BuyProduct.vue';
import FruitsSelectionForm from '@/components/homework/problem3/FruitsSelectionForm.vue';

export default {
    components: {
        BuyProduct,
        FruitsSelectionForm,
    },
    data(){
        return{
        kindsOfFruits: [
            {"name": "apple", "count": 3},
            {"name": "watermelon", "count": 5},
        ]
        }
    }
   
}
</script>

<style lang="">
    
</style>