<template lang="">
    <div>
        <h2>상품 게시판</h2>        
        <p></p>
        <product-list-form :products="products"/>
        <div>
        <P></P>
        <router-link :to="{ name: 'ProductRegisterPage'}">
            상품 등록
        </router-link>
        </div>
    </div>
</template>
<script>

import ProductListForm from '@/components/product/ProductListForm.vue';
import { mapActions, mapState } from 'vuex';

const productModule = 'productModule'

export default {
    components: { ProductListForm },
    computed: {
        ...mapState(productModule, ['products'])
    },
    methods: {
        ...mapActions(
            productModule, ['requestProductListToSpring']
        )
    },
    mounted() {
        this.requestProductListToSpring()
    }
}
</script>
<style lang="">
    
</style>