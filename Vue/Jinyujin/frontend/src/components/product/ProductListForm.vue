<template lang="">
    <div>
        <h3>상품 목록</h3>
        <table>
            <tr>
                <td>상품명</td>
                <td>상품가격</td>
                <td>제조사</td>
                <td>유통기한</td>
                <td>제조일</td>
            </tr>
            <tr v-if="!products || (Arrays.isArray(products) && products.length === 0)">
                <td>
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productId">
                <td>
                    {{ product.productId }}
                </td>
                <td>
                    <router-link :to="{
                        name: 'ProductReadPage'
                        params: { productId: product.productId.toString() }}">
                        {{ product.name }}
                    </router-link>
                </td>
                <td>
                    {{ product.price }}
                </td>
                <td>
                    {{ product.expDate }}
                </td>
                <td>
                    {{ product.manufactureDate }}
                </td>
            </tr>
        </table>
    </div>
</template>
<script>
export default {
    
}
</script>
<style lang="">
    
</style>