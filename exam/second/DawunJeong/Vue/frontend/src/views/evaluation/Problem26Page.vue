<template lang="">
    <div>
        <h2>상품 목록 페이지</h2>
        <v-btn @click="productListPage">상품 리스트 보기</v-btn>
    </div>
</template>
<script>
import router from '@/router'
export default {
    methods: {
        productListPage() {
            router.push('/product-list-page')
        }
    }
}
</script>
<style lang="">
    
</style>