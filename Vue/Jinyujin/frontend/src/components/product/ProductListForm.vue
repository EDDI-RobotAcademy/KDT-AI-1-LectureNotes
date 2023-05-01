<template lang="">
    <div>
        <h3>상품 목록</h3>
        <p></p>
        <table>
            <tr>
                <td align="center" width="2%">상품명</td>
                <td align="center" width="2%">상품가격</td>
                <td align="center" width="2%">제조사</td>
                <td align="center" width="2%">유통기한</td>
                <td align="center" width="2%">제조일</td>
            </tr>
            <p></p>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="5">
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productId">
                <td>
                    {{ product.productId }}
                </td>
                <td>
                    <router-link :to="{
                        name: 'ProductReadPage',
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
    props: {
        products: {
            type: Array
        }
    }

}
</script>
<style lang="">
    
</style>