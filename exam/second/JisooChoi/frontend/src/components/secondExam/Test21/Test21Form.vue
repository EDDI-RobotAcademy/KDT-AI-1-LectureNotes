<template lang="">
    <div>
        <h3>상품 목록</h3>
        <table style="margin: 10px">
        <tr>
            <th align="center" width="6%">번호</th>
            <th align="center" width="70%">상품명</th>
            <th align="center" width="10%">상품가격</th>
        </tr>
        <tr v-if="!product || (Array.isArray(product) && product.length === 0)">
            <td colspan="3">현재 등록된 상품이 없습니다!</td>
        </tr>
        <tr v-else v-for="product in product" :key="product.productId">
            <td align="center"> {{ product.productId }} </td>
        </tr>
        </table>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            
        }
    }, 
}
</script>

<style lang="">
    
</style>