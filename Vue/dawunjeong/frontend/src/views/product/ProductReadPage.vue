<template lang="">
    <div>
        <h2>상품 상세 페이지</h2>
        <product-read-form v-if="product" :product="product"/>
        <p v-else>로딩중 .......</p>
        <button @click="onDelete">삭제</button>
        <router-link :to="{ name: 'ProductListPage' }">
            돌아가기
        </router-link>
    </div>
</template>

<script>
import { mapActions, mapState } from 'vuex';
import ProductReadForm from '@/components/product/ProductReadForm.vue';

const productModule = 'productModule'

export default {
    components: {
        ProductReadForm
    },
    props: {
        productId: {
            type: String,
            required: true,
        },
    },
    computed: {
        ...mapState(productModule, ['product'])
    },
    methods: {
        ...mapActions(
            productModule, ['requestProductToSpring', 'requestDeleteProductToSpring']
        ),
        async onDelete () {
            await this.requestDeleteProductToSpring(this.productId)
            await this.$router.push({ name: 'ProductListPage' })
        }
    },
    created () {
        this.requestProductToSpring(this.productId)
    }
}
</script>

<style lang="">
    
</style>