<template lang="">
    <div>
        <h2>상품 등록 페이지</h2>
        <product-register-form @submit="onSubmit"/>
    </div>
</template>

<script>
import ProductRegisterForm from '@/components/evaluaition/product/ProductRegisterForm.vue';
import { mapActions } from 'vuex';

const productModule = 'productModule'

export default {
    components: {
        ProductRegisterForm
    },
    methods: {
        ...mapActions(productModule, ['requestCreateProductToSpring']),
        async onSubmit (payload) {
            const {email, productName, productPrice} = payload
            await this.requestCreateProductToSpring({email, productName, productPrice})
        }
    }
}
</script>

<style lang="">
    
</style>