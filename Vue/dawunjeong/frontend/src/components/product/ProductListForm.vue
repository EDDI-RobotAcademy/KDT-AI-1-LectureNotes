<template lang="">
    <div>
        <h2>상품 목록</h2>
        <table style="margin: 10px;">
            <tr>
                <th align="center" width="10%">상품번호</th>
                <th align="center" width="10%">상품이미지</th>
                <th align="center" width="70%">상품명</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="4">
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productId">
                <td align="center">
                    {{ product.productId }}
                </td>
                <td align="center">
                    {{ product.image }}
                </td>
                <td align="center">
                    {{ product.name }}
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