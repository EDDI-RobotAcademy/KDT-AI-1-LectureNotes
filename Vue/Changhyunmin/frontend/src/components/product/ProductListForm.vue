<template lang="">
    <div>
        <h3>상품 목록</h3>
        <table>
            <tr>
                <th width="6%">상품 번호</th>
                <th width="70%">상품명</th>
                <th width="10%">상품 가격</th>
            </tr>
            <!-- v-if 만약 products가 0이거나 products가 아닌경우 -->
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <!-- colspan: 줄 병합 -->
                <td colspan="3">
                    현재 등록된 게시물이 없습니다.
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productId">
                <!-- 위에서 부터 상품번호, 상품명, 상품가격을 보여주고있다. -->
                <td>
                    {{product.productId}}
                </td>
                <td>
                    <router-link :to="{
                        name: 'ProductReadPage',
                        params: {productId: product.productId.toString() }}">
                        {{ product.productname }}
                    </router-link>
                </td>
                <td>
                    {{ product.price }}
                </td>
            </tr>
            <!-- tr 이 부분까지는 글이 작성해야 보인다!! -->
        </table>
    </div>
</template>
<script>
export default {
    props: {
        product: {
            type: Array
        }
    },
    
}
</script>
<style lang="">
    
</style>