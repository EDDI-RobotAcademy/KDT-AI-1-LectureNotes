<template lang="">
    <div>
        <h2>상품 게시판</h2>
        <div v-if="isBusiness" style="text-align: left; margin: 15px;">
            <router-link :to="{ name: 'Problem23' }">
                게시물 작성
            </router-link>
        </div>
        <product-list-form :products="products"/>
    </div>
</template>
<script>

import { mapActions, mapState } from 'vuex';
import ProductListForm from '@/components/problem21Component/ProductListForm.vue';

const productModule = 'productModule'
export default {
    data() {
        return {
            isBusiness: 'false',
        }
    },
    components: { ProductListForm },
    computed: {
        ...mapState(productModule, ['products']),
    },
    async mounted() {
        await this.requestProductListToSpring()
        this.isBusiness = localStorage.getItem("isBusiness")
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