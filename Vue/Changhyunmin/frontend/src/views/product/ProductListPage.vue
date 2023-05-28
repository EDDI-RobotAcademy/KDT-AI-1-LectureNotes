<template>
    <div>
        <h2>상품 목록 보기</h2>
        <div>
            <!-- router-link -> ProductRegisterPage -->
            <router-link :to="{ name: 'ProductRegisterPage' }" >
            상품 등록
            </router-link>
        </div>
        <product-list-form :products="products"/>
        <p>{{ output }}</p> 
    </div>
</template>
<script>
import ProductListForm from '@/components/product/ProductListForm.vue'
import { mapActions, mapState } from 'vuex';

const productModule = 'productModule'

export default {
    components: { ProductListForm },
    data() {
        return {            
        }
    },
    computed:{
        ...mapState(productModule,['products']),
        output (){
            console.log('이런식으로 활용도 가능')
        }
    },
    mounted() {
        this.requestProductListToSpring
    },
    methods: {
        ...mapActions(
            productModule, ['requestProductListToSpring']
        )
    },

}
</script>
<style>
    
</style>