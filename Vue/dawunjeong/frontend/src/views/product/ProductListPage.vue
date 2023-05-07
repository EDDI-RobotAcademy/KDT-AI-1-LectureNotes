<template lang="">
    <div>
        <h2>상품 목록 페이지</h2>
        <div style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'ProductRegisterPage' }">
                상품 등록
            </router-link>
        </div>
        <product-list-form :products="products"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import ProductListForm from '@/components/product/ProductListForm.vue';

const productModule = 'productModule'

export default {
    components: {
        ProductListForm
    },
    computed: {
        ...mapState(productModule, ['products']),
    },
    mounted () {
        this.requestProductListToSpring()
    },
    methods: {
        ...mapActions(
            productModule, ['requestProductListToSpring']
        )
    }
}
</script>

<style lang="">
    
</style>