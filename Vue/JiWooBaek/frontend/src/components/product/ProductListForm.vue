<template lang="">
    <div>
        <h3>상품 목록</h3>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="6%">상품 번호</th>
                <th align="center" width="70%">상품명</th>
                <th align="center" width="10%">상품 가격</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="3">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productId">
                <td align="center">
                    {{ product.productId }}
                </td>
                <td align="center">
                    <router-link :to="{ 
                        name: 'ProductReadPage', 
                        params: { productId: product.productId.toString() }}">
                            {{ product.productName }}
                    </router-link>
                </td>
                <td align="center">
                    {{ product.price }}
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    props: {
        products: {
            type: Array
        }
    }
}

</script>

<style lang="">


</style>
   