<template lang="">
   <div>
        <h3>상품 목록</h3>
        <table style="margin: 5px; border:3px">
            <tr>
                <th align="center" width="5%">상품 코드</th>
                <th align="center" width="30%">제품 명</th>
                <th align="center" width="15%">상품 가격</th>
                <th align="center" width="10%">제조사</th>
                <th align="center" width="15%">유통기한</th>
                <th align="center" width="15%">제조일</th>
                <th align="center" width="10%">카테고리</th>
            </tr>
            <tr v-if="!products || (Array.isArray(products) && products.length === 0)">
                <!--products 비어있으면 등록된 게시물이 없다고 표출해줌-->
                <br><td colspan="4"> 
                    현재 등록된 상품이 없습니다!
                </td>
            </tr>
            <tr v-else v-for="product in products" :key="product.productId">
                <!--그게 아니고 보드가 비어있지 않으면 products 내부의  product 갯수만큼 반복해서 표출해줌-->
                <td align="center">
                    {{ product.productId }}
                </td>
                <td align="center">
                    <router-link :to="{ 
                        name: 'ProductReadPage', 
                        params: { productId: product.productId.toString() }}">
                             {{ product.name }}제목을 누르면 해당 게시물을 읽을 수 있도록 만들어준 것
                    </router-link> 
                </td>
                <td align="center">
                    {{ product.price }}
                </td>
                <td align="center">
                    {{ product.company }}
                </td>
                
                <td align="center">
                    {{ product.expDate }}
                    <!--productId- ID
                        name은 제품 명
                        price- 가격
                        company- 제조사
                        expDate- 유통기한
                        manufactureDate-제조일자
                         합니다.-->
                </td>
                <td align="center">
                    {{ product.manufactureDate }}
                </td>
                <!--이 때 상품은 상품명, 상품 가격, 제조사, 유통기한, 제조일, 상품 카테고리 등등을 표현해주세요.
등록, 수정, 삭제, 목록보기, 읽기가 모두 가능해야 합니다.-->
            </tr>
        </table>
        <router-link to="/product-modify-form">수정</router-link>
    </div>
</template>
<script>
export default {
    props:{
        products:{
            type:Array
        }
    }
    
}
</script>
<style lang="">
    
</style>