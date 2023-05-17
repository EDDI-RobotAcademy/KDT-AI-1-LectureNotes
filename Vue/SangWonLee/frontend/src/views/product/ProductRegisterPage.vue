<template lang="">
    <div>
        <h2>상품 등록 페이지</h2>
        <!-- 디버그 -->
        <product-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import ProductRegisterForm from '@/components/product/ProductRegisterForm.vue'
import { mapActions } from 'vuex';
const productModule = 'productModule'
export default {
    components: {
        ProductRegisterForm,
    },
    name: "ProductRegisterPage",
    methods: {
        ...mapActions(
            productModule, ['requestRegisterProductToSpring']
        ),
        async onSubmit(payload) {
            const product = await this.requestRegisterProductToSpring(payload)

            await this.$router.push({
                name: 'ProductReadPage',
                params: { productId: product.data.productId.toString() }
            })
        }
    }
}
</script>

<style lang="">
    
</style>