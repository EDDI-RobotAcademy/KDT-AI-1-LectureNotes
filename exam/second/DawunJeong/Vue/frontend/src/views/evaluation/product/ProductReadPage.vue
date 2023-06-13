<template lang="">
    <div>
        <h2>상품 상세 페이지</h2>
        <product-read-form v-if="product" :product="product"/>
        <p v-else>로딩중 .......</p>
        <p><v-btn>구매하기</v-btn></p>
        <router-link :to="{ name: 'ProductListPage' }">
            돌아가기
        </router-link>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import ProductReadForm from '@/components/evaluaition/product/ProductReadForm.vue';

const productModule = 'productModule'

export default {
    components: {
        ProductReadForm
    },
    props: {
        id: {
            type: String,
            required: true,
        },
    },
    computed: {
        ...mapState(productModule, ['product'])
    },
    methods: {
        ...mapActions(
            productModule, ['requestProductToSpring']
        ),
    },
    created () {
        this.requestProductToSpring(this.id)
    }
}
</script>

<style lang="">
    
</style>