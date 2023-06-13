<template lang="">
    <div>
        <h3>상품 목록</h3>
        <table>
            <tr>
                <th align="center" width="5%">번호</th>
                <th align="center" width="70%">제목</th>
                <th align="center" width="25%">등록일자</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="4">
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="(product, index) in products" :key="index">
                <td align="center">
                    {{ product.productId }}
                </td>
                <td align="center">
                    {{ product.productName }}
                </td>
                <td align="center">
                    {{ product.createDate }}
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