<!-- 
    1. 사용자가 상품명을 클릭하면 그 상품의 세부 사항을 확인할 수 있도록 합니다
       - 상품이 등록되지 않았을 때의 메세지를 띄웁니다 
       - 등록된 정보를 화면에 띄울 수 있도록 스프링에 데이터 요청합니다
 -->


<template lang="">
    <div>
        <h2>상품 세부 정보</h2>
        <product-read-form v-if="product" :product="product"/>

        <p v-else>등록된 상품이 없습니다!</p>

    </div>
</template>

<script>
import ProductReadForm from '@/components/product/ProductReadForm.vue'
import { mapActions, mapState } from 'vuex';

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
            productModule, ['requestProductToSpring']
        ),
    },
    created() {
        this.requestProductToSpring(this.productId)
    }
}
</script>

<style lang="">
</style>