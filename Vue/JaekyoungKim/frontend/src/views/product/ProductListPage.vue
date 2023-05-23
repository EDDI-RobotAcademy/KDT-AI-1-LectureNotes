<template lang="">
    <div>
        <h2>상품 게시판</h2>
        <div style="text-align:left; margin:15px;"></div>
        
        <product-list-form :products="products"/>
    
    </div>
    
</template>
<script>
import ProductListForm from '@/components/product/ProductListForm.vue'
import { mapActions, mapState } from 'vuex';
const productModule='productModule'
export default {
    components:{ProductListForm}, 
    computed: {
        ...mapState(productModule, ['products']),
    },
    
    mounted () {
        // vuex의 action 호출
       this.requestProductListToSpring()
    },
    methods: {
        // vuex의 action을 method에 맵핑
        ...mapActions(
            productModule, ['requestProductListToSpring']
        )
    },
   
}
</script>
<style lang="">
    
</style>