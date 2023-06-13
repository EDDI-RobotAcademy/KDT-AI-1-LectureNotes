<template lang="">
    <div>
        <h3>상품 목록</h3>
        <table>
            <tr>
                <th align="center" width="5%">번호</th>
                <th align="center" width="70%">상품명</th>
                <th align="center" width="10%">가격</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <td colspan="3">
                    현재 등록된 게시물이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.id">
                <td align="center">
                    {{ product.id }}
                </td>
                <td align="center">
                    <router-link :to="{
                        name: 'Problem26',
                        params: {id: product.id.toString()}}">
                    {{ product.name }}
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