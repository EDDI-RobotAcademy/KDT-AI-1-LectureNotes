<template lang="">
    <div>
        <h2>상품 게시판</h2>
        <!--
        <router-link :to="{ name: '' }">
            게시물 작성
        </router-link> -->
        <product-list-form :products="products"/>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import ProductListForm from '@/components/product/ProductListForm.vue'
const productModule = 'productModule'
export default {
    components: { ProductListForm },
    // state 관리자인 vuex에 state값(boards)를 모니터링
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
    }
}
</script>

<style lang="">
    
</style>