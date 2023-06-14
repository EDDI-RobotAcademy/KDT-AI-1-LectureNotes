<template lang="">
    <div>
        <h2>상품 수정</h2>
        <product-modify-form v-if="product" :product="product" @submit="onSubmit()"/>
        <p v-else>로딩중 .....</p>
    </div>
</template>
<script>
import ProductModifyForm from '@/components/product/ProductModifyForm.vue'
import { mapState,mapActions } from 'vuex';

const productModule = 'productModule'
export default {
    components: {ProductModifyForm},
    props: {
        productid: {
            type: String,
            required: true,
        }
    },
    computed:{
        ...mapState(productModule, ['product'])
    },
    methods: {
        ...mapActions(
            productModule, ['requestProductToSpring','requestProductModifyToSpring']
        ),
        async onSubmit(payload){
            const {productName, price} = payload
            const productId = this.productId

            await this.requestProductModifyToSpring({productName, price, productId})
            await this.$router.push({
                name: 'ProductReadPage',
                params: { productId: this.productId }
            })
        }
    },
    created() {
        this.requestProductToSpring(this.productId)
    },
}
</script>
<style lang="">
    
</style>